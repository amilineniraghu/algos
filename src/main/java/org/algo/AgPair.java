package org.algo;


public class AgPair {
    public static void main(String[] args) {
        agPair("ABCGAG");
    }

    private static void agPair(String A) {
        int numOfSubSeq=0;
        int g=0;
        int ans=0;
        char[] array = A.toCharArray();
        int n=array.length;
        for(int i=n-1;i>=0;i--){
            if(array[i] == 'A'){
                ans = ans + g;
            }
            if(array[i] =='G'){
                g++;
            }

        }
        
        System.out.println(ans);
    }
}
