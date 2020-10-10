package com.example.test.suanfa;

/**
 * @Author ShineQi
 * @Date 2020/9/16 11:25
 */
public class Example {
    public String[] replace(String[] nums){
        for(String num:nums){
            int i = Integer.valueOf(num);
            if(i%7==0){
                num = "*";
            }
        }
        return nums;
    }


}
