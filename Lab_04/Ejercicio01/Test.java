public class Test {
    
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    int size = 10000;
    for (int i = size; i > 0; i--) {
      linkedList.insert(i);
    }

    System.out.println("Lista original:");
    linkedList.printLinkedList();

    long startTime = System.currentTimeMillis();

    linkedList.selectionSort();

    long endTime = System.currentTimeMillis();

    System.out.println("Lista ordenada:");
    linkedList.printLinkedList();

    long elapsedTime = endTime - startTime;
    System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
  }
}
