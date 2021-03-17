/*This is a program to implement grow-able stack using array.*
 * Now the growth could either be :
 * 1. Tight Strategy = size + constant(c) - Time Complexity - O(n^2/c)
 * 2. Growth Strategy = 2*size - Time Complexity - O(4n-1) - *Better*
 */
package stack;
/**
 * @author msn2106
 *
 */
public class stackArrayGrowable implements stackInterface{
	
	private final static int MAX_SIZE = 1024;		//maximum size granted for the stack.

	private static int size = 5;
    private static Object stack[] = new Object[size];
    private static int top = -1;
    //function to push data using tight strategy. Here constant is 5.
    public void push(Object data){
    	int constant = 5;
        if(size() == size-1 && size < (MAX_SIZE-constant-1)) {
        	size = size+constant;
        	Object[] newStack = new Object[size];
        	for(int i=0;i<stack.length-1;i++) {
        		newStack[i] = stack[i];
        	}
        	stack = newStack;
        	top++;
        	stack[top] = data;
        }
        else stack[++top] = data;
    }
    
  //function to push data using growth strategy. Here size gets twice whenever we need to have more elements in stack. 
    public void push2(Object data){
        if(size() == size-1 && size < (MAX_SIZE/2)) {
        	int currentSize = size();
        	Object[] newStack = new Object[2*currentSize];
        	for(int i=0;i<stack.length-1;i++) {
        		newStack[i] = stack[i];
        	}
        	stack = newStack;
        	top++;
        	stack[top] = data;
        }
        else stack[++top] = data;
    }
    
    //function to pop the data
    public Object pop() throws stackEmptyException{
        Object temp = null;
        if(isEmpty()) {
            throw new stackEmptyException("Stack is Empty. Nothing to pop.");
        }
        temp = stack[top];
        stack[top--] = null;	//Dereferenced stack[top] & decrement top
        return temp;
    }
    
    //function to peek the data - return the top element of the stack
    public Object peek() throws stackEmptyException{
        if(isEmpty()) throw new stackEmptyException("Stack is Empty. Thullu");
        return stack[top];      
    }
    
    //function to return top (index) of the stack
    public int top() {
    	if(isEmpty()) throw new stackEmptyException("Stack is Empty");
    	return top;
    }
    //return the current size of the stack
    public int size(){
     return top+1;
    }
    
    //function to check whether the stack is empty or not 
    public boolean isEmpty(){
        return top == -1;
    }
    
    //function to print the stack
    public void print(){
        int temp = top;
        if(top == -1) System.out.println("Stack Underflow. Nothing to print.");
        else{
        		while(temp > -1){
        			System.out.print(stack[temp]+" ");
        			temp--;
        		}
        }
    }

    //main function
    public static void main(String args[]) {
        stackArrayGrowable stack = new stackArrayGrowable();
        System.out.println("Is Stack Empty ? :" + stackArray.isEmpty());
        //System.out.println(stack.peek());
        //System.out.println(stack.pop());
        //System.out.println("Size :"+ stack.size());
        //stack.print();
        stack.push(5);
        stack.push(11);
        stack.push(8);
        stack.push(19);
        stack.push(44);		//from here size became 5+5 = 10.
        stack.push(89);
        stack.push(0);
        stack.push2(7);
        stack.push(202);
        stack.push2(17);	//from here stack size became 10*2 = 20
        stack.push(21);        
        stack.print();

        System.out.println();
        System.out.println("The popped value is:"+stack.pop());
        stack.print();
        
        System.out.println();
        System.out.println("Is Stack Empty ? :" + stack.isEmpty());

        System.out.println("Peeked value from top is:"+ stack.peek());
                
        System.out.println("Peek don't pop the top, so the stack is:");
        stack.print();

        System.out.println();
        System.out.println("Size :"+ stack.size());
    }

}
