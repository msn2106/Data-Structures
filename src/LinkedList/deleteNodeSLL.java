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
    Node deleteNode(Node head, int x)
    {
        // Your code here
        Node temp = head;
        int index = 0;
        if(x==1){
            head = head.next;
            return head;
        }
        if(x==2){
            head.next = head.next.next;
            return head;
        }
        while(index < (x-2) && temp.next !=null){
            temp = temp.next;
            index++;
        }
        assert temp.next != null;
        temp.next = temp.next.next;
        return head;
    }
}

public class deleteNodeSLL{
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