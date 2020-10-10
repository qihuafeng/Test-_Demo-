package com.example.test.suanfa;

/**
 * @Author ShineQi
 * @Date 2020/9/18 13:03
 */
public class StringEquals {
    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str4 = new String("test");
        System.out.println(str1 == str2);// true  指向同一个
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
    }
}
