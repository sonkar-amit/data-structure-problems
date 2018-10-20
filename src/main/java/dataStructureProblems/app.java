package dataStructureProblems;
import dataStructureImplementation.*;
import dataStructureProblems.SinglyLinkedListProblems;

public class app {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		SinglyLinkedListProblems<Integer> linkedListSolution = new SinglyLinkedListProblems<Integer>();
		linkedList.add(4);
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
		
		System.out.println("<------------- Delete Middle element ------------>");
		linkedListSolution.deleteMiddleNode(linkedList);
		linkedList.printElement();
		
		System.out.println("<------------- Removing duplicate from sorted list ------------>");
		linkedList.addFirst(2);
		linkedListSolution.removeDuplicateInSortedList(linkedList);
		linkedList.printElement();
		System.out.println("Count: "+linkedList.getCount());
		
		System.out.println("<------------- Reversing the list ------------>");
		linkedListSolution.reverse(linkedList);
		linkedList.printElement();
		System.out.println("<------------- Setting list back to original ------------>");
		linkedListSolution.reverse(linkedList);
		linkedList.printElement();
		
		System.out.println("<------------- Reversing the K number of nodes in list ------------>");
		linkedListSolution.reverseKNode(linkedList, 3);
		linkedList.printElement();
		
		System.out.println("<------------- Find nth nodes from last in list ------------>");
		int nodeFromLast = 2;
		Node<Integer> nthNode = linkedListSolution.findNthNodeFromLast(linkedList.getHead(), nodeFromLast);
		String value = "" + (nthNode==null?null:nthNode.getValue());
		System.out.println(nodeFromLast + " node from last: "+value);
		
		System.out.println("<------------- Check if list is palindrome ------------>");
		boolean isNotPalindrome = linkedListSolution.isPalindrome(linkedList.getHead());
		linkedList.printElement();
		System.out.println("List is palindrome: "+isNotPalindrome);
		SinglyLinkedList<Integer> palindromeList = new SinglyLinkedList<Integer>();
		palindromeList.add(1);
		palindromeList.add(2);
		palindromeList.add(3);
		palindromeList.add(4);
		palindromeList.add(3);
		palindromeList.add(2);
		palindromeList.add(1);
		boolean isPalindrome = linkedListSolution.isPalindrome(palindromeList.getHead());
		palindromeList.printElement();
		System.out.println("List is palindrome: "+isPalindrome);

		System.out.println("<------------- Reverse alternate k node after m node------------>");
		SinglyLinkedList<Integer> listBefore = new SinglyLinkedList<Integer>();
		listBefore.add(1);
		listBefore.add(2);
		listBefore.add(3);
		listBefore.add(4);
		listBefore.add(5);
		listBefore.add(6);
		listBefore.add(7);
		listBefore.add(8);
		System.out.println("Before reversing");
		listBefore.printElement();
		System.out.println("After reversing");
		linkedListSolution.reverseKNodeAfterMNode(listBefore, 3,2);
		listBefore.printElement();
		
		System.out.println("<------------- Delete last occurence of node ------------>");
		SinglyLinkedList<Integer> newList = new SinglyLinkedList<Integer>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(5);
		newList.add(2);
		newList.add(10);
		System.out.println("Before deletion");
		newList.printElement();
		System.out.println("After deletion");
		linkedListSolution.deleteLastOccurenceOfKey(newList, 2);
		newList.printElement();
		
		System.out.println("<------------- Rotate list ------------>");
		SinglyLinkedList<Integer> unrotatedList = new SinglyLinkedList<Integer>();
		unrotatedList.add(10);
		unrotatedList.add(20);
		unrotatedList.add(30);
		unrotatedList.add(40);
		unrotatedList.add(50);
		unrotatedList.add(60);
		System.out.println("Before rotation");
		unrotatedList.printElement();
		int rotateBy = 4;
		System.out.println("After rotation by "+rotateBy);
		linkedListSolution.rotateList(unrotatedList, rotateBy);
		unrotatedList.printElement();
		
		System.out.println("<------------- Delete M nodes after N nodes ------------>");
		SinglyLinkedList<Integer> originalList = new SinglyLinkedList<Integer>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(3);
		originalList.add(4);
		originalList.add(5);
		originalList.add(6);
		originalList.add(7);
		originalList.add(8);
		originalList.add(9);
		originalList.add(10);
		System.out.println("Before deletion");
		originalList.printElement();
		int mNodes = 2;
		int nNodes = 3;
		System.out.println("After deletion of "+mNodes+" nodes at the interval of "+nNodes+ " nodes");
		linkedListSolution.deleteMnodesAfterNnodes(originalList, mNodes, nNodes);
		originalList.printElement();
		
		System.out.println("<------------- Merge lists ------------>");
		SinglyLinkedList<Integer> firstList = new SinglyLinkedList<Integer>();
		firstList.add(1);
		firstList.add(2);
		firstList.add(3);
		System.out.println("Before merging first list");
		firstList.printElement();
		SinglyLinkedList<Integer> secondList = new SinglyLinkedList<Integer>();
		secondList.add(4);
		secondList.add(5);
		secondList.add(6);
		secondList.add(7);
		secondList.add(8);
		System.out.println("Before merging second list");
		secondList.printElement();
		linkedListSolution.mergeList(firstList, secondList);
		System.out.println("After merging first list");
		firstList.printElement();
		System.out.println("After merging second list");
		secondList.printElement();
	}
}
