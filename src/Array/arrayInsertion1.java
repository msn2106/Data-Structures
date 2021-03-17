/* This is a program to insert an element in static unsorted array at given position (not index) */
package Array;
import java.util.Scanner;
public class arrayInsertion1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array:");
		int size = sc.nextInt();
		int[] arr = new int[20];
		System.out.println("Enter the elements of array:");
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter the number you want to insert:");
		int num = sc.nextInt();
		System.out.print("Enter the position you want to insert the number:");
		int pos = sc.nextInt();
		arr[size]=arr[pos-1];
		arr[pos-1]=num;
		size++;
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
// As we just want our number at the specified index without bothering about array - Time Complexity -O(2)