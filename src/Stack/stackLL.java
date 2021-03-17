//Java program to Implement a stack using singly linked list 

package stack;

class Stack { 

	// A linked list node 
	private class Node { 
		int data;  
		Node link;  
	} 
	// create global top reference variable global 
	static Node top; static int size=0; 

	// function to add an element x in the stack 
	public void push(int x) // insert at the beginning 
	{ 
		// create new node temp and allocate memory 
		Node temp = new Node(); 
		// initialize data into temp data field 
		temp.data = x; 
		// put top reference into temp link 
		temp.link = top; 
		// update top reference 
		top = temp; 
     //for size
     size++;
	} 

	// function to return top element in a stack 
	public Integer peek() 
	{ 
		// check for empty stack 
		if (!isEmpty()) { 
			return top.data; 
		} 
		else { 
			// System.out.println("Stack is empty"); 
			return null; 
		} 
	} 

	// function to pop top element from the stack 
	public Integer pop() // remove at the beginning 
	{ 
     Integer temp = null;
		// check for stack underflow and update the top
		if (!isEmpty()) { 
         temp = top.data;
			top = top.link;
         size--;
			return temp; 
		} 
		else return null;
	} 

 // function to check if the stack is empty or not 
	public boolean isEmpty() 
	{ 
		return top == null; 
	} 

 //function to check the size of the stack created using linked list
 public int size(){
     return size;
 }

 //function to print the stack
	public void display() 
	{ 
		// check for stack underflow 
		if (top == null) { 
			System.out.println("Stack Underflow"); 
		} 
		else { 
			Node temp = top; 
			while (temp != null) { 
				// print node data 
				System.out.print(temp.data+" "); 
				// assign temp link to temp 
				temp = temp.link; 
			} 
		} 
	} 
} 


//main class 
public class stackLL { 
	public static void main(String[] args) 
	{ 
		// create Object of Implementing class 
		Stack obj = new Stack(); 
		obj.push(11); 
		obj.push(22); 
		obj.push(33); 
		obj.push(44); 
     System.out.println("Size:"+ obj.size());
		obj.display(); 

     System.out.println();
		// print Top element of Stack 
		System.out.println("Top element is :"+ obj.peek()); 

		// Delete top element of Stack 
		obj.pop(); 
		obj.pop(); 

		obj.display(); 

     System.out.println();
		System.out.println("Top element is :"+ obj.peek()); 

     System.out.println("Size:"+ obj.size());
	} 
} 
