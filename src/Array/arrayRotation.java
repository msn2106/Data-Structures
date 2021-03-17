/* 1) This is a program to rotate the array of size "size" by "pos" positions in "ch" direction - using temporary array. 
 * 	Time Complexity = O(n) and Space Complexity = O(d)
 */
package Array;

import java.util.Scanner;

public class arrayRotation 
{
	//function for leftRotation
	public static int[] leftRotate(int[] arr, int size , int pos)
	{
		int[] temp = new int [pos];
		for(int i = 0;i<pos;i++)		//preparing temp array
		{
			temp[i] = arr[i];
		}
		for(int i=0;i<size-pos;i++)		//shifting things in main array
		{
			arr[i]=arr[i+pos];
		}
		for(int i=size-pos,j=0;j<pos&i<size;i++,j++)		//making array all right
		{
			arr[i]= temp[j];
		}
		return arr;
		
	}
	//function for rightRotation
	public static int[] rightRotate(int[] arr, int size, int pos)
	{
		int[] temp = new int [pos];
		for(int i=size-pos,j=0;j<pos&i<size;i++,j++)		//preparing temp array
		{
			temp[j] = arr[i];
		}
		for(int i=size-1;i>=pos;i--)		//shifting things in main array
		{
			arr[i]=arr[i-pos];
		}
		for(int i=0;i<pos;i++)		//making array all right
		{
			arr[i]= temp[i];
		}
		return arr;		
	}
	//Main Program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements of array:");
		for(int i=0;i<size;i++)
		{
			arr[i]= sc.nextInt();
		}
		System.out.println("Enter the direction and position to rotate:");
		char ch = sc.next().charAt(0);
		int pos = sc.nextInt();
		
		switch(ch)
		{
		case 'L': leftRotate(arr,size,pos);
		break;
		case 'R': rightRotate(arr,size,pos);
		break;
		default: System.out.print("Enter a valid choice(L/R)");
		}
		System.out.println("Array after rotating "+ch+" by "+pos+" times is:");
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}

}
