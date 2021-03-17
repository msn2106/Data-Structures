/* Linked List creation, implementation and different methods */
package LinkedList;
//No need to import Node class, as it is already in this package and public in nature.
public class SinglyLinkedList {

    Node head;	//this is a reference variable, it has reference to the first node.

    //function to insert data in end
    public void append(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //function to insert data in start
    public void insertAtStart(int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //function to insert at a given index
    public void insertAtIndex(int index,int data)
    {
        if(index<0 || index>size()){
            System.out.println("Trying to insert out of bound");
            return;
        }
        if(index==0) insertAtStart(data);
        else if(index==size()) append(data);
        else {
            Node node = new Node(data);
            Node temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    //function to remove element at a given index
    public void removeAt(int index){
        if(index<0 || index>=size()) {
            System.out.println("Trying to Delete out of Bound:Index:"+index);
            return;
        }
        if(index==0) {
            //head = head.next; //will give null pointer exception when linked list has only 1 object.
            if(head.next != null)head = head.next;
            else head = null;
        }
        else {
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            //temp = null;	//makes temp null and available for garbage collection.//no need in JAVA
            //System.out.println("temp "+ temp.data); //to test the value deleted.
        }
    }

    //function to check whether the list is empty or not
    public boolean isEmpty(){
        return head == null;
    }

    //function to print the list
    public void print() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);  //System.out.println(temp+" "+temp.data+" "+temp.next); //use this to understand.
            temp = temp.next;
        }
    }

    //function to calculate the size of linked list
    public int size() {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count = count+1;
            temp = temp.next;
        }
        return count;
    }

    //driver function
    public static void main(String[] args){
        SinglyLinkedList myll = new SinglyLinkedList();
        myll.append(12);
        myll.append(56);
        myll.append(36);
        myll.insertAtStart(33);
        myll.insertAtIndex(2, 22);
        myll.insertAtIndex(5, 247);
        myll.insertAtIndex(0,12);
        //System.out.println(myll.head); 	//use this in different lines to check the changing values of head.
        myll.removeAt(7);
        myll.print();
        System.out.println("Size of linked list:"+myll.size());
    }
}
