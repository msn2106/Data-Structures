/*Program to implement Binary Tree using array.*/
/** The left child is at position (2*i)+1, and the right at (2*i)+2; where array start from 0.
 * And "i" represent the node index.
 * For Parent of any node:- [(i-1)/2]
 */
package tree;

/**@author msn2106
 */
public class binaryTreeArray {

	static int num = 10;
	static int[] arr = new int[num];
	static int size = 0;
	
	//function to add data to binary tree formed using array
	public void insert(int x) {
		if(size-1 >= arr.length-1) return;
		else {
			int i=0;
			while(i<size) {
				arr[i]=x;
				i++;
			}
			size++;
		}
	}
	
	//function for inorder traversal of tree
	public void inorder() {
		int temp = size;
		if(temp == 0) return;
		else {
			int i=0;
			inorder();
			System.out.print(arr[i]+" ");
			inorder();
		}
	}
	
	//main function
	public static void main(String[] args) {
		binaryTreeArray tree = new binaryTreeArray();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		
//		System.out.print("Tree in Inorder:");
//		tree.inorder();
//		System.out.println();
		
//		System.out.print("Tree in Inorder:");
//		tree.postorder();
//		System.out.println();
//		
//		System.out.print("Tree in Inorder:");
//		tree.preorder();
//		System.out.println();
	}

}
