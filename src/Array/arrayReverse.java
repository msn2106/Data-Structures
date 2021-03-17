/* Program to reverse the array. */
package Array;

import java.util.Scanner;

public class arrayReverse {
	
	//function to swap elements
	public static void reverse(int[] arr) {
		int size = arr.length;
		int low = 0 ;
		int high = size-1;
		while(low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++ ;
			high-- ;
		}
	}

	//main function
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements of array:");
		for(int i = 0 ; i< size ; i++) arr[i] = scanner.nextInt();
		reverse(arr);
		System.out.println("Reversed array is:");
		for( int i : arr) System.out.println(i);
		scanner.close();
	}
}
