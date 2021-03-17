/** This is a program to find the maximum value in binary tree.
 * 
 */
package BinaryTree;
import java.util.Stack;

import binaryTree.InorderTraversalWithoutStackNRecursion;
/**
 * @author msn2106
 */
public class MaximumInBinaryTree {

	static Node root;
	
	public MaximumInBinaryTree() {
		root = null;
	}
	
	public MaximumInBinaryTree(int x) {
		root = new Node(x);
	}
	
	public static void main(String[] args) {
		MaximumInBinaryTree tree = new MaximumInBinaryTree();
		root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(50);
		root.left.left = new Node(15);
		root.left.right = new Node(25);
		root.right.left = new Node(20);
		root.right.right = new Node(30);
		root.right.right.left = new Node(40);
		
		System.out.println("The maximum value in the tree is:" + maxValue(root));

	}

	public static Integer maxValue(Node root) {
		Node maxNode = root;
		if(root == null) return null;
		else {
			maxValue(root.left);
			maxValue(root.right);
			if(root.data > maxNode.data) {
				maxNode.data = root.data;
			}
			return root.data;
		}
	}

}
