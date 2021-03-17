/** This is a program to implement - relation between number of nodes and height of binary tree
 * 1. Height of binary tree ranges from => base2log(nodes+1) to nodes-1
 * 2. No. of nodes in binary tree ranges from => height+1 to (2 raise to (height+1)) - 1
 */
package BinaryTree;

import java.util.Scanner;

/**
 * @author msn2106
 */
public class NodesAndHeight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select from the operation below:\n1.Node operation\n2.Height operation");
		int ch = scanner.nextInt();
		switch (ch) {
		case 1: int node = scanner.nextInt();
				System.out.println("Minimum Height of the binary tree possible with:"+node+" node :" + minHeight(node));
				System.out.println("Maximum Height of the binary tree possible with:"+node+" node :" + maxHeight(node));
				break;
		case 2: int height = scanner.nextInt();
				System.out.println("Minimum Nodes present with "+height+" height of tree:" + minNodes(height));
				System.out.println("Maximum Nodes present with "+height+" height of tree:" + maxNodes(height));
				break;
		default: System.out.println("Incorrect choice");
				break;
		}
		scanner.close();
	}
	
	//function to find maximum nodes that could be present in the binary tree, given the height of the tree
	private static int maxNodes(int height) {
		int nodes = (int) (Math.pow(2, height+1) - 1);
		return nodes;
	}
	
	//function to find minimum nodes that could be present in the binary tree, given the height of the tree
	private static int minNodes(int height) {
		return height+1;
	}

	//function to find maximum height of the binary tree, given number of nodes
	private static int maxHeight(int node) {
		return node-1;
	}

	//function to find minimum height of the binary tree, given number of nodes
	//problem here log base 2 needed, here base e is present
	private static int minHeight(int node) {
		double height = (Math.log(node+1)/Math.log(2))-1; //conversion to base 2
		return (int) Math.ceil(height);	
	}

}
