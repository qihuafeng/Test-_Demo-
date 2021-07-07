package com.example.test.leetcode.suanfa;

import java.util.Scanner;

/**
 * @Author ShineQi
 * @Date 2020/9/19 19:34
 */
public class ZifuNUM {
    public static  void yunSuan(String s){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int i = 0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                a+=1;
            }else if(Character.isSpaceChar(s.charAt(i))){
                b+=1;
            }else if(Character.isDigit(s.charAt(i))){
                c+=1;
            }else{
                d+=1;
            }
        }
        System.out.println("英文字母："+a);
        System.out.println("空格："+b);
        System.out.println("数字："+c);
        System.out.println("其他字符："+d);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入为");
        String s = in.nextLine();

        yunSuan(s);
    }
}
