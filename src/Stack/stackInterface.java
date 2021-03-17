/* This is a stack interface, consisting of all the basic method and other details.*
 * These methods have to implemented by all the other stack classes.
 */
package stack;
/**
 * @author msn2106
 *
 */
public interface stackInterface {
	
	//access methods
	public int size();
	public boolean isEmpty();
	public Object peek() throws stackEmptyException;
	
	//update methods
	public void push(Object element);
	public Object pop() throws stackEmptyException;
}

// An interface provides the details about variables and methods that are needed to built a class.
// There can be multiple implementation of the same interface in the form of classes.
// But once we have idea of interface, we can use any implementing class to create objects; as we have idea about the basic variables 
// and the methods along with there signature and arguments that are going to be used in the class.