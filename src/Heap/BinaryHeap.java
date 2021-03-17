/** This is a program to implement - Binary Heap
 *  Binary Heap is either Max Heap or Min Heap.
 *  Below is the implementation of min heap.
 *  Not working
 */
package Heap;

/**
 * @author msn2106
 */

class MinHeap{

	int[] harr;
	int capacity;	//maximum possible size of heap
	int heap_size;	//Current number of elements in heap
	
	// Constructor: Builds a heap from a given array a[] of given size
	public MinHeap(int cap) {
		heap_size = 0;
		capacity = cap;
		harr = new int[cap];
	}
	
	// A recursive method to heapify a subtree with the root at given index 
	// This method assumes that the subtrees are already heapified 
	void MinHeapify(int i) {
		int l = left(i); 
	    int r = right(i); 
	    int smallest = i; 
	    if (l < heap_size && harr[l] < harr[i]) 
	        smallest = l; 
	    if (r < heap_size && harr[r] < harr[smallest]) 
	        smallest = r; 
	    if (smallest != i) 
	    { 
	        swap(harr[i], harr[smallest]); 
	        MinHeapify(smallest); 
	    } 
	}
		
	int parent(int i) {
		return (i-1)/2;
	}
	
	//to get index of left child of node at index i
	int left(int i) {
		return (2*i)+1;
	}
	
	//to get index of right child of node at index i
	int right(int i) {
		return (2*i)+2;
	}
	
	// Method to remove minimum element (or root) from min heap
	int extractMin() {
		if (heap_size <= 0) 
	        return Integer.MAX_VALUE; 
	    if (heap_size == 1) 
	    { 
	        heap_size--; 
	        return harr[0]; 
	    } 
	  
	    // Store the minimum value, and remove it from heap 
	    int root = harr[0]; 
	    harr[0] = harr[heap_size-1]; 
	    heap_size--; 
	    MinHeapify(0); 
	  
	    return root; 
	}
	
	// Decreases value of key at index 'i' to new_val.  It is assumed that 
	// new_val is smaller than harr[i]
	void decreaseKey(int i, int new_val) {
		harr[i] = new_val; 
	    while (i != 0 && harr[parent(i)] > harr[i]) 
	    { 
	       swap(harr[i], harr[parent(i)]); 
	       i = parent(i); 
	    } 
	}
			
	//Returns minimum key (key at root) from min heap
	int getMin() {
		return harr[0];
	}
			
	// This function deletes key at index i. It first reduced value to minus 
	// infinite, then calls extractMin() 
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE); 
	    extractMin(); 
	}
			
	//insert a new key "k"
	void insertKey(int k) {
		if(heap_size == capacity) {
			System.out.println("Overflow : Cannot insert a key");
			return;
		}
		//first insert the new key at the end
		heap_size++;
		int i = heap_size -1;
		harr[i] = k;
		
		//fix the min heap property if it is violated
		while(i != 0 && harr[parent(i)]> harr[i]) {
			swap(harr[i], harr[parent(i)]);
			i = parent(i);
		}
	}
	
	// A utility function to swap two elements 
	void swap(int x, int y) 
	{ 
	    int temp = x; 
	    x = y; 
	    y = temp; 
	} 
	
}

public class BinaryHeap {

	public static void main(String[] args) {
		MinHeap h = new MinHeap(11);
		h.insertKey(3); 
	    h.insertKey(2); 
	    h.deleteKey(1); 
	    h.insertKey(15); 
	    h.insertKey(5); 
	    h.insertKey(4); 
	    h.insertKey(45); 
	    System.out.println(h.extractMin()+" "); 
	    System.out.println(h.getMin()+" "); 
	    h.decreaseKey(2, 1); 
	    System.out.println(h.getMin()); 
	}

}
