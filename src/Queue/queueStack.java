/*Program to implement Queue using Stack (2 stacks) with enqueue in O(1) and dequeue in O(n)*/
package queue;
import java.util.Stack;
public class queueStack {
	
	private Stack<Integer> st1 = new Stack<Integer>();
	private Stack<Integer> st2 = new Stack<Integer>();
	
	//function to enqueue
	public void enqueue(int x) {
		st1.push(x);
	    //System.out.println("Element inserted into the queue: "+x);
	}
	
	//function to dequeue
	public int dequeue() {
		int x, y;
	    while(!st1.isEmpty()) 
	    {
	        x = st1.pop();					// take an element out of first stack
	        st2.push(x);					// insert it into the second stack
	    }
	    y = st2.pop();						// removing the element
	    
	    while(!st2.isEmpty()) 				// moving back the elements to the first stack
	    {
	        x = st2.pop();
	        st1.push(x);
	    }
	  
	    return y;
	}
	
	//function to peek the value at front end in queue
	public int peek() {
		return st1.firstElement();
	}
	
	//function for size
	public int size() {
		return st1.size();
	}
	
	//function to check whether the queue is empty
	public boolean isEmpty() {
		return st1.isEmpty();
	}
	
	//function to print the queue
	public void print() {
		System.out.print("The queue is:");
		for(int i: st1) {
			System.out.print(i+" ");
		}
	}
	
	//main driver function
	public static void main(String[] args) {
		queueStack q = new queueStack();
		System.out.println("Is Empty ? "+ q.isEmpty());
	    q.enqueue(10);
	    q.enqueue(100);
	    q.enqueue(1000);
	    q.enqueue(12);
	    System.out.println("Peeking 1st element in queue:"+q.peek());
	    q.enqueue(33);
	    q.enqueue(89);
	    q.print();
	    System.out.println();
	    System.out.println("Dequeued value:"+ q.dequeue());
	    System.out.println("Size:"+ q.size());
	}
}
