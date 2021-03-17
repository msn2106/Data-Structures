package LinkedList;

public class reverseLLtemp {
	//Node class is present in the package
	static Node head;
	
	//function to insert data in linked list (by default in end)
	public void append(int data) {
		Node node = new Node(data);
		Node temp = head;
		if(head == null) {
			head = node;
			return;
		}
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
	//recursive function to reverse the linked list	 - some problem
	public static Node reverse(Node head) {
		if(head == null) return null;
        Node temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
	}
	
	//function to print the linked list - some problem - no problem
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//driver function
	public static void main(String[] args) {
		reverseLLtemp revll = new reverseLLtemp();
		int i = 0;
		while(i++<10) revll.append(i);
		System.out.println("Before reversing:");
		revll.print();
		
		System.out.println("After reversing:");
		reverse(head);
		revll.print();
	}
}
