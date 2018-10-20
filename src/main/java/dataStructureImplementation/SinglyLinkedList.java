package dataStructureImplementation;

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}
	
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	public boolean addFirst(T value) {
		boolean isAdded = false;
		Node<T> nodeToAdd = new Node<T>(value);
		if(head == null) {
			head = nodeToAdd;
			tail = nodeToAdd;
			isAdded = true;
		} else {
			Node<T> current = head;
			head = nodeToAdd;
			head.setNext(current);
			isAdded = true;
		}
		count++;
		return isAdded;
	}
	
	public boolean addLast(T value) {
		boolean isAdded = false;
		Node<T> nodeToAdd = new Node<T>(value);
		if(head == null) {
			isAdded = addFirst(value);
			count--;
		} else {
			Node<T> lastNode = tail;
			lastNode.setNext(nodeToAdd);
			tail = nodeToAdd;
			isAdded = true;
		}
		count++;
		return isAdded;
	}
	
	public boolean add(T value) {
		return addLast(value);
	}
	
	public Node<T> removeFirst() {
		Node<T> removedObjct = null;
		if(head != null) {
			Node<T> nextNode = head.getNext();
			removedObjct = head;
			head = nextNode;			
		}
		count--;
		return removedObjct;
	}
	
	public Node<T> removeLast() {
		Node<T> removedObjct = null;
		if(tail != null) {
			Node<T> previousNode = head;
			while(previousNode.getNext().getValue() != tail.getValue()) {
				previousNode = previousNode.getNext();
			}
			removedObjct = tail;
			previousNode.setNext(null);
			tail = previousNode;
		}
		count--;
		return removedObjct;
	}
	
	public boolean remove(T value) {
		if(head != null) {
			Node<T> previousNode = head;
			Node<T> nextNode = head;
			if(previousNode.getValue().equals(value)) {
				nextNode = previousNode.getNext();
				tail = head.equals(tail) ? nextNode : tail;
				head = nextNode;
				count--;
				return true;
			}
			while(previousNode.getNext() != null && !previousNode.getNext().getValue().equals(value)) {
				previousNode = previousNode.getNext();
			}
			
			if(previousNode.getNext() == null && previousNode.getValue().equals(value)) {
				previousNode.setNext(null);
				tail = previousNode;
				count--;
				return true;
			} else if(previousNode.getNext() != null) {
				nextNode = previousNode.getNext().getNext();
				tail = nextNode == null ? previousNode : tail;
				previousNode.setNext(nextNode);
				count--;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void printElement() {
		Node<T> headRef = head;
		while(headRef != null) {
			System.out.println(headRef.getValue());
			headRef = headRef.getNext();
		}
	}
}
