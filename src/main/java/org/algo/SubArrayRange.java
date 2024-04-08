package org.algo;

import java.util.Arrays;

public class SubArrayRange {
    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,6};
        int B=1;
        int C=3;
        int[] result = new int[C-B+1];
        System.out.println("result length"+result.length);
        int resultIndex=0;
        for (int i = B; i <=C ; i++) {
            //System.out.println(array[i]);
            result[resultIndex]=array[i];
            resultIndex++;
        }
        System.out.println(Arrays.toString(result));
    }
}
