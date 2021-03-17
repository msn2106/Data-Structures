/* Program to implement Binary Search Tree*
 * 
 */
package tree;

/**
 * @author msn2106
 *
 */
public class binarySearchTree {
	
	static Node root;
	
	public binarySearchTree() {
		root = null;
	}
	
	//function to insert Node in Binary Search tree
//	public static Node insert(Node root, int Key) {
//		if(root == null) {
//			root = new Node(Key);
//			return root;
//		}
//		if(root.data > Key) {
//			if(root.left == null) {
//				root.left = new Node(Key);
//			}
//			insert(root.left, Key);
//			return root;
//		}
//		else if(root.data < Key) {
//			if(root.right == null) {
//				root.right = new Node(Key);
//			}
//			insert(root.right, Key);
//			return root;
//		}
//		else return root;
//	}
	public void insert(int Key) {
		root = insertRec(root, Key);
	}
	
	//recursive function to add node in BST
	public static Node insertRec(Node root, int Key) {
		if(root == null) {
			root = new Node(Key);
			return root;
		}
		if(root.data > Key)	root.left = insertRec(root.left, Key);
		else if(root.data < Key) root.right = insertRec(root.right, Key);
		return root;
	}
	
	//function to print the Binary Search Tree in InOrder 
	public void print() {
		inorder(root);
		System.out.println();
	}
	public void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	//recursive function to search a given key in Binary Search Tree
	public Node search(Node root, int key) {
		if(root == null || root.data == key) return root;
		if(root.data > key) return search(root.left, key);
		else if(root.data < key) return search(root.right, key);
		else return null;	//if no such key is present, this function returns null.
	}
	
	
	//Return the root of the modified BST after deleting the node with value X
	public static Node deleteNode(Node root, int X)
	{
		if(root == null) return null;
		if(root.data > X) root.left = deleteNode(root.left,X);
		else if(root.data < X) root.right = deleteNode(root.right,X);
		else{
			if(root.left == null) return root.right;
		    else if(root.right == null) return root.left;
		    root.data = minValue(root.right);
		    root.right = deleteNode(root.right, root.data);
		}
		return root;
	}
		
	//function to find the minimum value
		public static int minValue(Node root){
			int min = root.data;
		    while(root.left != null){
		        min = root.left.data;
		        root = root.left;
		    }
		    return min;
		}
	//main function
	public static void main(String[] args) {
		binarySearchTree tree = new binarySearchTree();
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
		
		System.out.println("Binary Search Tree:");
		tree.print();
		System.out.println();
		System.out.println(tree.search(root, 20));
		System.out.println();
	    
	    System.out.println("Deleting 20");
	    deleteNode(root, 20);
	    System.out.print("Inorder traversal of modified BST:");
	    tree.print();
	    
	    System.out.println("\nDelete 30"); 
	    deleteNode(root, 30); 
	    System.out.print("Inorder traversal of the modified BST:"); 
	    tree.print(); 

	    System.out.println("\nDelete 50"); 
	    deleteNode(root, 50); 
	    System.out.print("Inorder traversal of the modified BST:"); 
	    tree.print(); 

	}

}
