package LinkedList;

public class GfgLL {

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    static Node head;

    //finding length - iterative
    int length(){
        int l = 0;
        GfgLL.Node temp = head;
        while(temp != null){
            l++;
            temp = temp.next;
        }
        return l;
    }

    int lengthR(GfgLL.Node node){
        if(node == null)return 0;
        return 1+lengthR(node.next);
    }

    //find length recursively
    int recursiveLength(){
        return lengthR(head);
    }

    //iterative method to search in LL
    int search(int x){
        int index = 0;
        GfgLL.Node temp = head;
        while(temp != null){
            if(temp.data == x){
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    //recursive method to search in LL
    boolean recSearch(GfgLL.Node node, int x){
        if(node == null)return false;
        if(node.data == x)return true;
        else return recSearch(node.next,x);
    }

    // to find the value at nth position
    public int getNth(GfgLL.Node node, int ind)
    {
        //Your code here
        int index = 1;
        while(node != null){
            if(index == ind)return node.data;
            index++;
            node = node.next;
        }
        assert (false);
        return -1;
    }

    //function to find the middle element of the linked list ( 3 for 5 and 4 for 6)
    int getMiddle(GfgLL.Node head)
    {
        // O(n) - counting and then running till half
//        if(head == null)return 0;
//        Node temp = head;
//        int count = 0;
//        while(temp != null){
//            temp = temp.next;
//            count++;
//        }
//        temp = head;
//        for(int i=0;i<count/2 ;i++){
//            temp = temp.next;
//        }
//        return temp.data;

        // two pointer method - O(logN)
//        Node slow = head, fast = head;
//        if(head != null){
//            while(fast != null && fast.next != null){
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//        }
//        return slow.data;

        //another way - O(N)
        int count = 0;
        GfgLL.Node mid = head;
        while(head != null){
            if(count %2 == 1)mid = mid.next;
            count++;
            head = head.next;
        }
        if(mid != null)return mid.data;
        else return -1;
    }

    //Occurence of an integer in a Linked List - No. of times it is present
    public static int count(GfgLL.Node head, int search_for)
    {
        //code here
        GfgLL.Node temp = head;
        int count = 0;
        while(temp != null){
            if(temp.data == search_for) count++;
            temp = temp.next;
        }
        return count;
    }

    //function to create loop
    public static void makeLoop(Node head, Node tail, int x){
        if(x==0) return;
        Node current = head;

        for (int i = 0; i < x; i++) {
            current = current.next;
        }
        tail.next = current;
        tail.next = head;
    }

    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // method 1 - O(n) time and space
        // HashSet<Node> hs = new HashSet<Node>();
        // while(head != null){
        //     if(hs.contains(head))return true;
        //     hs.add(head);
        //     head = head.next;
        // }
        // return false;

        // method 2 O(n) time and O(1) space
        Node slow = head, fast = head;
        while (slow != null && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //iterative method to print LL
    void printLL(){
        GfgLL.Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // push data at start
    void push(int data){
        GfgLL.Node newNode = new GfgLL.Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        GfgLL gl  = new GfgLL();

        for(int i=0;i<10;i++){
            gl.push(i);
        }

        gl.printLL();

        System.out.println("Searching 4 in LL:"+ "Index :"+gl.search(4));
        System.out.println("Searching 14 in LL:"+ "Index :"+gl.search(14));

        System.out.println("Searching 4 in LL:"+ "Index :"+gl.recSearch(head,4));
        System.out.println("Searching 14 in LL:"+ "Index :"+gl.recSearch(head,14));

        System.out.println("The value at 5th position is:"+ gl.getNth(head,5));

        System.out.println("The middle element of the LL is:"+ gl.getMiddle(head));

        System.out.println("The length of the LL is:"+gl.length());
        int x = 5;
        if(x < gl.length()){
            makeLoop(head, head.next.next, x);
        }else System.out.println("Length exceeded.");

        System.out.println("Is there a loop ?:"+ detectLoop(head));


    }
}
