package lab4;

public class Node<E> {
    private E data;              // Almacena el dato del nodo
    private Node<E> nextNode;    // Referencia al siguiente nodo
    private Node<E> previousNode;// Referencia al nodo anterior

    // Constructores

    Node() {
        this.data = null;
        this.nextNode = null;
        this.previousNode = null;
    }

    Node(E data) {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }

    Node(E data, Node<E> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = null;
    }

    Node(E data, Node<E> nextNode, Node<E> previousNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    // Métodos para acceder y modificar los datos y referencias del nodo

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<E> previousNode) {
        this.previousNode = previousNode;
    }
}

