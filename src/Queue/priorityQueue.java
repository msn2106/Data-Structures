package queue;
import java.util.PriorityQueue;
public class priorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Xmas");
		pq.add("Mango");
		pq.add("Apple");
		pq.add("Banana");
		pq.add("Kiwi");
		
		System.out.println(pq);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
