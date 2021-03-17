/*Program to implement Queue using array.*/

package queue;

//class for Queue implementation using array.
class arrayQ{
	int size = 5;
	int queue[] = new int[5];
	
	private static int front = -1;
	private static int rear = -1;
	
	public void enqueue(int x) {
		if(rear == size-1) {
			System.out.println("Overflow");
		}
		else if (front == -1 && rear == -1) {
			front = rear = 0;
			queue[rear] = x;
		}
		else {
			rear++;
			queue[rear] = x;
		}
	}
	
	//function to remove element
	public void dequeue() {
		if(front == -1 && rear == -1) {
			System.out.println("Underflow");
		}
		else if (front == rear) {
			front = rear = -1;
		}
		else front++;
	}
	
	//function to peek the value at front of queue
	public Integer peek() {
		if(front == -1 && rear == -1) {
			return null;
		}
		else {
			return queue[front];
		}
	}
	
	//function to check whether the queue is empty
	public static boolean isEmpty() {
		return rear == -1;
	}
	
	//function to check the size
	public int size(){
		return rear-front+1;
	}
	
	//function to print the queue
	public void print() {
		int i = 0;
		for(i = front; i<= rear; i++) {
			System.out.print(queue[i]+" ");
		}
	}
}


//main class
public class queueArray {

	public static void main(String[] args) {
		arrayQ obj = new arrayQ();
		System.out.println(arrayQ.isEmpty());
		obj.enqueue(2);
		obj.enqueue(4);
		obj.enqueue(6);
		obj.enqueue(8);
		obj.enqueue(10);
		//obj.enqueue(12);
		obj.print();
		
		System.out.println();
		obj.dequeue();
		obj.dequeue();
		System.out.println("The value at front of queue is:"+obj.peek());
		System.out.println("Size now:"+ obj.size()); 
		obj.print();
	}
}
