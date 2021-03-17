/*Binary Tree implementation*/
package tree;

import java.util.LinkedList;
import java.util.Queue;

//tree is created using nodes, similar to linked list
class Node{
	Integer data;
	Node left, right;
	
	Node(int x){
		data = x;
		left = right = null;
	}
}

//main class having features of binary tree
public class binaryTree{
	static Node root;		//static reference of Node class
	
	binaryTree(int x){		//parameterized constructor
		root = new Node(x);
	}
	
	binaryTree(){			//non-parameterized constructor
		root = null;
	}
	
	//function for inorder traversal
	public static void inorder(Node root) {
		if(root == null) return;
		else {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);			
		}
	}
	
	//function for postorder traversal
	public static void postorder(Node root) {
		if(root == null) return;
		else {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");			
		}
	}
	
	//function for preorder traversal
	public static void preorder(Node root) {
		if(root == null) return;
		else {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//function to insert data in level order way
	public static void insert(int x, Node temp) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		//System.out.println(queue.peek());
		//Do level order traversal until we find an empty space
		while(!queue.isEmpty()) {
			//System.out.println(queue.peek());
			temp = queue.peek();
			queue.remove();
			
			if(temp.left == null) {
				temp.left = new Node(x);
				break;
			}else queue.add(temp.left); 
			
			if(temp.right == null) {
				temp.right = new Node(x);
				break;
			}else queue.add(temp.right);
		}
	}
	
	//function to delete a given node in the binary tree
	public static  Node delete(Node root,int val) {
			if(root == null) return null;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			Node lastParent = null,lastNode = null, replaceNode = null;
			while(!queue.isEmpty()) {
				int size = queue.size();
				while(size-- > 0) {
						Node currentNode = queue.remove();
						if(currentNode.data == val) replaceNode = currentNode;
						if(currentNode.left != null) {
							lastParent = currentNode;
							lastNode = currentNode.left;
							queue.add(currentNode.left);
						}
						if(currentNode.right != null) {
							lastParent = currentNode;
							lastNode = currentNode.right;
							queue.add(currentNode.right);
						}
				}
			}
			replaceNode.data = lastNode.data;
			if(lastParent.left == lastNode) lastParent.left = null;
			else lastParent.right = null;
			
			return root;
	}
	
	//function to find the last node of a binary tree - incorrect
	public static Integer lastNode(Node root) {
		Integer lastNodeData = 0;
		if(root == null) return null;
		lastNode(root.right);
		lastNode(root.left);
		//lastNode(root);
		lastNodeData = root.data;		
		return lastNodeData;
	}
	
	//function to delete the binary tree - postorder way
	public static Node deleteBinaryTree(Node node) {
		if(node == null) return null;
		node.left = deleteBinaryTree(node.left);
		node.right = deleteBinaryTree(node.right);
		
		System.out.println("Deleting node "+ node.data);
		node = null;
		return node;
	}
	
	//main function
	public static void main(String[] args) {
			
		binaryTree tree = new binaryTree();
		binaryTree.root = new Node(1);
		tree.root.left = new Node(2);			//as root is static member,
		//it should be used either directly or by className.root (recommended)
		tree.root.right = new Node(3);
		binaryTree.root.left.left = new Node(12);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		root.right.right = new Node(40);
		tree.root.left.right.left = new Node(14); 
		
		System.out.print("Tree in Inorder:");
		inorder(root);
		System.out.println();
		
		int key = 12; 
	    delete(root, key);
		
		System.out.print("Tree in PostOrder:");
		binaryTree.postorder(root);
		System.out.println();
		
		System.out.print("Tree in PreOrder:");
		binaryTree.preorder(root);
		System.out.println();
		
		System.out.println();
		System.out.println("Deleting whole tree");
		deleteBinaryTree(root);
		System.out.println();
		
		System.out.println("Preorder traversal after adding new nodes:");
		insert(21, root); insert(99, root);
		insert(88, root); insert(55, root);
		insert(111, root); insert(100, root);
		insert(101, root); 
		insert(56, root);
		//insert(200, root);
		preorder(root);
		System.out.println();
		
		int val = 1;
		System.out.println();
		System.out.println("Preorder after deleting "+val);
		delete(root, 1);
		preorder(root);
		
//		System.out.println();
//		System.out.println("Last Node inserted in tree is:"+lastNode(root));
//		System.out.println();
		
		System.out.println();
		
		System.out.println(System.currentTimeMillis());
	}	
}

/*
 * // function to delete the given deepest node (d_node) in binary tree 
	static void deleteDeepest(Node root,Node d_node) 
	{ 
	    Queue<Node> q = null; 
	    q.add(root); 
	  
	    // Do level order traversal until last node 
	    Node temp; 
	    while (!q.isEmpty()) { 
	        temp = q.peek(); 
	        q.remove(); 
	        if (temp == d_node) { 
	            temp = null; 
	            //delete(d_node); 
	            return; 
	        } 
	        if (temp.right != null) { 
	            if (temp.right == d_node) { 
	                temp.right = null; 
	                //delete(d_node); 
	                return; 
	            } 
	            else
	                q.add(temp.right); 
	        } 
	  
	        if (temp.left != null) { 
	            if (temp.left == d_node) { 
	                temp.left = null; 
	                //delete(d_node); 
	                return; 
	            } 
	            else
	                q.add(temp.left); 
	        } 
	    } 
	} 
	  
	/* function to delete element in binary tree 
	static Node deletion(Node root, int key) 
	{ 
	    if (root == null) 
	        return null; 
	  
	    if (root.left == null && root.right == null) { 
	        if (root.data == key) 
	            return null; 
	        else
	            return root; 
	    } 
	  
	    Queue<Node> q = new Queue<Node>(Node root) {
	    	//q.add(root);
		}; 
	     
	  
	    Node temp = null; 
	    Node key_node = null; 
	  
	    // Do level order traversal to find deepest 
	    // node(temp) and node to be deleted (key_node) 
	    while (!q.isEmpty()) { 
	        temp = q.peek(); 
	        q.remove(); 
	  
	        if (temp.data == key) 
	            key_node = temp; 
	  
	        if (temp.left != null) 
	            q.add(temp.left); 
	  
	        if (temp.right != null) 
	            q.add(temp.right); 
	    } 
	  
	    if (key_node != null) { 
	        int x = temp.data; 
	        deleteDeepest(root, temp); 
	        key_node.data = x; 
	    } 
	    return root; 
	} 
 * */
