
import myExceptions.NoSuchElementException;
import myExceptions.NullPointerException;

public interface QueueList<E> {

	boolean add(E e) throws NullPointerException;

	E element() throws NoSuchElementException;

	boolean offer(E e);

	E peek();

	E poll();

	E remove() throws NoSuchElementException;

}
