/*Program to implement Queue using Linked List*/
package queue;

//class for Queue implementation using Linked List.
class LLQ{
	
	//class Node (singly)
	class Node{
		int data;
		Node next;
	}
	
	private static Node front = null;
	private static Node rear = null;
	private static int size = 0;			//for keeping tab on size
	
	//function to insert the data
	public void enqueue(int x) {
		Node newNode = new Node();
		newNode.data = x;
		if(front == null) {
			front = rear = newNode;
			//newNode.next = front;
			size++;
		}
		else {
			rear.next = newNode;
			rear = newNode;
			size++;
		}
	}
	
	//function to delete data
	public Integer dequeue() {
		Node temp = front;
		if(front == null) return null;
		else {
			temp.data = front.data;
			front = front.next;
			size--;
			temp.next = null;
			return temp.data;
		}
	}
	
	//function to peek
	public Integer peek() {
		if(front == null) return null;
		else return front.data;
	}
	
	//function to check is empty
	public static boolean isEmpty() {
		return front == null;
	}
	
	//function to check the size
	public static int size() {
		return size;
	}
	
	//function to print the Queue
	public void print() {
		Node temp = front;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}

//main class
public class queueLL {

	public static void main(String[] args) {
		LLQ obj = new LLQ();
		System.out.println(LLQ.isEmpty());
		obj.enqueue(2);
		obj.enqueue(4);
		obj.enqueue(6);
		obj.enqueue(8);
		obj.enqueue(10);
		obj.enqueue(12);
		obj.print();
		
		System.out.println();
		obj.dequeue();
		obj.dequeue();
		System.out.println("The value at front of queue is:"+obj.peek());
		System.out.println("Size now:"+ LLQ.size()); 
		obj.print();
	}
}