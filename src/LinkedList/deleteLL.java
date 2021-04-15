package LinkedList;


public class deleteLL {

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    static Node head;

    //deleting complete Linked List
    void deleteLL(){
        head = null;
    }

    // push data at start
    void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //iterative method to print LL
    void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        deleteLL ll = new deleteLL();

        for (int i = 0; i < 10; i++) {
            ll.push(i);
        }

        System.out.println("LL at present:");
        ll.printLL();

        System.out.println("Deleting LL...");
        ll.deleteLL();

        System.out.println("LL Now..");
        ll.printLL();
    }
}
