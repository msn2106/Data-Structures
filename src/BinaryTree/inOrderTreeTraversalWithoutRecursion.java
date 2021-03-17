/** This is a program to implement - inorder traversal in a binary tree using Stack and without using recursion. * 
 */
package BinaryTree;

import java.util.Stack;

/**
 * @author msn2106
 */

public class inOrderTreeTraversalWithoutRecursion {
	
	Node root;
	
	public inOrderTreeTraversalWithoutRecursion(int x) {
		root = new Node(x);
	}
	
	public inOrderTreeTraversalWithoutRecursion() {
		root = null;
	}

	public static void main(String[] args) {
		inOrderTreeTraversalWithoutRecursion tree = new inOrderTreeTraversalWithoutRecursion();
		tree.root = new Node(4);
		tree.root.left = new Node(8);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(16);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(24);
		
		System.out.println("Tree traversal in Inorder without using recursion:");
		inorder(tree.root);		

	}

	//method for inorder traversal of the tree without using recursion and using Stack.
	public static void inorder(Node root) {
		if(root == null) return;
		Stack<Node> st = new Stack<Node>();
		
		Node current = root;
		
		//traverse the tree
		while(current != null || st.size()>0) {
			
			//Reach the leftmost node of the tree
			while(current != null) {
				st.push(current);
				current = current.left;
			}
			//when current turns null
			current = st.pop();
			System.out.print(current.data+" ");
			//now visiting right subtree
			current = current.right;	
		}
	}
}
