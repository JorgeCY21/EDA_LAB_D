package lab4;

public class DobleList<E extends Comparable<E>> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DobleList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void insertAlInicio(E data) {
        Node<E> newnode = new Node<E>(data);
        if (isEmpty())
            head = newnode;
        else {
            newnode.setNextNode(head);
            head.setPreviousNode(newnode);
            head = newnode;
        }
    }

    public void insertFinal(E data) {
        Node<E> newnode = new Node<E>(data);
        if (isEmpty()) {
            head = newnode;
            tail = newnode;
        } else {
            tail.setNextNode(newnode);
            tail = newnode;
        }
    }

    public int size() {
        return size;
    }

    public void generarPeoresCasos() {
        if (isEmpty() || size == 1) {
            System.out.println("La lista no tiene nada que ordenar");
            ;
        } else {
            Node<E> nodoActual = head;
            while (nodoActual != null) {
                Node<E> minNode = nodoActual;
                Node<E> comparerNode = nodoActual.getNextNode();
                while (comparerNode != null) {
                    if (comparerNode.getData().compareTo(minNode.getData()) > 0) {
                        minNode = comparerNode;
                    }
                    comparerNode = comparerNode.getNextNode();
                }
                swapNodes(nodoActual, minNode);
                nodoActual = nodoActual.getNextNode();
            }
        }
    }

    public void insertionSort() {
        if (head == null || head.getNextNode() == null) {
            return; // La lista está vacía o tiene solo un elemento, no es necesario ordenar
        }

        Node<E> sortedTail = head; // Puntero al final de la sección ordenada de la lista

        // Iterar desde el segundo nodo hasta el final de la lista
        Node<E> currentNode = head.getNextNode();
        while (currentNode != null) {
            E currentData = currentNode.getData();

            // Buscar la posición correcta para insertar el nodo actual en la sección
            // ordenada
            Node<E> insertionPoint = sortedTail;
            while (insertionPoint != null && insertionPoint.getData().compareTo(currentData) > 0) {
                insertionPoint = insertionPoint.getPreviousNode();
            }

            // Mover los nodos para insertar el nodo actual en la posición correcta
            if (insertionPoint == null) {
                // El nodo actual debe ser el nuevo inicio de la lista
                sortedTail.setNextNode(currentNode.getNextNode());
                if (currentNode.getNextNode() != null) {
                    currentNode.getNextNode().setPreviousNode(null);
                }
                currentNode.setNextNode(head);
                head.setPreviousNode(currentNode);
                head = currentNode;
            } else {
                // Insertar el nodo actual después del punto de inserción
                sortedTail.setNextNode(currentNode.getNextNode());
                if (currentNode.getNextNode() != null) {
                    currentNode.getNextNode().setPreviousNode(sortedTail);
                }
                currentNode.setNextNode(insertionPoint.getNextNode());
                if (insertionPoint.getNextNode() != null) {
                    insertionPoint.getNextNode().setPreviousNode(currentNode);
                }
                insertionPoint.setNextNode(currentNode);
                currentNode.setPreviousNode(insertionPoint);
            }

            // Actualizar el puntero al final de la sección ordenada
            if (sortedTail.getNextNode() != null) {
                sortedTail = sortedTail.getNextNode();
            }

            // Mover al siguiente nodo para su comparación e inserción
            currentNode = sortedTail.getNextNode();
        }
    }

    private void swapNodes(Node<E> nodeA, Node<E> nodeB) {
        if (nodeA == nodeB) {
            return; // Los nodos son iguales, no es necesario intercambiar
        }

        // Intercambio de elementos
        E temp = nodeA.getData();
        nodeA.setData(nodeB.getData());
        nodeB.setData(temp);
    }

    @Override
    public String toString() {
        Node<E> currentNode = head;
        StringBuilder cadena = new StringBuilder();
        while (currentNode != null) {
            cadena.append(currentNode.getData().toString()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return cadena.toString();
    }
}
