/** This is a program to implement - Level order traversal in Binary Tree
 * 
 */
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author msn2106
 */
public class LevelOrderTraversal {

	Node root;
	
	//function to print in level order traversal
	public static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        Node temp = null;
        while(!q.isEmpty()){
            temp = q.poll();
            arr.add(temp.data);
            
            //enqueue left child
            if(temp.left != null){
                q.add(temp.left);
            }
            
            //enqueue right child
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return arr;
    }
	
	//main function
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(4);
		tree.root.left = new Node(8);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(16);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(24);
		
		System.out.print("Inorder traversal of the BT:");
		inOrderTreeTraversalWithoutRecursion.inorder(tree.root);
		System.out.println();
		System.out.print("Level order traversal of BT:");
		System.out.print(levelOrder(tree.root)+" ");

	}

}
