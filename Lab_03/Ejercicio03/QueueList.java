
import myExceptions.NoSuchElementException;

public interface QueueList<E> {

    boolean add(E e);

    E element() throws NoSuchElementException;

    boolean offer(E e);

    E peek();

    E poll();

    E remove();

}
