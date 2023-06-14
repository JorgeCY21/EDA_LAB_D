public class DobleList {
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
            newnode.setNextNode = head;
            head.setPreviousNode = newnode;
            head = newnode;
        }
    }
}
