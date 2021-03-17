/* Program to implement Circular Queue using Doubly Linked List*/
package queue;

class circularLLQueue{
	
	class Node{
		int data;
		Node link;
	}
	
	static Node front = null,rear = null;
	static int size = 0;
	
	//function to enqueue data
	public void enqueue(int x){
		Node newNode = new Node();
		newNode.data = x;
		newNode.link = front;				//as data is always inserted at rear
		if(front == null && rear == null) {
			front = rear = newNode;
			size++;
		}
		else {
			rear.link = newNode;
			rear = newNode;
			size++;
		}
	}
	
	//function to dequeue data
	public Integer dequeue() {
		Node temp = new Node();
		temp = front;
		if(front == null && rear == null) return null;
		else if (front == rear) {
			front = rear = null;
			size--;
			temp.link = null;			//frees space
			return temp.data;
		}
		else {
			front = front.link;
			rear.link = front;
			size--;
			temp.link = null;
			return temp.data;
		}
	}
	
	//function to peek the data at top
	public Integer peek() {
		if(front == null && rear == null) return null;
		else return front.data;
	}
	
	//function to check size
	public Integer size() {
		return size;
	}
	
	//function to check is empty
	public static boolean isEmpty() {
		return front == null;
	}
	
	//function to print the Queue
	public void print() {
		Node i = front;
		if(front == null && rear == null) {
			System.out.println("Underflow");
		}
		else {
			while( i != rear){
				 System.out.print(i.data+" ");
				 i = i.link;
			}System.out.print(i.data);
		}
	}
	
}

//main class
public class circularQusingLL {

	public static void main(String[] args) {
		circularLLQueue obj = new circularLLQueue();
		System.out.println("IsEmpty ?:"+ circularArrayQueue.isEmpty());
		obj.enqueue(20);
		obj.enqueue(22);
		obj.enqueue(24);
		obj.enqueue(26);
		System.out.println("Peek:"+ obj.peek());
		obj.enqueue(28);
		obj.dequeue();
		obj.dequeue();
		System.out.println("Dequeued data:"+ obj.dequeue());
		obj.dequeue();
		obj.dequeue();
		obj.enqueue(30);
		obj.enqueue(32);
		obj.enqueue(34);
		obj.enqueue(36);
		obj.print();
		System.out.println();
		System.out.println("Size:"+ obj.size());
	}
}
