class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.getChild(c) == null) {
                current.setChild(c, new TrieNode());
            }
            current = current.getChild(c);
        }
        current.setIsEndWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChild(c);
            if (current == null) {
                return false;
            }
        }
        return current.isEndWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.getChild(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }
}