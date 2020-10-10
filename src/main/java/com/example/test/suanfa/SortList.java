package com.example.test.suanfa;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author ShineQi
 * @Date 2020/9/10 20:32
 */
public class SortList {
    public static  int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        int[] newnums = new int[m+n];
        /*for(int i = 0;i<newnums.length;i++){
            newnums[i++]=array1[i++];
        }*/
        int index = 0;
        for(int i :array1){
            newnums[index++] = i;
        }
        for(int j :array2){
            newnums[n++] = j;
        }
        Arrays.sort(newnums);
        return newnums;
    }

    public static void main(String[] args) {
        //[1, 2, 4, 5],4,[6],1
        int[] array1 = {1, 2, 4, 5};
        int[] array2 = {6};
        int[] newnums = new int[5];
         newnums = arrayMerge(array1,4,array2,1);
        for(int i:newnums){
            System.out.println(i);
        }



    }
}
