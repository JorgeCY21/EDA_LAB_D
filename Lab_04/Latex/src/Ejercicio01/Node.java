class Node<T> {
    private T element; // Elemento almacenado en el nodo
    private Node<T> nextNode; // Referencia al siguiente nodo

    public Node(T element) {
        this.element = element; // Inicializa el nodo con el elemento especificado
        nextNode = null; // Establece el siguiente nodo como null
    }

    public T getElement() {
        return element; // Retorna el elemento almacenado en el nodo
    }

    public void setElement(T element) {
        this.element = element; // Establece el elemento del nodo
    }

    public Node<T> getNextNode() {
        return nextNode; // Retorna el siguiente nodo
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode; // Establece el siguiente nodo
    }
}
