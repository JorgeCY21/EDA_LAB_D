public class LinkedList<T extends Comparable<T>> {
	private Node<T> raiz;
	private int tamano;

	public LinkedList() {
		raiz = null;
		tamano = 0;
	}

	public void insert(T elemento) {
		Node<T> nuevoNodo = new Node<>(elemento);
		if (raiz == null) {
			raiz = nuevoNodo;
		} else {
			Node<T> nodoActual = raiz;
			while (nodoActual.getNextNode() != null) {
				nodoActual = nodoActual.getNextNode();
			}
			nodoActual.setNextNode(nuevoNodo);
		}
		tamano++;
	}

	public Node<T> get(int indice) {
		Node<T> aux = raiz;
		for (int i = 0; i < indice; i++) {
			aux = aux.getNextNode();
		}
		return aux;
	}

	public void remove(int indice) {
		if (indice < tamano) {
			if (indice == 0)
				raiz = raiz.getNextNode();
			else {
				Node<T> anterior = this.get(indice - 1);
				anterior.setNextNode(this.get(indice + 1));
			}
			tamano--;
		}
	}

	public void selectionSort() {
		Node<T> nodoActual = raiz;
		while (nodoActual != null) {
			Node<T> nodoMinimo = nodoActual;
			Node<T> nodoComparador = nodoActual.getNextNode();
			while (nodoComparador != null) {
				if (nodoComparador.getElement().compareTo(nodoMinimo.getElement()) < 0) {
					nodoMinimo = nodoComparador;
				}
				nodoComparador = nodoComparador.getNextNode();
			}
			swapNodes(nodoActual, nodoMinimo);
			nodoActual = nodoActual.getNextNode();
		}
	}

	private void swapNodes(Node<T> nodoA, Node<T> nodoB) {
		T temp = nodoA.getElement();
		nodoA.setElement(nodoB.getElement());
		nodoB.setElement(temp);
	}

	public void printLinkedList() {
		Node<T> nodoActual = raiz;
		while (nodoActual != null) {
			System.out.print(nodoActual.getElement() + " ");
			nodoActual = nodoActual.getNextNode();
		}
		System.out.println();
	}
}
