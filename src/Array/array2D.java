/* Program to create 2D array */
package Array;
import java.util.Scanner;
public class array2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows:");
		int rows = sc.nextInt();
		System.out.print("Enter number of columns:");
		int col = sc.nextInt();
		int[][] a = new int[rows][col];
		System.out.println("Enter elements of array:");
		for(int i=0;i<rows;i++)									//taking input
		{
			for(int j=0;j<col;j++) {
				System.out.print("Enter element of ["+i+"]th row and ["+j+"]th index:");
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("The elements of entered array are:");
		for(int i=0;i<rows;i++)									//printing
		{
			for(int j=0;j<col;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
