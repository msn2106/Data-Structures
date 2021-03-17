/* This is a program to insert an element in static array at given position (not index) */
package Array;
import java.util.Scanner;
public class arrayInsertion 
{
	public static int[] arrayInsert(int[] arr,int num,int pos)
	{
		int size = arr.length;
		for(int i = size-1 ;i>=pos;i--)
		{
			arr[i] = arr[i-1];			
		}
		arr[pos-1]=num;
		return arr;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array:");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements of array:");
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter the number you want to insert:");
		int num = sc.nextInt();
		System.out.print("Enter the position you want to insert the number:");
		int pos = sc.nextInt();
		arrayInsert(arr,num,pos);
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
