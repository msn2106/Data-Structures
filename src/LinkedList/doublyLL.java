/* Program to create doubly linked list and its few functions. */
package LinkedList;

public class doublyLL {
	Node head,tail;
	
	//function to insert data in doubly linked list(default end)
	public void append(int data) {
		Node newNode = new Node(data);
		//Node temp = head;
		if(head == null) {
			head = tail = newNode;
		}
		else {
			 //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;  
            //newNode's previous will point to tail  
            newNode.prev = tail;  
            //newNode will become new tail  
            tail = newNode;  
            //As it is last node, tail's next will point to null  
            tail.next = null;  //no need btw
		}
	}
	
	//function to insert data in start of doubly linked list
	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		//node.prev = null;
		if(head == null) head = tail = node;
		else {
			head.prev = node;
			head = node;
		}
	}
	
	//function to insert after a given node
	public void insertAfter(Node prev_Node, int data) {
		if(prev_Node == null) System.out.println("Previous node cannot be null.");
		else {
			Node new_Node = new Node(data);
			new_Node.next = prev_Node.next;
			new_Node.prev = prev_Node;
			prev_Node.next = new_Node;
			if(new_Node.next != null)	new_Node.next.prev = new_Node;
		}
	}
	
	//function to insert before a given node
	public void insertBefore(int data, Node nextNode) {
		if(nextNode == null) append(data);
		else {
			Node newNode = new Node(data);
			newNode.prev = nextNode.prev;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			if(newNode.prev != null) newNode.prev.next = newNode;
		}
	}
	
	//function to insert at a given position
	public void insertAtPos(int pos, int data) {
		if(pos < 1  && pos > length()) {
			System.out.println("Invalid position to insert.");
		}
		else if(pos ==1) push(data);
		else {
			Node node = new Node(data);
			Node tempNode = head;
			int count = 1;
			while(count < pos-1 && tempNode.next != null) {
				tempNode = tempNode.next;
				count += 1;
			}
			node.prev = tempNode;
			node.next = tempNode.next;
			tempNode.next = node;
			if(node.next != null) node.next.prev = node;
		}
	}

	//function to insert at given index
	public void insertAtIndex(int index, int data) {
		if(index < 0  && index > length()) {
			System.out.println("Invalid position to insert.");
		}
		else if(index == 0) push(data);
		else if(index == length()) append(data);
		else {
			Node node = new Node(data);
			Node tempNode = head;
			int count = 0;
			while(count < index && tempNode.next != null) {
				tempNode = tempNode.next;
				count += 1;
			}
			node.prev = tempNode;
			node.next = tempNode.next;
			tempNode.next = node;
			if(node.next != null) node.next.prev = node;
		}
	}
	//function to delete first element (in beginning)
	public void pop() {
		if(head == null) System.out.println("The linked list is empty.");
		else {
			Node tempNode = head;
			System.out.println("First element "+head.data+" popped.");
			head = head.next;
			head.prev = null;
			tempNode.next = null ; //frees the memory
		}
	}
	
	//function to delete last element (in the end)
	public void drop() {
		if(head == null) System.out.println("The linked list is empty.");
		else {
			Node tempNode = tail;
			System.out.println("Last Element "+tail.data+" dropped.");
			tail = tail.prev;
			tail.next = null;
			tempNode.prev = null;	//frees memory
		}
	}
	
	//function to delete a given position node in linked list
	public void delete(int pos) {
		if(pos < 1 && pos > length()) System.out.println("Invalid position.");
		else if(pos == 1) pop();
		else {
			int count = 1;
			Node tempNode = head;
			while(count++ < pos && tempNode.next != null) {
				tempNode = tempNode.next; 
			} 
			tempNode.prev.next = tempNode.next;
			tempNode.next.prev = tempNode.prev;
			System.out.println(tempNode.data+" at position "+pos+" is deleted.");
			tempNode.prev = tempNode.next = null;
		}
	}
	
	//function to check whether the doubly linked list is empty or not 
	public boolean isEmpty() {
		return head == null;
	}
	
	//function to return the size of doubly linked list
	public int length() {
		Node tempNode = head;
		int count = 0;
		while(tempNode.next != null) count++;
		
		return count;
	}
	
	//function to reverse the doubly linked list
	public void reverse() {
		Node newNode = null;
		Node currentNode = head;
		while (currentNode !=null ) {
			newNode = currentNode.next;
			currentNode.next = currentNode.prev;
			currentNode.prev = newNode;
			currentNode = newNode;			
		}
		currentNode = head;
		head = tail;
		tail = currentNode;
	}
	
	//function to print the doubly linked list
	public void print() {
		Node temp = head;
		Node lastNode = null;
		System.out.println("Traversal in forward direction:");
		while(temp != null) {
			System.out.print(temp.data+" ");
			lastNode = temp;
			temp = temp.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while(lastNode != null) {
			System.out.print(lastNode.data+" ");
			lastNode = lastNode.prev;
		}
	}
	
	//main function
	public static void main(String[] args) {
		doublyLL doublyLL = new doublyLL();
		int i = 0;
		while(i++ < 7) doublyLL.append(i);
		doublyLL.print();
		System.out.println();
		doublyLL.insertBefore(14 , doublyLL.head.next);
		doublyLL.append(12);
		doublyLL.append(70);
		doublyLL.push(33);
		doublyLL.insertAfter(doublyLL.head.next.next, 45);
		doublyLL.insertAtPos(15, 92);
		//doublyLL.insertAtIndex(-1,11);
		
		System.out.println("The entered doubly linked list:");
		doublyLL.print();
		
		System.out.println(); System.out.println();
		doublyLL.pop();
		doublyLL.print();
		
		System.out.println(); System.out.println();
		doublyLL.drop();
		doublyLL.print();
		
		System.out.println(); System.out.println();
		doublyLL.insertAtPos(3, 924);
		doublyLL.print();
		
		System.out.println(); System.out.println();
		doublyLL.delete(3);
		doublyLL.print();
		
		System.out.println(); System.out.println();
		doublyLL.reverse();
		doublyLL.print();

	}

}
