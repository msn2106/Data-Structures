/*Program to implement stack data structure using array.*/
/* Methods of stack have O(1) time complexity */
package stack;

public class stackArray {
    private static int size = 5;
    private static Object stack[] = new Object[size];
    private static int top = -1;
    //function to push data
    public void push(Object data){
        if(size()==size) System.out.println("Stack Overflow.");//throw new stackFullException("Stack Overflow");
        stack[++top] = data;        
    }

    //function to pop the data
    public Object pop() throws stackEmptyException{
        Object temp = null;
        if(isEmpty()) {
            throw new stackEmptyException("Stack is Empty");
        }
        temp = stack[top];
        stack[top--] = null;	//Dereferenced stack[top] & decrement top
        return temp;
    }

    //function to peek the data - return the top element of the stack
    public Object peek() throws stackEmptyException{
        if(isEmpty()) throw new stackEmptyException("Stack is Empty");
        return stack[top];      
    }

    //return the current size of the stack
    public static int size(){
     return top+1;
    }

    //function to check whether the stack is empty or not 
    public static boolean isEmpty(){
        return top == -1;
    }

    //function to print the stack
    public void print(){
        int temp = top;
	if(top == -1) System.out.println("Stack Underflow");
	else{
        	while(temp > -1){
            	System.out.print(stack[temp]+" ");
            	temp--;
        	}
	}
    }

    //main function
    public static void main(String args[]) {
        stackArray stack = new stackArray();
        System.out.println("Is Stack Empty ? :" + isEmpty());
        //System.out.println(stack.peek());
        //System.out.println(stack.pop());
        //stack.print();
        stack.push(5);
        stack.push(11);
        stack.push(8);
        stack.push(19);
        stack.push(44);
        stack.push(89);
        stack.print();

        System.out.println("The popped value is:"+stack.pop());
        stack.print();
        
        System.out.println("Is Stack Empty ? :" + isEmpty());

        System.out.println("Peeked value from top is:"+ stack.peek());
                
        System.out.println("Peek don't pop the top, so the stack is:");
        stack.print();

        System.out.println("Size :"+ size());
    }
}