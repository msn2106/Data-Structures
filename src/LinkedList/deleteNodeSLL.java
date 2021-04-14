package LinkedList;
import java.util.Scanner;

class DeleteNode{
    Node head;
    void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addToTheLast(Node node){
        if(head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}

class Gfg{
    //deletes nodes from position not index
    Node deleteNode(Node head, int x)
    {
        // Your code here
        if(x==1){
            head = head.next;
            return head;
        }
        Node temp = head;
        while(x-- > 2){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

public class deleteNodeSLL{

    Node head;
    // function pasted later - pas the key only
    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /* This function prints contents of linked list starting
       from the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    //driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            DeleteNode llist = new DeleteNode();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for(int i=1;i<n;i++){
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            int x = sc.nextInt();
            Gfg g = new Gfg();
            Node result = g.deleteNode(llist.head,x);
            llist.printList(result);
        }
        sc.close();
    }
}

/* TC:-
2
3
1 3 4
3
4
1 5 2 9
2
 */
/* Result :-
1 3
1 2 9
 */
