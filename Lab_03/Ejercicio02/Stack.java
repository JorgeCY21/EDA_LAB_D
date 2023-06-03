public class Stack <T>{
    private Node arriba;
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
    public void push(T data){
        Node <T> nuevoNodo = new Node<>(data);
        if(empty()){
            arriba = nuevoNodo;
        }else{
            arriba = setNode(arriba);
            size++;
        }        
    }
    //Mira el objeto en la parte superior de esta pila sin sacarlo de la pila.
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
        }
        return arriba.getData();
    }
    //Elimina el objeto en la parte superior de esta pila y devuelve ese objeto como el valor de esta función.
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
        }
        T data = arriba.getData();
        arriba = arriba.getNextNode();
        size--;
        return data;
    }
     //Devuelve la posición basada en 1 donde se encuentra un objeto en esta pila.
     public int search(T element) {
        Node<T> currentNode = top;
        int index = 1;
    
        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                return index;
            }
    
            currentNode = currentNode.getNextNode();
            index++;
        }
    
        return -1;  // El elemento no se encuentra en la pila
    }
}
