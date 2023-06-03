
import myExceptions.NoSuchElementException;
import myExceptions.NullPointerException;

public class Queue<E> implements QueueList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int count;

	public Queue() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	private boolean isEmpty() {
		return this.count == 0;
	}

	public boolean add(E e) throws NullPointerException {
		if (e == null) {
			throw new NullPointerException("");
		}

		Node<E> newNode = new Node<>(e);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}

		this.count++;
		return true;
	}

	public E element() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("La cola está vacía");
		}

		return this.head.getData();
	}

	public boolean offer(E e) {
		try {
			return this.add(e);
		} catch (NullPointerException n) {
			return false;
		}
	}

	public E peek() {
		if (this.isEmpty()) {
			return null;
		}

		return this.head.getData();
	}

    public E poll() {
		if (this.isEmpty()) {
			return null;
		}

		E data = this.head.getData();
		this.head = this.head.getNext();
		this.count--;

		if (this.isEmpty()) {
			this.tail = null;
		}

		return data;
	}

    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }

}
