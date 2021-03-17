/*Program to learn stack ADT and its functions*/
package stack;
import java.util.Stack;
public class stackADT {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.empty());
		stack.add(12);
		stack.add(14);
		stack.add(16);
		System.out.println(stack.empty());
		System.out.println(stack.size());
		System.out.println(stack);
		
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println();
		System.out.println(stack.peek());
		stack.push(22);
		System.out.println(stack);
		stack.remove(1);
		System.out.println("New Stack:"+ stack);
		

	}

}
