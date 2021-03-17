/*Program for Doubly Circular Linked List*/
package LinkedList;

public class doublyCircularLL {
	
	static Node head, tail;
	
	//function to insert at end(default)
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			newNode.next = head;
			newNode.prev = tail;
		}else {
			newNode.next = head;
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			head.prev = tail;
		}		
	}
	
	//function to insert at Start of the doubly circular linked list
	public void insertAtStart(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			newNode.next = head;
			newNode.prev = tail;
		}else {
			newNode.next = tail.next;
			newNode.prev = tail;
			tail.next = newNode;
			head.prev = newNode;
			head = newNode;
		}
	}
	//function to insert at a given position in doubly circular linked list
	public void insertAtPos(int pos, int data) {
		if(pos < 1 || pos > size()) System.out.println("Invalid Position to insert element.");
		else if (pos == 1) insertAtStart(data);
		else {
			Node tempNode = head;
			Node newNode = new Node(data);
			while(pos-- >1) {
				tempNode = tempNode.next;
			}
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next.prev = newNode;
			tempNode.next = newNode;
		}
	}
	
	//function to delete the node from starting
	public void pop() {
		if(head == null) System.out.println("The list is empty.");
		else if(head == tail) head = tail = null;
		else {
			Node tempNode = head;
			head = head.next;
			head.prev = tail;
			tail.next = head;
			System.out.println("The poped value is:"+ tempNode.data);
			tempNode.next = tempNode.prev = null;
		}
	}
	
	//function to delete the node from the end
	public void drop() {
		if(head == null) System.out.println("The list is empty.");
		else if (head == tail) head = tail = null;
		else {
			Node tempNode = tail;
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
			System.out.println("The dropped value is:"+ tempNode.data);
			tempNode.prev = tempNode.next = null;
		}
	}
	
	//function to delete from a given position //not working
	public void delete(int pos) {
		if(pos<1 || pos> size()) System.out.println("Invalid position to delete.");
		else if(pos == 1) pop();
		else if (pos == size()) drop();
		else {
			Node tempNode = head;
			while(pos-- > 1) {
				tempNode = tempNode.next;
				//pos--;
			}
			tempNode.prev.next = tempNode.next;
			tempNode.next.prev = tempNode.prev; 
			if(tempNode.next == head) {
				tail = tempNode.prev;
			}
			//tempNode.prev = tempNode.next = null;
		}
	}
	
	//function to reverse
	public void reverse() {
		if(head == null) System.out.println("The list is empty");
		else {
			Node temp = null;
			Node tempNode = head;
			while(tempNode != tail) {
				temp = tempNode.next;
				tempNode.next = tempNode.next.prev;
				tempNode.next.prev = temp;
			}
		}
	}
	
	//function to check whether the doubly circular linked list is empty or not
	public static boolean isEmpty() {
		return head ==null;
	}
	
	//function to measure size
	public static int size() {
		int size = 0;
		Node tempNode = head;
		if(head == null) return 0;
		else {
			while(tempNode != tail) {
				size++;
				tempNode = tempNode.next;
			}
		}
		return size+1; // size+1 coz it is not counting the tail node.
	}

	//function to print the doubly circular linked list
	public void print() {
		if(head == null) System.out.println("The list is empty.");
		else {
			Node tempNode = head;
			while(tempNode.next != head){
				System.out.println(tempNode.data);
				tempNode = tempNode.next;
			}
			System.out.println(tempNode.data);
		}
	}
	
	//main driver function
	public static void main(String[] args) {
		doublyCircularLL dcl = new doublyCircularLL();
		
		dcl.insertAtEnd(33);
		dcl.insertAtEnd(99);
		dcl.insertAtPos(2, 55);
		dcl.insertAtStart(44);
		dcl.insertAtPos(1, 11);
		dcl.insertAtStart(22);
		dcl.print();
		System.out.println("The size of Doubly Circular Linked List is:"+ size());
		
//		System.out.println();
//		dcl.reverse();			//not working
//		dcl.print();
		
		System.out.println();
//		dcl.delete(4);			//not working properly. when the next two are commented.
		dcl.pop();
		dcl.drop();
		dcl.print();	

	}

}
