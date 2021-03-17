/* Program to check maximum number of Binary Tree possible. Both labeled and unlabeled.*
 * Unlabeled tree has nodes having no names.
 * Labeled tree has nodes having names.
 */
package BinaryTree;

import java.util.Scanner;

/**
 * @author msn2106
 */
public class NumberOfBinaryTrees {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of nodes:");
		try{
			int node = scanner.nextInt();
			int unlabeledTrees1 = catalan(node);
			//int unlabeledTrees2 = recursiveWay(node);
			int labeledTrees = catalanFill(node);
			
			System.out.println("Number of Unlabeled trees possible with "+node+" nodes:"+unlabeledTrees1);
			//System.out.println("Number of Unlabeled trees possible with "+node+" nodes:"+unlabeledTrees2);
			
			System.out.println("Number of Labeled trees possible with "+node+" nodes:"+labeledTrees);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		scanner.close();
	}

	//function to find number of labeled binary tree possible with given number of nodes.
	//Below function - catalan(node) gives number of unlabeled nodes, which can be filled in factorial(node) number of ways.
	private static int catalanFill(int node) {
			int res = catalan(node)*factorial(node);
			return res;
		}

/*	//recursive way of finding number of unlabeled binary tree.
	//Below function uses: Number of trees =>> i = 1, n= nodes => Summation of i to n of [T(i-1)*T(n-i)]
	private static int recursiveWay(int node) {
		int trees = 0;
		for(int i=1;i<=node;i++) {
			int catT = catalan(i-1);
			int catN = catalan(node-i);
			trees = trees+ (catN*catT);
		}
		return trees;
	}
*/
	//non-recursive way to find number of unlabeled binary tree.
	//Below function uses: n=>> nodes => Combination with 2*n raise to C with n as subscript / by (n+1)
	private static int catalan(int node) {
		int trees = combination(node)/(node+1);
		return trees;
	}
	private static int combination(int node) {
		int numerator = 1;
		if(node <= 0) return 0;
		for(int i = 2*node;i>node;i--) {
			numerator = numerator * i;
		}
		int result = numerator/factorial(node);
		return result;
	}
	private static int factorial(int n) {
		int prod = 1;
		for(int i=1;i<=n;i++) {
			prod = prod*i;
		}
		return prod;
	}

}
