class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();                    //have to be in this way to initialize
        if (digits == null || digits.length() == 0) return res;
        String[] mappings = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String s = res.remove();
                for (char ch : mappings[x].toCharArray()) {
                    res.add(s + ch);
                }
            }
        }
        
        return res;
    }
}
