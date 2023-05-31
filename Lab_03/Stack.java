public class Stack <T>{
    private Node arriba;
    private int size;

    public Stack(){
        this.arriba= null;
        this.size = 0;
    }
    
    public boolean empty(){
        return size == 0;
    }

    public void push(T data){
        Node <T> nuevoNodo = new Node<>(data);
        if(empty()){
            arriba = nuevoNodo;
        }else{
            arriba = setNode(arriba);
            size++;
        }        
    }
    
}
