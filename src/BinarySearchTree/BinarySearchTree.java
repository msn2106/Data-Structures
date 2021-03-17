/* Program to implement Binary Search Tree*
 * 
 */
package BinarySearchTree;

/**
 * @author msn2106
 *
 */
class BinarySearchTree { 

 /* Class containing left and right child of current node and key value*/
class Node { 
	int key; 
    Node left, right; 

    public Node(int item) { 
        key = item; 
        left = right = null; 
    } 
} 

// Root of BST 
static Node root; 

// Constructor 
BinarySearchTree() {  
    root = null;  
} 

// This method mainly calls insertRec() 
void insert(int key) { 
   root = insertRec(root, key); 
} 
   
/* A recursive function to insert a new key in BST */
Node insertRec(Node root, int key) { 
	/* If the tree is empty, return a new node */
    if (root == null) { 
        root = new Node(key); 
        return root; 
    } 
    /* Otherwise, recur down the tree */
    if (key < root.key) 
        root.left = insertRec(root.left, key); 
    else if (key > root.key) 
        root.right = insertRec(root.right, key); 
    /* return the (unchanged) node pointer */
    return root; 
} 

// This method mainly calls InorderRec() 
void inorder()  { 
   inorderRec(root); 
   System.out.println();
} 

// A utility function to do inorder traversal of BST 
void inorderRec(Node root) { 
    if (root != null) { 
        inorderRec(root.left); 
        System.out.print(root.key+" "); 
        inorderRec(root.right); 
    }
} 
 
//Return the root of the modified BST after deleting the node with value X
public static Node deleteNode(Node root, int X)
{
	if(root == null) return null;
	if(root.key > X) root.left = deleteNode(root.left,X);
	else if(root.key < X) root.right = deleteNode(root.right,X);
	else{
		if(root.left == null) return root.right;
	    else if(root.right == null) return root.left;
	    root.key = minValue(root.right);
	    root.right = deleteNode(root.right, root.key);
	}
	return root;
}
	
//function to find the minimum value
	public static int minValue(Node root){
		int min = root.key;
	    while(root.left != null){
	        min = root.left.key;
	        root = root.left;
	    }
	    return min;
	}
//function to find maximum value in BST
	public static int maxValue(Node root) {
		Node current = root;
		while(current.right != null) {
			current = current.right;
		}
		return current.key;
	}
	
// Driver Program to test above functions 
public static void main(String[] args) { 
    BinarySearchTree tree = new BinarySearchTree(); 
     /* Let us create following BST 
           50 
        /     \ 
       30      70 
      /  \    /  \ 
    20   40  60   80 */
    tree.insert(50); 
    tree.insert(30); 
    tree.insert(20); 
    tree.insert(40); 
    tree.insert(70); 
    tree.insert(60); 
    tree.insert(80); 

    // print inorder traversal of the BST
    System.out.print("Inorder traversal of BST :");
    tree.inorder();
    System.out.println();
    
    System.out.println("The minimum and maximum value in BST are:"+ minValue(root)+" and "+ maxValue(root));
    System.out.println();
    
    System.out.println("Deleting 20");
    deleteNode(root, 20);
    System.out.print("Inorder traversal of modified BST:");
    tree.inorder();
    
    System.out.println("\nDelete 30"); 
    deleteNode(root, 30); 
    System.out.println("Inorder traversal of the modified BST:"); 
    tree.inorder(); 

    System.out.println("\nDelete 50"); 
    deleteNode(root, 50); 
    System.out.println("Inorder traversal of the modified BST:"); 
    tree.inorder(); 
    
 } 
} 