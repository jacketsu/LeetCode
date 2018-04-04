// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

// Example 1:
// Given the following words in dictionary,

// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".

// Example 2:
// Given the following words in dictionary,

// [
//   "z",
//   "x"
// ]
// The correct order is: "zx".

// Example 3:
// Given the following words in dictionary,

// [
//   "z",
//   "x",
//   "z"
// ]
// The order is invalid, so return "".

// Note:
// You may assume all letters are in lowercase.
// You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.
// 
// 




class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    char c1 = cur[j];
                    char c2 = next[j];
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (set.add(c2)) {
                        map.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);             //duplicate addition
                    }
                    break;
                }
            }
        }
        
        String res = "";
        Queue<Character> q = new LinkedList<>();
        
        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.offer(key);
            }
        }
        
        while (!q.isEmpty()) {
            char pop = q.poll();
            res += pop;
            if (map.containsKey(pop)) {
                Set<Character> set = map.get(pop);
                for (char c : set) {
                    indegree.put(c, indegree.get(c) - 1);
                    if (indegree.get(c) == 0) q.offer(c);
                }
            }
        }
        
        if (res.length() != indegree.size()) return "";
        return res;
    }
}