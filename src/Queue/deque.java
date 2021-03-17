/*Program to implement Doubly Ended Queue(Deque) using circular array.*/
package queue;

public class deque {
	
	private static int size = 5;
	private int[] arr = new int[size];
	
	private static int front = -1;
	private static int rear = -1;
	
	//function to insert at rear
	public void enqueueRear(int x) {
		if(front == -1 && rear == -1) {
			front = rear = 0;
			arr[rear] = x;
		}
		else if((rear+1)%size == front) {
			System.out.println("Overflow occured "+x+" cannot be entered.");
		}
		else if (rear == size-1) {
			rear = 0;
			arr[rear] = x;
		}
		else {
			rear++;
			arr[rear] = x;
		}
	}
	
	//function to insert at front
	public void enqueueFront(int x) {
		if(front == -1 && rear == -1) {
			front = rear = 0;
			arr[front] = x;
		}
		else if((rear+1)%size == front) {
			System.out.println("Overflow occured "+x+" cannot be entered.");
		}
		else if (front == 0) {
			front = size-1;
			arr[front] = x;
		}
		else {
			front--;
			arr[front] = x;
		}
	}
	
	//function to delete from rear
	public void dequeueRear() {
		if(front == -1 && rear == -1) {
			System.out.println("Underflow");
		}
		else if(front == rear) {
			System.out.println(arr[rear]);
			front = rear = -1;
		}
		else if(rear == 0) {
			System.out.println(arr[rear]);
			rear = size-1;
		}
		else {
			System.out.println(arr[rear]);
			rear--;
		}
	}
	
	//function to delete from front
	public void dequeueFront() {
		if(front == -1 && rear == -1) {
			System.out.println("Underflow");
		}
		else if(front == rear) {
			System.out.println(arr[front]);
			front = rear = -1;
		}
		else if(front == size-1) {
			System.out.println(arr[front]);
			front = 0;
		}
		else {
			System.out.println(arr[front]);
			front ++;
		}
	}
	
	//function to check isEmpty
	public boolean isEmpty() {
		return front==-1;
	}
	
	//function to check isFull
	public boolean isFull() {
		return (rear+1)%size == front;
	}
	
	//function to get value at front
	public Integer peekFront() {
		if(front == -1 && rear == -1) return null;
		else return arr[front];
	}
	
	//function to get value at front
		public Integer peekRear() {
			if(front == -1 && rear == -1) return null;
			else return arr[rear];
		}
		
	//function to print the queue
	public void print() {
		int i = front;
		System.out.print("Deque now:");
		while(i!=rear) {
			System.out.print(arr[i]+" ");
			i = (i+1)%size;
		}System.out.print(arr[i]);
	}

	public static void main(String[] args) {
		deque dq = new deque();
		dq.enqueueFront(10);
		dq.enqueueFront(12);
		dq.enqueueFront(14);
		dq.print();
		System.out.println();
		dq.enqueueRear(16);
		dq.enqueueRear(18);
		System.out.println("Is full ? "+ dq.isFull());
		dq.enqueueFront(20);		//overflow
		dq.print();
		
		System.out.println();
		dq.dequeueFront();
		System.out.println("Peek Front:"+dq.peekFront());
		dq.dequeueFront();
		dq.print();
		
		System.out.println();
		dq.dequeueRear();
		dq.print();
		
		System.out.println();
		dq.enqueueRear(23);
		dq.print();
		System.out.println();
		System.out.println("Peek Rear:"+dq.peekRear());
		
	}

}
