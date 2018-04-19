// Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

// Example 1:

// Input: 12
// Output: 21
 

// Example 2:

// Input: 21
// Output: -1


class Solution {
    public int nextGreaterElement(int n) {
        char[] charArr = (n + "").toCharArray();
        int i;
        for (i = charArr.length - 1; i > 0; i--) {
            if (charArr[i - 1] < charArr[i]) {
                break;
            }
        }
        //corner case
        if (i == 0) {
            return -1;
        }
        
        int x = i - 1;
        int smallest = i;
        for (int j = i + 1; j < charArr.length; j++) {
            if (charArr[j] <= charArr[smallest] && charArr[j] > charArr[x]) {
                smallest = j;
            }
        }
        
        char tmp = charArr[x];
        charArr[x] = charArr[smallest];
        charArr[smallest] = tmp;
        
        Arrays.sort(charArr, i, charArr.length);   //charArr.length,  instead of charArr.length - 1
        long lnum = Long.parseLong(new String(charArr));
        return lnum <= Integer.MAX_VALUE ? (int)lnum : -1;
    }
}