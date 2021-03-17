package LinkedList;

public class Node {
	
	int data;
//	String data;
//	char data;
//	float data;
//	double data;
	
	
	Node next;
	Node prev;
	
	public Node(){
		this.data = 0;
		this.next = null;
		this.prev = null;
	}

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
/*	//String 
	public Node(){
		this.data = " ";
		this.next = null;
		this.prev = null;
	}

	public Node(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
*/	
/*	//char
	public Node(){
		this.data = ' ';
		this.next = null;
		this.prev = null;
	}

	public Node(char data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
*/	
/*	//float
	public Node(){
		this.data = 0.0f;
		this.next = null;
		this.prev = null;
	}

	public Node(float data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
*/
/*	//double	
	public Node(){
		this.data = 0.0;
		this.next = null;
		this.prev = null;
	}

	public Node(double data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
*/
/*	//Other User-made class	
	public Node(obj data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
*/	
}
