package com.example.test.leetcode.suanfa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ShineQi
 * @Date 2020/9/3 23:07
 */
public class Main {
   /* public static  int[] toArray(String s){
        String[] strings = s.split(",");
        int[] res =new  int[strings.length];
        int i = 0;
        for(String ss:strings){
            res[i++] = Integer.parseInt(ss);
        }
        return res;
    }*/
    public static String repeatNum(String s) {
        String[] strings = s.split(",");
        int[] nums =new  int[strings.length];
        int j = 0;
        for(String ss:strings){
            nums[j++] = Integer.parseInt(ss);
        }
        Arrays.sort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                arrayList.add(nums[i]);
            }
        }
        int[] res = new int[arrayList.size()];
        int index = 0;
        for(int num:arrayList){
            res[index++] = num;
        }
        String s1 =String.valueOf(res);
        return  s1.toString();


    }

    public static void main(String[] args) {
        String s = "4,3,2,7,8,2,3,1";
        String sss = repeatNum(s);
        System.out.println(sss);
    }
    }

