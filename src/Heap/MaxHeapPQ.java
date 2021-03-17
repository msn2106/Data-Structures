package Heap;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
public class MaxHeapPQ {
	public static void main(String[] args) {
		//creating an empty priority queue.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		//adding elements
		pq.add(12);
		pq.add(7);
		pq.add(20);
		pq.add(8);
		pq.add(42);
		pq.add(31);
		pq.add(4);
				
		System.out.println("Head value using peek function:"+ pq.peek());
		
		System.out.println();
		System.out.println("The PQ elements:");
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		System.out.println(); System.out.println();
		//removing the top priority element and then printing the pq
		pq.poll();
		System.out.println("PQ elements after calling poll() once:");
		Iterator<Integer> itr2 = pq.iterator();
		while(itr2.hasNext()) {
			System.out.print(itr2.next()+" ");
		}
		
		System.out.println(); System.out.println();
		//removing element by name
		pq.remove(19);
		System.out.println("PQ elements after removing 19:");
		Iterator<Integer> itr3 = pq.iterator();
		while(itr3.hasNext()) {
			System.out.print(itr3.next()+" ");
		}
		
		System.out.println(); System.out.println();
		//checking if pq contains an element or not (17)
		boolean b = pq.contains(17);
		System.out.print("PQ contains 17:"+b);
		
		System.out.println(); System.out.println();
		//getting objects from pq using toArray() in an array and printing
		Object[] arr = pq.toArray();
		System.out.println("Value in array:");
		for(Object i:arr)System.out.print(i+" ");
		
	}
	
}
//Max heap : 42 20 31 7 8 12 4 
