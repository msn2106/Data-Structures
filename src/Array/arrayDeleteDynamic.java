/* This is a program to delete element of specified index from a dynamic array. */
package Array;
import java.util.Scanner;
public class arrayDeleteDynamic 
{
	public static int[] deleteDynamicArray(int[] arr, int index)
	{
		int len = arr.length;
		int[] temp = new int[len-1];
		for(int i=index;i<len-1;i++) temp[i]= arr[i+1];
		for(int i=0;i<index;i++) temp[i]=arr[i];
		return temp;
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
		int[] temp = deleteDynamicArray(arr, index);
		for(int i=0;i<temp.length;i++)
		{
			System.out.println(temp[i]+" ");
		}
		sc.close();
	}

}
