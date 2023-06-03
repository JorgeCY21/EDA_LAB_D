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
    
}
