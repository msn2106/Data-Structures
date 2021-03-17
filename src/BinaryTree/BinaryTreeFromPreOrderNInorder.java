/** Program to construct Binary Tree from given Inorder and Preorder traversal(array)
 * 
 */
package BinaryTree;
/**
 * 
 * @author msn2106
 */
class Node{
	int data;
	Node left,right;

	public Node(int i) {
		this.data = i;
		left = right = null;
	}
}
public class BinaryTreeFromPreOrderNInorder {

	static Node root;
	
	public static void main(String[] args) {
		BinaryTreeFromPreOrderNInorder tree = new BinaryTreeFromPreOrderNInorder();
		int pre[] = {1,2,4,8,9,10,11,5,3,6,7};
		int in[] = {8,4,10,9,11,2,5,1,6,3,7};
		
		root = constructBT(pre,in);
		
		System.out.print("The BT in Inorder is:");
		tree.inorder(root);
	}

	//function to construct a binary tree from given preorder and inorder
	private static Node constructBT(int[] pre, int[] in) {
		return helper(0,0,in.length-1,pre,in);
	}

	//function to scroll through preorder array and inorder array and return root having all nodes linked
	private static Node helper(int preStart, int inStart, int inEnd, int[] pre, int[] in) {
		if(preStart > pre.length-1 || inStart > inEnd) return null;
		
		Node root = new Node(pre[preStart]);
		
		int inIndex = 0;
		for(int i=inStart; i<=inEnd; i++) {
			if(root.data == in[i]) {
				inIndex = i;
			}
		}
		
		root.left = helper(preStart+1, inStart, inIndex-1, pre, in);
		root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, pre, in);
		
		return root;	
	}

	//function to print the binary tree in Inorder
	private void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
