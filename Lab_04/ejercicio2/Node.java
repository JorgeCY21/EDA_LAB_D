public class Node <E> {

    private E data ;
    private Node <E > nextNode ;
    private Node <E > previousNode ;

    //Constructores
    Node () {
    this . data = null ;
    this . nextNode = null ;
    this . previousNode = null ;
    }
    Node ( E data ) {
    this . data = data ;
    this . nextNode = null ;
    this . previousNode = null ;
    }
    Node ( E data , Node <E > nextNode ) {
    this . data = data ;
    this . nextNode = nextNode ;
    this . previousNode = null ;
    }
    Node ( E data , Node <E > nextNode , Node <E > previousNode ) {
    this . data = data ;
    this . nextNode = nextNode ;
    this . previousNode = previousNode ;
    }


    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public Node<E> getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }
    public Node<E> getPreviousNode() {
        return previousNode;
    }
    public void setPreviousNode(Node<E> previousNode) {
        this.previousNode = previousNode;
    }
    
    
   }
