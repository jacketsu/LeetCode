// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Example 1:

// Input: buf = "abc", n = 4
// Output: "abc"
// Explanation: The actual number of characters read is 3, which is "abc".
// Example 2:

// Input: buf = "abcde", n = 5 
// Output: "abcde"
// Note:
// The read function will only be called once for each test case.

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(tmp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = tmp[i];
            }
            if (n == index || count < 4) return index;
        }
    }
}