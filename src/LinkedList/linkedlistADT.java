/* Program to learn Linked List ADT */

package LinkedList;
import java.util.LinkedList;
public class linkedlistADT {

	public static void main(String[] args) {
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
        LinkedList<Integer> ll2 = new LinkedList<Integer>();
        ll1.add(12);
        ll1.add(9);
        ll1.add(72);
        ll1.add(45);
        ll2.add(17);
        ll2.add(90);
        ll2.add(12);
        ll2.add(5);
        ll1.sort(null);
        ll2.sort(null);
        System.out.println(ll1);
        System.out.println(ll2);
        ll2.addAll(ll1);
        System.out.println(ll2);

	}

}
