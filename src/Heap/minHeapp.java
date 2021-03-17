/*Program to implement Min Heap using array.*/
package Heap;

public class minHeapp {

	private int[] heap;
	private int size;		//current heap size
	private int maxSize;	//max heap size
	
	private static final int FRONT = 1;
	
	public minHeapp(int maxsize) {
		this.maxSize = maxsize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}
	
	//return node's parent node position
	private int parent(int pos) {
		return pos/2;
	}
	
	//return node's left child node position
	private int leftChild(int pos) {
		return (2*pos);
	}
	
	//return node's right child node position
	private int rightChild(int pos) {
		return (2*pos)+1;
	}
	
	//return true when the position given is of leaf node
	private boolean isLeaf(int pos) {
		if(pos >=(size/2) && pos <=size) return true;
		return false;
	}
	
	//used to swap to nodes for moving lower up in tree
	private void swap(int fpos, int spos) {
		int temp;
		temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}
	
	//function for inserting new element at the bottom and then moving it to its right position
	public void insert(int element) {
		if(size >= maxSize) return;
		heap[++size] = element;
		int current = size;
		
		while(heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
		}
	}
	
	//function to print the min Heap 
	public void print() {
		for(int i=1; i<=size/2; i++) {
			System.out.println("P:"+heap[i]+" L:"+heap[2*i]+" R:"+heap[2*i+1]);
			System.out.println();
		}
		System.out.print("Min Heap Array:");
		for(int i=1;i<=size;i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}

	public void minHeap(){
		for(int pos = (size/2); pos>=1; pos--) {
			minHeapify(pos);
		}
	}
	
	//function to rearrange tree an maintain min heap property
	private void minHeapify(int pos) {
		//if the given position is already at leaf, then it won;t have a left or right child
		if(!isLeaf(pos)) {
			//if the given node position has bigger value than the left and right child -> it is to be moved down
			if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				//if left child is smaller than right child the parent is swapped with left child
				if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}
				//when right child is smaller parent is swapped with right child
				else {
					swap(pos,rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	//function to remove the element from min Heap - Time - O(1)
	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;		
	}
	
	//main driver function
	public static void main(String[] args) {
		System.out.println("The Min Heap is "); 
        minHeapp minHeap = new minHeapp(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
  
        minHeap.print();
        
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        
        System.out.println();
        minHeap.print();
        
	}
}