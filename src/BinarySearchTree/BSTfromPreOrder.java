/** This is a program to construct BST from given Preorder traversal.
 *  We know, that 1st element of Preorder traversal is the root node.
 */
package BinarySearchTree;

import BinarySearchTree.BinarySearchTree.Node;

/**
 * @author msn2106
 */
public class BSTfromPreOrder {

	static Node root;
	
	public static void main(String[] args) {
		int[] pre = {10,5,1,7,40,50};
		
		root = constructBST(pre);
		
		System.out.print("Inorder traversal of BST is:");
		inorder(root);
	}

	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key +" ");
			inorder(root.right);
		}
	}

	private static Node constructBST(int[] pre) {
		if(root == null) {
			
		}
		return root;
	}

}
