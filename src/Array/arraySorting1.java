/* This is a program to implement Bubble sorting on array */
package Array;
import java.util.Arrays;
import java.util.Scanner;

public class arraySorting1 
{
	public static int[] sortAsc(int[] arr)
	{
		Arrays.sort(arr);
		return arr;
	}
	public static int[] sortDesc(int[] arr)
	{
		//write this definition
		return arr;
	}
	public static void printArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements of the array:");
		for(int i=0;i<size;i++ ) arr[i] = sc.nextInt();
		System.out.println("Initial Array:");
		printArray(arr);
		System.out.println();
		System.out.println("Enter sorting order A for ascending and D for descending:");
		char ch = sc.next().charAt(0);
		System.out.println("Sorted Array:");
		switch(ch)
		{
			case 'A' : sortAsc(arr);
					printArray(arr);
					break;
			case 'D' : sortDesc(arr);
					printArray(arr);
					break;
			default : System.out.println("Enter a valid choice i.e; either A or D :");
		}		
		sc.close();
	}

}
