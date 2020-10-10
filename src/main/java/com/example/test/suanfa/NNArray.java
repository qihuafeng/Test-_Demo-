package com.example.test.suanfa;

import java.util.Arrays;

/**
 * @Author ShineQi
 * @Date 2020/9/26 19:55
 */
public class NNArray {
    public int kthSmallest (int[][] matrix, int m) {
        // write code here
       int[] arrray;
       int length = 0;
       for(int[] element:matrix){
           length+=element.length;
       }
       int index = 0;
       arrray = new int[length];
       for(int[] element:matrix){
           for(int element2:element){
               arrray[index++] = element2;
           }
       }
        Arrays.sort(arrray);
       int result = arrray[m-1];
       return result;
    }

    public static void main(String[] args) {
        int[] max = {1,2,4,5,6,8};
        System.out.println(max[1]);
    }
}
