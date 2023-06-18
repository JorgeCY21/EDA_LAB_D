public class LinkedList<T extends Comparable<T>> {
	private Node<T> raiz; // Raíz o primer nodo de la lista enlazada
	private int tamano; // Tamaño actual de la lista enlazada

	public LinkedList() {
		raiz = null; // Inicializa la raíz como null al crear una nueva lista enlazada
		tamano = 0; // Inicializa el tamaño como 0 al crear una nueva lista enlazada
	}

	public void insert(T elemento) {
		Node<T> nuevoNodo = new Node<>(elemento); // Crea un nuevo nodo con el elemento especificado
		if (raiz == null) {
			raiz = nuevoNodo; // Si la lista enlazada está vacía, el nuevo nodo se convierte en la raíz
		} else {
			Node<T> nodoActual = raiz;
			while (nodoActual.getNextNode() != null) {
				nodoActual = nodoActual.getNextNode(); // Itera hasta llegar al último nodo de la lista
			}
			nodoActual.setNextNode(nuevoNodo); // Establece el siguiente nodo del último nodo como el nuevo nodo
		}
		tamano++; // Incrementa el tamaño de la lista enlazada después de la inserción
	}

	public Node<T> get(int indice) {
		Node<T> aux = raiz;
		for (int i = 0; i < indice; i++) {
			aux = aux.getNextNode(); // Itera a través de la lista hasta llegar al nodo en el índice especificado
		}
		return aux; // Retorna el nodo en el índice especificado
	}

	public void remove(int indice) {
		if (indice < tamano) {
			if (indice == 0)
				raiz = raiz.getNextNode(); // Si el índice es 0, se elimina el primer nodo (la raíz)
			else {
				Node<T> anterior = this.get(indice - 1);
				anterior.setNextNode(this.get(indice + 1)); // Establece el siguiente nodo del nodo anterior como el siguiente nodo del nodo a eliminar
			}
			tamano--; // Reduce el tamaño de la lista enlazada después de la eliminación
		}
	}

	public void selectionSort() {
		Node<T> nodoActual = raiz;
		while (nodoActual != null) {
			Node<T> nodoMinimo = nodoActual;
			Node<T> nodoComparador = nodoActual.getNextNode();
			while (nodoComparador != null) {
				if (nodoComparador.getElement().compareTo(nodoMinimo.getElement()) < 0) {
					nodoMinimo = nodoComparador; // Encuentra el nodo mínimo comparando los elementos y lo asigna como el nuevo nodo mínimo
				}
				nodoComparador = nodoComparador.getNextNode(); // Avanza al siguiente nodo en la comparación
			}
			swapNodes(nodoActual, nodoMinimo); // Intercambia los elementos de los nodos actual y mínimo
			nodoActual = nodoActual.getNextNode(); // Avanza al siguiente nodo en la lista
		}
	}

	private void swapNodes(Node<T> nodoA, Node<T> nodoB) {
		T temp = nodoA.getElement();
		nodoA.setElement(nodoB.getElement()); // Intercambia los elementos de los nodos A y B
		nodoB.setElement(temp);
	}

	public void printLinkedList() {
		Node<T> nodoActual = raiz;
		while (nodoActual != null) {
			System.out.print(nodoActual.getElement() + " "); // Imprime el elemento del nodo actual
			nodoActual = nodoActual.getNextNode(); // Avanza al siguiente nodo en la lista
		}
		System.out.println();
	}
}
