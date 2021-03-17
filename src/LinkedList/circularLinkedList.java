/* Program to implement Circular Linked List */
package linkedList;
public class circularLinkedList{
	
	//class Node
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	static Node tail;
	
	//function to insert data at start
	public void insertAtStart(int data) {
		Node newNode = new Node(data);
		if(tail == null) {
			tail = newNode;
			tail.next = newNode;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
	}
	
	//function to insert data at end
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(tail == null) {
			tail = newNode;
			tail.next = newNode;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	//function to insert data at specified position
	public void insertAtPos(int index,int data) {
		if(index < 1 || index > size()+1) {
			System.out.println("Invalid Position");
		}
		else {
			Node newNode = new Node(data);
			Node tempNode = tail.next;
			while(index-- > 1) {
				tempNode = tempNode.next;
			}
			newNode.next = tempNode.next;
			tempNode.next = newNode;
		}
	}
	
	//function to remove any node from a specified position in circular linked list
	public void delete(int pos) {
		if(pos < 1 || pos > size()) System.out.println("Invalid Position.");
		else {
			Node tempNode = tail.next;
			while(pos-1 >1) {
				tempNode = tempNode.next;
				pos--;
			}
			tempNode.next = tempNode.next.next;
		}
	}
	
	//function to reverse the circular linked list
	public void reverse() {
		if(tail == null) System.out.println("The list is empty");
		else {
			Node prevNode = null;
			Node currentNode = tail.next;
			Node nextNode = currentNode.next;
			while(currentNode != tail) {
				prevNode = currentNode;
				currentNode = nextNode;
				nextNode = currentNode.next;
				currentNode.next = prevNode;
			}
			nextNode.next = tail;
			tail = nextNode;
		}
	}
	
	//function to check whether the circular linked list is empty or not
	public boolean isEmpty() {
		return tail == null;
	}
	
	//function to return the size of circular linked list
	public static int size() {
		int size = 0;
		Node tempNode = tail.next;
		while(tempNode != tail) {
			size = size+1;
			tempNode = tempNode.next;
		}
		return size+1;
	}
	
	//function to print the circular linked list
	public void print() {
		Node tempNode = tail.next;
		while(tempNode.next != tail.next) {
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.data); //this is important line...checkout it's need.
	}
	
	public static void main(String[] args) throws Exception {
		circularLinkedList cll = new circularLinkedList();
		for(int i=10; i<13; i++) cll.insertAtEnd(i);
		System.out.println("The Entered Circular Linked List is:");
		cll.print();
		System.out.println();
		for(int i=20; i>17; i--) cll.insertAtStart(i);
		System.out.println("The Circular Linked List with elements inserted at end is:");
		cll.print();
		System.out.println();
		for(int i=1; i<4; i++) cll.insertAtPos(i,i+50);
		System.out.println("The Circular Linked List with elements inserted at given position is");
		cll.print();
		System.out.println();
		System.out.println("The size of circular linked list is:"+ size());
		
		System.out.println();
		//cll.delete(3);
		cll.insertAtPos(9, 99);
		//cll.insertAtPos(0, 999);
		System.out.println("The value from position 3 is deleted.");
		cll.print();
		
		System.out.println();
		cll.reverse();
		System.out.println("The circular linked list in reverse order is:");
		cll.print();
		
//		System.out.println();
//		cll.insertAtEnd(21);
//		cll.print();
//		System.out.println();
//		cll.insertAtPos(4, 33);
//		cll.print();
//		System.out.println();
//		cll.insertAtStart(11);
//		cll.print();
		System.out.println();
		System.out.println("The size of circular linked list is:"+ size());
	}
}