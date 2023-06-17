package lab4;

public class DobleList<E extends Comparable<E>> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public DobleList(){
        this.head  = null;
    }

    public boolean isEmpty(){
        return head == null && tail ==null;
    }
    public void insertAlInicio(E data){
        Node<E> newnode = new Node<E>(data);
        if (isEmpty())
            head = newnode;
        else{
            newnode.setNextNode(head);
            head.setPreviousNode(newnode);
            head = newnode;
        }
    }
    public void insertFinal(E data){
        Node<E> newnode = new Node<E>(data);
        if(isEmpty()){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.setNextNode(newnode);
            tail = newnode;
        }
    }
    public int size(){
        return size;
    }
    
    public void generarPeoresCasos(){
        if (isEmpty() || size==1){
            System.out.println("La lista no tiene nada que ordenar");; 
        }
        else{
            Node<E> nodoActual = head;
            while (nodoActual != null){
                Node<E> minNode = nodoActual;
                Node<E> comparerNode = nodoActual.getNextNode();
                while(comparerNode != null){
                    if(comparerNode.getData().compareTo(minNode.getData())>0){
                        minNode=comparerNode;
                    }
                    comparerNode = comparerNode.getNextNode();
                }
                swapNodes(nodoActual,minNode);
                nodoActual = nodoActual.getNextNode();
            }
        }
    }
    
    public void selecctionSort(){
        if (isEmpty() || size==1){
            System.out.println("La lista no tiene nada que ordenar");; 
        }
        else{
            Node<E> nodoActual = head;
            while (nodoActual != null){
                Node<E> minNode = nodoActual;
                Node<E> comparerNode = nodoActual.getNextNode();
                while(comparerNode != null){
                    if(comparerNode.getData().compareTo(minNode.getData())<0){
                        minNode=comparerNode;
                    }
                    comparerNode = comparerNode.getNextNode();
                }
                swapNodes(nodoActual,minNode);
                nodoActual = nodoActual.getNextNode();
            }
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
