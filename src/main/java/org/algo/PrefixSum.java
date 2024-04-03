package org.algo;

public class PrefixSum {

    //Given an array arr[] of size N, find the prefix sum of the array.
    // A prefix sum array is another array prefixSum[] of the same size,
    // such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] . . . arr[i].
    // https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
    //Time Complexity: O(N)
    //Auxiliary Space: O(N)
    public static void main(String[] args) {
        int[] sourceArray = new int[] {1,2,3,4,5,6};
        int n = sourceArray.length;
        int[] prefixArray = new int[n];
        System.out.println("before prefix sum");
        printArray(sourceArray);
        prefixArray[0] = sourceArray[0];
        prefixSumArray(sourceArray,prefixArray,n);
        System.out.println("after prefix sum");
        printArray(prefixArray);
    }

    private static void prefixSumArray(int[] sourceArray, int[] prefixArray, int n){
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i-1] + sourceArray[i];
        }
    }

    private static void printArray(int[] outArray){
        for (int i = 0; i < outArray.length; i++) {
            System.out.print(outArray[i]+" ");
        }
        System.out.println("\n");
    }
}
