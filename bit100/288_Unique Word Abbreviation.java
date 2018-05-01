// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

// a) it                      --> it    (no abbreviation)

//      1
// b) d|o|g                   --> d1g

//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n

//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

// Example: 
// Given dictionary = [ "deer", "door", "cake", "card" ]

// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true


class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String key = getKey(word);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(word)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, word);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        return (!map.containsKey(key) || word.equals(map.get(key)));
    }
    
    public String getKey(String word) {
        if (word.length() <= 2) return word;
        return (word.substring(0, 1) + String.valueOf(word.length() - 2) + word.substring(word.length() - 1, word.length())); 
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */