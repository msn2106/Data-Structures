/** This is a program to implement - inorder traversal without using stack or recursion.
 * It uses the concept of Morris traversal - based on threaded tree
 * In this traversal, we first create links to Inorder successor and print the data using these links, 
 * and finally revert the changes to restore original tree. 
 */
package binaryTree;

/**
 * @author msn2106
 */
class Node{
	int data;
	Node left,right;
	
	public Node(int x) {
		data = x;
		left = right = null;
	}
}

public class InorderTraversalWithoutStackNRecursion {
	
	static Node root;
	
	public InorderTraversalWithoutStackNRecursion() {
		root = null;
	}
	
	public InorderTraversalWithoutStackNRecursion(int x) {
		root = new Node(x);
	}
	
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(6);
		root.right = new Node(9);
		root.left.left = new Node(12);
		root.left.right = new Node(15);
		root.right.left = new Node(18);
		root.right.right = new Node(21);
		
		System.out.println("Traversal in Inorder:");
		MorrisTraversal(root);

	}

	//function to print the tree in inorder without using stack and recursion
	public static void MorrisTraversal(Node root) 
	{ 
	    Node current, pre; 

	    if (root == null) 
	        return; 

	    current = root; 
	    while (current != null) { 
	        if (current.left == null) { 
	            System.out.print(current.data + " "); 
	            current = current.right; 
	        } 
	        else { 
	            /* Find the inorder predecessor of current */
	            pre = current.left; 
	            while (pre.right != null && pre.right != current) 
	                pre = pre.right; 

	            /* Make current as right child of its inorder predecessor */
	            if (pre.right == null) { 
	                pre.right = current; 
	                current = current.left; 
	            } 

	            /* Revert the changes made in the 'if' part to restore the  
	                original tree i.e., fix the right child of predecessor*/
	            else { 
	                pre.right = null; 
	                System.out.print(current.data + " "); 
	                current = current.right; 
	            } /* End of if condition pre.right == null */

	        } /* End of if condition current.left == null*/

	    } /* End of while */
	}
	
}

 
