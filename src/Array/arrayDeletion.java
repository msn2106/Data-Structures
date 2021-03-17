/* This is a program to delete element of specified index from a static array. */
package Array;
import java.util.Scanner;
public class arrayDeletion 
{
	public static int[] arrayDelete(int[] arr, int size, int index)
	{
		for(int i=index;i<arr.length-1;i++)
		{
			arr[i]= arr[i+1];
		}
		//arr[arr.length-1]=0;
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
		System.out.print("Enter the index of the number you want to delete:");
		int index = sc.nextInt();
		arrayDelete(arr,size,index);
		size--;
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]+" ");
		}
		sc.close();
	}

}
