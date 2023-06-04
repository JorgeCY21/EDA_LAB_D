
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
			throw new NullPointerException("El elemento que quiere ingresar es null");
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

    public E remove() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("La cola está vacía");
		}

		E data = this.head.getData();
		this.head = this.head.getNext();
		this.count--;

		if (this.isEmpty()) {
			this.tail = null;
		}

		return data;
	}

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		Node<E> aux = this.head;

		while (aux != null) {
			sb.append(aux.toString());
			aux = aux.getNext();

			if (aux != null) {
				sb.append(", ");
			}
		}

		sb.append("]");

		return sb.toString();
	}
}
