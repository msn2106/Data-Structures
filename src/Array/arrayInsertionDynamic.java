/* This is a program to insert an element into a dynamic array at a given position (not index). */
package Array;
import java.util.Scanner;
public class arrayInsertionDynamic 
{
	public static int[] arrayInsertDynamic(int[] arr, int num,int pos)
	{
		int size = arr.length;
		int[] temp = new int[size+1];
		for(int i = size ;i>=pos;i--)
		{
			temp[i] = arr[i-1];			
		}
		temp[pos-1]=num;
		for(int i=0;i<pos-1;i++)
		{
			temp[i]=arr[i];
		}
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
		System.out.print("Enter the number you want to insert:");
		int num = sc.nextInt();
		System.out.print("Enter the position you want to insert the number:");
		int pos = sc.nextInt();
		int[] temp = arrayInsertDynamic(arr,num,pos);
		for(int i=0;i<=size;i++)
		{
			System.out.print(temp[i]+" ");
		}
		sc.close();

	}

}
