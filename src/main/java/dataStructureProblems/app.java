package dataStructureProblems;
import dataStructureImpl.*;
import dataStructureProblems.SinglyLinkedListProblems;

public class app {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		SinglyLinkedListProblems<Integer> linkedListSolution = new SinglyLinkedListProblems<Integer>();
		System.out.println(linkedList.add(4));
		linkedList.add(2);
		linkedList.add(19);
		linkedList.add(3);
		linkedList.add(15);
		linkedList.add(78);
		linkedList.add(33);
		
		linkedList.printElement();
		System.out.println("Count: "+linkedList.getCount());
		System.out.println("Head: "+linkedList.getHead().getValue());
		System.out.println("Tail: "+linkedList.getTail().getValue());
		
		System.out.println("<------------- Removing first node ------------>");
		System.out.println("Removed node: "+linkedList.removeFirst().getValue());
		linkedList.printElement();
		System.out.println("Count: "+linkedList.getCount());
		System.out.println("Head: "+linkedList.getHead().getValue());
		System.out.println("Tail: "+linkedList.getTail().getValue());
		
		System.out.println("<------------- Removing last node ------------>");
		System.out.println("Removed node: "+linkedList.removeLast().getValue());
		linkedList.printElement();
		System.out.println("Count: "+linkedList.getCount());
		System.out.println("Head: "+linkedList.getHead().getValue());
		System.out.println("Tail: "+linkedList.getTail().getValue());
		
		System.out.println("<------------- Removing node from middle ------------>");
		linkedList.remove(3);
		linkedList.printElement();
		System.out.println("Count: "+linkedList.getCount());
		System.out.println("Head: "+linkedList.getHead().getValue());
		System.out.println("Tail: "+linkedList.getTail().getValue());
		
		System.out.println("<------------- Print Middle element ------------>");
		Node<Integer> middleElement = linkedListSolution.getMiddleNode(linkedList);
		System.out.println("Middle Element: "+middleElement.getValue());
	}
}
