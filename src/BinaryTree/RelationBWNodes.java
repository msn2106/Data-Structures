/** This is a program to show the relation between different nodes.
 * In binary tree there are three types of nodes : 
 * 1.Nodes with 2 childs N(2)
 * 2.Nodes with 1 child N(1)
 * 3.Nodes with 0 child N(0) = leaf nodes
 * Relation is :- no. of N(2) = no. of N(0) -1
 */
package BinaryTree;

import java.util.Scanner;

/**
 * @author msn2106
 */
public class RelationBWNodes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select from below choices\n1.Given no. of Leaf Node:\n2.Given no. of nodes with cardinality 2:");
		int ch = scanner.nextInt();
		switch (ch) {
		case 1: int n0 = scanner.nextInt();
				System.out.println("Number of nodes with cardinality 2:"+ (n0 -1));
				break;
		case 2: int n2 = scanner.nextInt();
				System.out.println("Numner of leaf nodes:"+ (n2+1));
				break;
		default:System.out.println("Invalid choice");
			break;
		}
		scanner.close();
	}

}
