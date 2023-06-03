public class Stack <T>{
    private Node<T> arriba;
    private int size;

    public Stack(){
        this.arriba= null;
        this.size = 0;
    }
    //Comprueba si esta pila está vacía.
    public boolean empty(){
        return size == 0;
    }
    //Empuja un elemento a la parte superior de esta pila.
    public void push(T dato){
        Node <T> nuevoNodo = new Node<>(dato);
        if(empty()){
            arriba = nuevoNodo;
        }else{
            nuevoNodo.setNode((T) arriba);
            arriba = nuevoNodo;

        }
        size++;
    }
    //Mira el objeto en la parte superior de esta pila sin sacarlo de la pila.
    public T peek() {
        if (empty()) {
            System.out.println("La pila esta vacia");
        }
        return arriba.getNode();
    }
    //Elimina el objeto en la parte superior de esta pila y devuelve ese objeto como el valor de esta función.
    public T pop() {
        if (empty()) {
            System.out.println("La pila esta vacia");
        }
        T data = arriba.getNode();
        arriba = arriba.getNextNode();
        size--;
        return data;
    }
    //Devuelve la posición basada en 1 donde se encuentra un objeto en esta pila.
    public int search(T element) {
        Node<T> currentNode = arriba;
        int index = 1;

        while (currentNode != null) {
            if (currentNode.getNode().equals(element)) {
                return index;
            }

            currentNode = currentNode.getNextNode();
            index++;
        }

        return -1;
    }
}
