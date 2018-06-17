package dataStructureImpl;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	Node(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}
}
