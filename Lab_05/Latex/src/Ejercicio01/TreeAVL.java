
class TreeAVL<E extends Comparable<E>> {
	private NodeAvl<E> root;

	public void insert(E data) {
		this.root = insertNode(this.root, data);
	}

	private NodeAvl<E> insertNode(NodeAvl<E> node, E data) {
		if (node == null) {
			return new NodeAvl<E>(data);
		}

		if (data.compareTo(node.data) < 0) {
			node.left = insertNode(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = insertNode(node.right, data);
		} else {
			return node;
		}

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && data.compareTo(node.left.data) < 0) {
			return rotateRight(node);
		}

		if (balance < -1 && data.compareTo(node.right.data) > 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && data.compareTo(node.left.data) > 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && data.compareTo(node.right.data) < 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	public void remove(E data) {
		this.root = removeNode(this.root, data);
	}

	private NodeAvl<E> removeNode(NodeAvl<E> node, E data) {
		if (node == null) {
			return node;
		}

		if (data.compareTo(node.data) < 0) {
			node.left = removeNode(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = removeNode(node.right, data);
		} else {
			if (node.left == null || node.right == null) {
				NodeAvl<E> temp = null;
				if (temp == node.left) {
					temp = node.right;
				} else {
					temp = node.left;
				}

				if (temp == null) {
					temp = node;
					node = null;
				} else {
					node = temp;
				}
			} else {
				NodeAvl<E> temp = minValueNode(node.right);
				node.data = temp.data;
				node.right = removeNode(node.right, temp.data);
			}
		}

		if (node == null) {
			return node;
		}

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && getBalance(node.left) >= 0) {
			return rotateRight(node);
		}

		if (balance < -1 && getBalance(node.right) <= 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	public E getMin() {
		if (root == null) {
			return null;
		}
		NodeAvl<E> minNode = getMinNode(root);
		return minNode.data;
	}

	private NodeAvl<E> minValueNode(NodeAvl<E> node) {
		NodeAvl<E> current = node;
	    while (current.left != null) {
	        current = current.left;
	    }
	    return current;
	}
	
	private NodeAvl<E> getMinNode(NodeAvl<E> node) {
		NodeAvl<E> current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public E getMax() {
		if (root == null) {
			return null;
		}
		NodeAvl<E> maxNode = getMaxNode(root);
		return maxNode.data;
	}

	private NodeAvl<E> getMaxNode(NodeAvl<E> node) {
		NodeAvl<E> current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	public boolean search(E data) {
		return searchNode(root, data);
	}

	private boolean searchNode(NodeAvl<E> node, E data) {
		if (node == null) {
			return false;
		}

		if (data.compareTo(node.data) < 0) {
			return searchNode(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			return searchNode(node.right, data);
		} else {
			return true;
		}
	}

	private int height(NodeAvl<E> node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private int getBalance(NodeAvl<E> node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private NodeAvl<E> rotateRight(NodeAvl<E> y) {
		NodeAvl<E> x = y.left;
		NodeAvl<E> T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		return x;
	}

	private NodeAvl<E> rotateLeft(NodeAvl<E> x) {
		NodeAvl<E> y = x.right;
		NodeAvl<E> T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return y;
	}
	
	public NodeAvl<E> getRoot() {
		return this.root;
	}
}
