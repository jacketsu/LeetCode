class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String preFix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(preFix)) {                            //lib
                preFix = preFix.substring(0, preFix.length() - 1);
            }
        }
        
        return preFix;
    }
}
