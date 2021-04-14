package Array;

import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            long maxSumSubArray = kadane(arr);
            System.out.println(maxSumSubArray);
        }
        sc.close();
    }

    //this function has complexity of O(N)
    public static long kadane(int[] arr){
        long currentSum = 0, maxSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum += arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
// If all elements negative mod needed