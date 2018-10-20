package dataStructureProblems;
import dataStructureImplementation.*;

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
	
	public boolean deleteMiddleNode(SinglyLinkedList<T> list) {
		Node<T> headRef = list.getHead();
		Node<T> slowPointer = headRef;
		Node<T> fastPointer = headRef;
		
		if(headRef != null) {
			Node<T> previousNode = headRef;
			while(fastPointer!= null && fastPointer.getNext() != null) {
				previousNode = slowPointer;
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext().getNext();
			}
			previousNode.setNext(slowPointer.getNext());
			return true;
		} else {
			return false;
		}
	}
	
	public void removeDuplicateInSortedList(SinglyLinkedList<T> list) {
		Node<T> head = list.getHead();
		int count = list.getCount();
		if(head != null) {
			Node<T> uniqueNode = head;
			while (head.getNext() != null) {
				head = head.getNext();
				if(uniqueNode.getValue() == head.getValue()) {
					uniqueNode = head;
					list.remove(head.getValue());
					count--;
				} else {
					uniqueNode = head;
				}
			}
			list.setCount(count);
		}
	}
	
	public void reverse(SinglyLinkedList<T> list) {
		Node<T> head = list.getHead();
		if(head != null) {
			Node<T> current = head;
			Node<T> prev = null;
			Node<T> next;
			
			while(current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			list.setHead(prev);
			list.setTail(head);
		}
	}
	
	public void reverseKNode(SinglyLinkedList<T> list, int nodesToReverese) {
		int nodesToRevereseRef = nodesToReverese;
		Node<T> head = list.getHead();
		Node<T> newHeadRef = null;
		Node<T> newTailRef = null;
		if(head != null) {
			Node<T> current = head;
			Node<T> prev = null;
			Node<T> next;
			int i = 1;
			while(current != null) {
				prev = null;
				next = null;
				if((list.getCount() - i*nodesToReverese) <= nodesToReverese) {
					newTailRef = current;
				}
				Node<T> previousIterationHeadNode = current;
				while(nodesToRevereseRef != 0) {
					next = current.getNext();
					current.setNext(prev);
					prev = current;
					current = next;
					nodesToRevereseRef--;
				}
				if(i == 1) {
					newHeadRef = prev;
				}
				nodesToRevereseRef = nodesToReverese;
				prev = previousIterationHeadNode;
				
				Node<T> nextGroupNode = current;
				while(nodesToRevereseRef != 1 && nextGroupNode != null) {
					nextGroupNode = nextGroupNode.getNext();
					nodesToRevereseRef--;
				}
				nodesToRevereseRef = nodesToReverese;
				prev.setNext(nextGroupNode);
				i++;		
			}
			list.setHead(newHeadRef);
			list.setTail(newTailRef);
		}
	}
	
	public int detectLoop(Node<T> head) {
		Node<T> slow = head;
	    Node<T> fast = head;
	    while(fast != null && fast.getNext() != null){
	        slow = slow.getNext();
	        fast = fast.getNext().getNext();
	        if(slow.getValue() == fast.getValue()){
	            return 1;
	        }
	    }
	    return 0;
	}
	
	public Node<T> findNthNodeFromLast(Node<T> head, int nthNode){
		if(head != null) {
			Node<T> slow = head;
			Node<T> fast = head;
			for(int i=0;i<nthNode;i++) {
				if(fast == null) {
					return null;
				}
				fast = fast.getNext();
			}

			while(fast != null) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
		
		return null;
	}
	
	public boolean isPalindrome(Node<T> head) {
		if(head != null) {
			if(head.getNext() == null) {
				return true;
			}
			Node<T> slowPtr = head, fastPtr = head;
			Node<T> prevToSlowPtr = null, midNode = null;
			
			//find middle Node
			while(fastPtr != null && fastPtr.getNext() != null) {
				fastPtr = fastPtr.getNext().getNext();
				
				prevToSlowPtr = slowPtr;
				slowPtr = slowPtr.getNext();
			}
			
			//If linked list is odd then fastPtr will not be null
			//In case of odd list, omit the mid node and move to next node
			if(fastPtr != null) {
				midNode = slowPtr;
				slowPtr = slowPtr.getNext();
			}
			
			//Separating first part of list from second
			prevToSlowPtr.setNext(null);
			
			//reverse the second half
			Node<T> current = slowPtr;
			Node<T> prev = null;
			Node<T> next = null;
			
			while(current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			
			//compare first half with second half
			Node<T> temp1 = head;
			Node<T> temp2 = prev;
			
			while(temp1 != null && temp2 != null) {
				if(temp1.getValue() != temp2.getValue()) {
					return false;
				}
				
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}
			
			//reverse the second half to it's original form
			current = prev;
			prev = null;
			next = null;
			
			while(current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			
			// Join first and second half to form original list
			if(midNode != null) {
				prevToSlowPtr.setNext(midNode);
				midNode.setNext(prev);
			} else {
				prevToSlowPtr.setNext(prev);
			}
			
			return true;
		}

		return false;
	}
	
	public void reverseKNodeAfterMNode(SinglyLinkedList<T> list, int nodesToReverese, int nodeToSkip) {
		Node<T> head = list.getHead();
		Node<T> reversedGroupStartNode = null;
		Node<T> nonReveresedGroupLastNode = null;
		int nodeCount = 1;
		
		if(list.getCount() == nodesToReverese) {
			reverse(list);
			return;
		} else if(list.getCount() < nodesToReverese || nodesToReverese == 1) {
			return;
		}
		
		if(head != null) {
			Node<T> prev = null;
			Node<T> current = head;
			Node<T> next = null;
			Node<T> newHeadNode = null;
			Node<T> newTailNode = null;
			int startNode = 1;
			int endNode = startNode + nodesToReverese;
			
			while(current != null) {
				
				if(startNode == nodeCount) {
					reversedGroupStartNode = current;
					prev = null;
					next = null;
				}
				
				if(startNode-1 == nodeCount) {
					nonReveresedGroupLastNode = current;
				}
				
				if(startNode <= nodeCount && endNode > nodeCount) {
					next = current.getNext();
					current.setNext(prev);
					prev = current;
					current = next;
					if(current == null) {
						newTailNode = reversedGroupStartNode;
					}
					if(nonReveresedGroupLastNode != null) {
						nonReveresedGroupLastNode.setNext(prev);
					}
				} else if(endNode == nodeCount){
					if(startNode == 1) {
						newHeadNode = prev;
					}
					reversedGroupStartNode.setNext(current);
					if(nonReveresedGroupLastNode != null) {
						nonReveresedGroupLastNode.setNext(prev);
					}
					
					startNode = endNode + nodeToSkip;
					endNode = startNode + nodesToReverese;
					newTailNode = current;
					current = current.getNext();
				} else {
					newTailNode = current;
					current = current.getNext();
				}
				
				nodeCount++;
			}
			
			list.setHead(newHeadNode);
			list.setTail(newTailNode);
		}
	}
	
	public boolean deleteLastOccurenceOfKey(SinglyLinkedList<T> list, T key) {
		Node<T> head = list.getHead();
		Node<T> current = head;
		int index = -1;
		int count = 1;
		
		if(head != null) {
			while(current != null) {
				if(current.getValue() == key) {
					index = count;
				}
				current = current.getNext();
				count++;
			}
			
			if(index == 1) {
				list.setHead(null);
				list.setTail(null);
				return true;
			}
			
			if(index == -1) {
				return false;
			}
			
			current = head;
			for(int i = 1; i< index-1; i++) {
				current = current.getNext();
			}
			
			current.setNext(current.getNext().getNext());
			
			if(current.getNext() == null) {
				list.setTail(current);
			}
			
			return true;
		}
		
		return false;
	}
	
	public void rotateList(SinglyLinkedList<T> list, int rotateBy) {
		Node<T> head = list.getHead();
		Node<T> current = head;
		Node<T> prevTailNode = null;
		Node<T> newTailNode = null;
		Node<T> newHeadNode = null;
		int count = 1;
		
		if(head != null) {
			while(current.getNext() != null) {
				if(count == rotateBy) {
					newTailNode = current;
					newHeadNode = current.getNext();
				}
				current = current.getNext();
				count++;
			}
			
			if(newTailNode == null || count == rotateBy || count == 1) {
				return;
			}
			
			prevTailNode = current;
			newTailNode.setNext(null);
			prevTailNode.setNext(head);

			list.setHead(newHeadNode);
			list.setTail(newTailNode);
		}
	}
	
	public void deleteMnodesAfterNnodes(SinglyLinkedList<T> list, int m, int n) {
		Node<T> head = list.getHead();
		Node<T> current = head;
		Node<T> prev = null;
		int count = 1;
		
		if(m == 0 || n == 0) {
			return;
		}
		
		int startIndex = n + 1;
		int endIndex = startIndex + m;
		
		if(head != null) {
			while(current != null) {
				if(startIndex-1 == count) {
					prev = current;
				}
				
				if(endIndex == count) {
					prev.setNext(current);
					startIndex = endIndex + n;
					endIndex = startIndex + m;
					
					//Keeping this condition for scenario when m = 1 and n = 1
					//because current node will move ahead after deletion
					if(startIndex-1 == count) {
						prev = current;
					}
				}
				
				current = current.getNext();
				count++;
				
				//1> Keeping this condition for scenario when current node is null and there is no other node for previous node to point to
				//2> This condition will be needed when m = 1 and n = 1 also as last node in case of even list will not point to null.
				if(current == null && ((endIndex > count -1 && startIndex < count - 1) || (m == 1 && n == 1))) {
					list.setTail(prev);
					prev.setNext(null);
				}
				
				
			}
		}
	}
	
	public void mergeList(SinglyLinkedList<T> firstList, SinglyLinkedList<T> secondList) {
		Node<T> firstListCurrentNode = firstList.getHead();
		Node<T> firstListNextNode = null;
		Node<T> secondListCurrentNode = secondList.getHead();
		Node<T> secondListNextNode = null;
		
		while(firstListCurrentNode != null && secondListCurrentNode != null) {
			firstListNextNode = firstListCurrentNode.getNext();
			firstListCurrentNode.setNext(secondListCurrentNode);
			secondListNextNode = secondListCurrentNode.getNext();
			secondListCurrentNode.setNext(firstListNextNode);
			
			firstListCurrentNode = firstListNextNode;
			secondListCurrentNode = secondListNextNode;
		}
		
		if(secondListCurrentNode != null) {
			secondList.setHead(secondListCurrentNode);
		} else {
			secondList.setHead(null);
		}
	}
}
