import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // Declaración de variables privadas de la clase TrieNode.
    private TrieNode[] children; // Arreglo que representa los hijos del nodo, uno por cada carácter ASCII.
    private boolean isEndOfWord; // Variable booleana para indicar si este nodo representa el final de una palabra.

    // Constructor de la clase TrieNode.
    public TrieNode() {
        // Inicialización del arreglo de hijos, con capacidad para 128 caracteres ASCII (0-127).
        this.children = new TrieNode[128];
        // Inicialización de la variable isEndOfWord en falso, ya que el nodo no representa el final de una palabra por defecto.
        this.isEndOfWord = false;
    }

    // Método que devuelve si este nodo es el final de una palabra o no.
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    // Método que establece si este nodo es el final de una palabra o no.
    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    // Método para obtener el nodo hijo correspondiente a un carácter ASCII específico.
    public TrieNode getChild(char c) {
        return children[c];
    }

    // Método para establecer el nodo hijo correspondiente a un carácter ASCII específico.
    public void setChild(char c, TrieNode node) {
        children[c] = node;
    }
}