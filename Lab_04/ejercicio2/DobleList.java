package lab4;

public class DobleList<E> {
    private Node<E> head;
    
    public DobleList(){
        this.head  = null;
    }

    public boolean isEmpty(){
        return head == null;
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
        }
        else{
            newnode.setPreviousNode(newnode);
            
        }
    }

    @Override
    public String toString(){
        Node<E> nodos = head;
        String cadena=null;
        while (nodos != null){
            cadena+=nodos.getData().toString()+" ";
            nodos = nodos.getNextNode();
        }
        return cadena;
    }
}
