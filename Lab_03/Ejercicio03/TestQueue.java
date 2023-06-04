
public class TestQueue {
    public static void main(String[] args) {
        try {
            Queue<Integer> queue = new Queue<>();

            // añadir elementos con add()
            queue.add(10);
            queue.add(20);
            queue.add(30);

            // imprimir la cola
            System.out.println("Cola: " + queue);

            // añadir elementos con offer()
            queue.add(40);
            queue.add(50);
            queue.add(60);

            // imprimir la cola
            System.out.println("Cola: " + queue);

            // recupera, pero no elimina, el encabezado de esta cola.
            System.out.println("Elemento al frente - sin eliminar: " + queue.element());

            // recupera, pero no elimina, el encabezado de esta cola, o regresa null si esta cola está vacía.
            System.out.println("Elemento al frente - sin eliminar: " + queue.peek());

            // recupera y elimina el encabezado de esta cola.
            System.out.println("Elemento al frente - eliminar: " + queue.remove());

            // recupera y elimina el encabezado de esta cola, o regresa nullsi esta cola está vacía.
            System.out.println("Elemento al frente - eliminar: " + queue.poll());

            // imprimiendo la cola actualizada
            System.out.println("Cola actualizada: " + queue);

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
