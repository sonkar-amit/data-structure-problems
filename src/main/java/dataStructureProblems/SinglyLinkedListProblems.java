package dataStructureProblems;
import dataStructureImpl.*;;

public class SinglyLinkedListProblems<T>
{
	//Find and return the middle node
	public Node<T> getMiddleNode(SinglyLinkedList<T> list) {
		Node<T> headRef = list.getHead();
		Node<T> slowPointer = headRef;
		Node<T> fastPointer = headRef;
		if(headRef != null) {
			while(fastPointer != null && fastPointer.getNext() != null) {
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext().getNext();
			}
			
			return slowPointer;
		} else {
			return null;
		}
	}
}
