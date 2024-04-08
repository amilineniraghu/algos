package org.algo;

public class MinMaxSubArray {
    public static void main(String[] args) {
//        int[] A = new int[]{1,6,4,6,5,1,5,2,6,4,4,2,1,5};
        int[] A = new int[]{1,3,2};
        int minIndex = -1;
        int maxIndex = -1;
        int n = A.length;
        int minValue = getMinValue(A);
        System.out.println("Min"+minValue);
        int maxValue = getMaxValue(A);
        System.out.println("Max:"+maxValue);
        int result = Integer.MAX_VALUE;
        for (int i = n-1; i >=0; i--) {
            if(A[i] == minValue){
                minIndex = i;
            }
            if(A[i] == maxValue){
                maxIndex = i;
            }

            if(minIndex!=-1 && maxIndex !=-1){
                int len = Math.abs((maxIndex-minIndex))+1;
                result = Math.min(result,len);
            }
        }
        System.out.println(result);
//        return result;

    }

    private static int getMinValue(int[] a) {
        int number = a[0];
        for (int i = 0; i < a.length; i++) {
            number = Math.min(number, a[i]);
        }
        return number;
    }

    private static int getMaxValue(int[] a) {
        int number = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > number){
                number = a[i];
            }
        }
        return number;
    }


}
