/** This class signifies the empty nature of the stack. 
 * It is been used in stackInterface with the methods that can throw empty exception.
 * This class extends Runtime Exception class.
 */
package stack;
import java.lang.RuntimeException;
/**
 * @author msn2106
 *
 */
@SuppressWarnings("serial")
public class stackEmptyException extends RuntimeException{

	/**
	 * @param args
	 */
	
	public stackEmptyException(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		stackEmptyException see = new stackEmptyException("Stack Underflow");

	}

}
//more improvement needed