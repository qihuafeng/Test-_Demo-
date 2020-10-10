package com.example.test.suanfa;

import java.util.Scanner;

/**
 * @Author ShineQi
 * @Date 2020/9/19 19:51
 */
public class Char {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] c = s.toCharArray();
        Sort(c);
        s = String.valueOf(c);
        System.out.println(s);
    }
    public  static  void Sort(char[] c){
        char t = 0;
        for(int i = 0;i<c.length-1;i++){
            for(int j = 0;j<c.length-1-i;j++){
                if(c[j]>c[j+1]){
                    t = c[j+1];
                    c[j+1] = c[j];
                    c[j] = t;
                }
            }
        }
    }

}
