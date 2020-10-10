package com.example.test.suanfa;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @Author ShineQi
 * @Date 2020/9/4 14:00
 */
public class Sum {
    public static int maxLength(int[] nums, int S) {
        /*和为S的最长连续子序列

        给定数组A[N] 和整数S，寻找i、j(i 小于等于 j)满足S = A[i] + A[i+1] + … + A[j]，
        输出满足条件的最大的长度max(j - i)，若找不到，输出0，你的算法复杂度是多少？*/

        int maxNums = 0;
        int sum = 0;
        int index = 0;


            for (int j = 0; j < nums.length; j++) {
                for(int i = j+1;i<nums.length-1;i++){
                    sum += nums[j];
                    index++;
                    if (S == sum) {
                        if (index >= maxNums) {
                            maxNums = index;
                        }
                    }
                }
                if (maxNums != 0) {
                    return maxNums;
                }
                }
        return 0;
    }

    public static void main(String[] args) {
        int[] example = {9,5,3,1,7,9};
        int s = 9;
        int value = maxLength(example,s);
        System.out.println(value);
    }
}

