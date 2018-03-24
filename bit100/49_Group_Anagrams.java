class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String strKey = new String(chArr);
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());           //tricky, no initialization inside
    }
}
