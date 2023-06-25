
public class NodeAvl <E> {
	E data;
	NodeAvl<E> left, right;
	int height;

	NodeAvl(E data) {
		this.data = data;
		this.height = 1;
	}
	
	public E getData() {
		return this.data;
	}
	
	public NodeAvl<E> getLeft() {
		return this.left;
	}
	
	public NodeAvl<E> getRight() {
		return this.right;
	}
}