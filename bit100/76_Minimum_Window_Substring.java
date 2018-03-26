class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 0);
        }
        
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return "";
            } else {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        
        int i = 0, j = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);                     //should be put outside
            
            while (count == 0) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    minStart = i;
                }
                char start = s.charAt(i);
                map.put(start, map.get(start) + 1);
                if (map.get(start) > 0) count++;
                i++;                                        //keep sober mind
            }
            j++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);         //keep alert
    }
}
