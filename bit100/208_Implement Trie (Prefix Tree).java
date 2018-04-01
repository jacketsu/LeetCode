// Implement a trie with insert, search, and startsWith methods.

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

// Seen this question in a real interview before?  


class Trie {
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        public TrieNode(char c) {
            this.val = c;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
        this.root.val = ' ';
    }
    
    public void insert(String word) {
        TrieNode ws = this.root;
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = this.root;
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        
        return ws.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws = this.root;
        for (char c : prefix.toCharArray()) {
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */