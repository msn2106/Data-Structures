/* Program to create multi-dimension array (3 dimensions here)*/
//it is not possible to have user defined number of array.
package Array;
import java.util.Scanner;
public class arrayMultiD {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("X dimension:");
		int xsize = sc.nextInt();
		System.out.print("Y dimension:");
		int ysize = sc.nextInt();
		System.out.print("Z dimension:");
		int zsize = sc.nextInt();
		
		int[][][] a = new int[xsize][ysize][zsize];
		System.out.println("Enter the elements of array:");			//taking input
		for(int i=0;i<xsize;i++) 
		{
			for(int j=0;j<ysize;j++)
			{
				for(int k=0;k<zsize;k++)
				{
					a[i][j][k] = sc.nextInt();
				}
			}
		}
		for(int i=0;i<xsize;i++) 									//printing
		{
			for(int j=0;j<ysize;j++)
			{
				for(int k=0;k<zsize;k++)
				{
					System.out.print(a[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}
