public class Node<T>{
    private T data;
    private Node<T> nextNode;

    public Node(T data){
        this.data = data;
        this.nextNode = null;
    }
    public T getNode(){
        return data;
    }
    public void setNode(T data){
        this.data= data;
    }
    public Node<T> getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
