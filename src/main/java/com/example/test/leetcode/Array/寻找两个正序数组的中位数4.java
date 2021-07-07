package com.example.test.leetcode.Array;

import java.util.Arrays;

/**
 * @Author ShineQi
 * @Date 2020/11/25 10:12
 */
public class 寻找两个正序数组的中位数4 {

    /**
     * 重点难点 复制第二个数组记得 length1+j   返回值为float
     * @param nums1
     * @param nums2
     * @return
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int[] newArray = new int[totalLength];
        for (int i = 0; i < length1; i++) {
            newArray[i] = nums1[i];
        }
        for (int j = 0; j < length2; j++) {
            newArray[length1+j] = nums2[j];
        }
        Arrays.sort(newArray);
        if (totalLength == 1) {
            return newArray[0];
        } else {
            if ((totalLength) % 2 == 0) {
                int x = totalLength / 2;
                float result = (float)(newArray[x] + newArray[x-1]) / 2;
                return result;
            } else {
                int x = totalLength / 2;
                return newArray[x];
            }

        }

    }
    public static int[] test(int[] a,int[] b){
        int length1 = a.length;
        int length2 = b.length;
        int total = length1+length2;
        int[] array = new int[total];
        for(int i = 0;i< length1;i++){
            array[i]  = a[i];
        }
        for(int j = 0;j <length2;j++){
            array[length1 + j] = b[j];
        }
        for(int num:array){
            System.out.println(num);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b ={3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }

}
