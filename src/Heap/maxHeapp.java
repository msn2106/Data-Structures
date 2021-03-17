/* Program to implement Max Heap using array*/
package Heap;

public class maxHeapp {

	private int[] heap;
	private int pos;
	private int capacity;

	public maxHeapp(int cap) {
		this.capacity = cap;
		heap = new int[cap];
		pos = 1;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	public static void main(String[] args) {
		maxHeapp mheap = new maxHeapp(10);
		mheap.insert(12);
		mheap.insert(7);
		mheap.insert(20);
		mheap.insert(8);
		mheap.insert(42);
		mheap.insert(31);
		mheap.insert(4);

		mheap.print();

		System.out.println();
		System.out.println("Maximum value:" + mheap.getMax());
		System.out.println();

		mheap.print();

		System.out.println();
		System.out.println("Maximum value:" + mheap.extractMax());
		System.out.println();

		mheap.print();
	}

	private void print() {
		for (int i = 1; i < pos; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	private void insert(int val) {
		if (pos >= capacity) return;
		heap[pos++] = val;
		int current = pos;

		while (heap[parent(current)] < heap[current]) {
			swap(parent(current), current);
		}
	}
	private void swap(int parent, int current) {
		int temp = parent;
		parent = current;
		current = temp;
	}

	private int getMax () {
		return heap[1];
	}

	private int extractMax () {
		int maxVal = heap[1];
		heap[1] = heap[pos];
		return maxVal;
	}
}


