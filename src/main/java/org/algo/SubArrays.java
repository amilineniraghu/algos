package org.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubArrays {
    /**
     * Problem Description
     * You are given an array A of N integers.@param args
     * Return a 2D array consisting of all the subarrays of the array
     */
    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 1, 4};
        List<int[]> subarrays = new ArrayList<>();
        for (int s = 0; s < A.length; s++) {
            for (int e = s; e < A.length; e++) {
                int subarraySize = (e - s) + 1;
                int[] subarray = new int[subarraySize];
                int index = 0;
                for (int k = s; k <= e; k++) {
                    subarray[index] = A[k];
                    index++;
                }
                subarrays.add(subarray);
            }
        }
        int[][] result = new int[subarrays.size()][];
        for (int i = 0; i < subarrays.size(); i++) {
            result[i] = subarrays.get(i);
        }
//        return result;
        System.out.println(Arrays.deepToString(result));
    }

    

    
    
}
