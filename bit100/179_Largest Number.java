// Given a list of non negative integers, arrange them such that they form the largest number.

// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// Note: The result may be very large, so you need to return a string instead of an integer.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.
// 
// 
// 


class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "0";
        String[] s_num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_num[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String comb1 = str1 + str2;
                String comb2 = str2 + str1;
                return comb2.compareTo(comb1);
            }
        };                                              //attention!
        
        Arrays.sort(s_num, comp);
        if (s_num[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s_num) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}