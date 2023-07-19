public class TrieNode {

    private TrieNode[] children; 
    private boolean isEndOfWord; 

    public TrieNode() {
        this.children = new TrieNode[128];
        this.isEndOfWord = false;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public TrieNode getChild(char c) {
        return children[c];
    }

    public void setChild(char c, TrieNode node) {
        children[c] = node;
    }
}