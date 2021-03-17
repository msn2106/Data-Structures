/* Program to implement Circular Queue using Array*/
package queue;

class circularArrayQueue{
	static int size = 5;
	int[] arr = new int[size];
	
	static int front=-1,rear = -1;
	
	//function to enqueue data
	public void enqueue(int x){
		if(front == -1 && rear == -1) {
			front = rear = 0;
			arr[rear] = x;
		}
		else if ((rear+1)%size == front) {
			System.out.println("Overflow");
		}
		else {
			rear = (rear+1)%size;
			arr[rear] = x; 
		}
	}
	
	//function to dequeue data
	public Integer dequeue() {
		Integer temp = null;
		if(front == -1 && rear == -1) return null;
		else if (front == rear) {
			temp = arr[front];
			front = rear = -1;
			return temp;
		}
		else {
			temp = arr[front];
			front = (front+1)%size;
			return temp;
		}
	}
	
	//function to peek the data at top
	public Integer peek() {
		if(front == -1 && rear == -1) return null;
		else return arr[front];
	}
	
	//function to check size
	public Integer size() {
		int count = 0;
		int i = front;
		if(front == -1 && rear == -1) return 0;
		else {
			while(i != rear) {
				i = (i+1)%size;
				count++;
			}
			return count+1;
		}
	}
	
	//function to check is empty
	public static boolean isEmpty() {
		return rear == -1;
	}
	
	//function to print the Queue
	public void print() {
		int i = front;
		if(front == -1 && rear == -1) {
			System.out.println("Underflow");
		}
		else {
			while( i != rear){
				 System.out.print(arr[i]+" ");
				 i = (i+1)%size;
			}System.out.print(arr[i]);
		}
	}
	
}

//main class
public class circularQusingArray {

	public static void main(String[] args) {
		circularArrayQueue obj = new circularArrayQueue();
		System.out.println("IsEmpty ?:"+ circularArrayQueue.isEmpty());
		obj.enqueue(20);
		obj.enqueue(22);
		obj.enqueue(24);
		obj.enqueue(26);
		System.out.println("Peek:"+ obj.peek());
		obj.enqueue(28);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
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
