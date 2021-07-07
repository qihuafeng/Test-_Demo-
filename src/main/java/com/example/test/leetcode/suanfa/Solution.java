package com.example.test.leetcode.suanfa;

/**
 * @Author ShineQi
 * @Date 2020/9/10 20:27
 */



public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * calculate combination Number
     * @param r int整型
     * @param n int整型
     * @return int整型
     */
    public static int combination (int r, int n) {
        // write code here
        int sum = 1;
        int chushu = 1;
        for(int i=n;i>n-r;i--){
            sum *=i;
        }
        for(int j=1;j<=r;j++){
            chushu *=j;
        }
        return (int)sum/chushu;
    }

    public static void main(String[] args) {
        int r = combination(2,5);
        System.out.println(r);
    }
}