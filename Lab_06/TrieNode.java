public class TrieNode {

    private TrieNode[] children; 
    private boolean isEndWord; 

    public TrieNode() {
        this.children = new TrieNode[128];
        this.isEndWord = false;
    }

    public boolean isEndWord() {
        return isEndWord;
    }

    public void setEndWord(boolean endWord) {
        isEndWord = endWord;
    }

    public TrieNode getChild(char c) {
        return children[c];
    }

    public void setChild(char c, TrieNode node) {
        children[c] = node;
    }
}