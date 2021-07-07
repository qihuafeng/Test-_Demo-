package com.example.test.tinet.javaReflect;

import java.util.Date;

/**
 * @Author ShineQi
 * @Date 2020/11/20 18:14
 */
public class MethodPerson {
    
    

        public MethodPerson(){
            System.out.println("默认的无参构造方法执行了");
        }

        public MethodPerson(String name){
            System.out.println("姓名:"+name);
        }

        public MethodPerson(String name,int age){
            System.out.println(name+"="+age);
        }

        private MethodPerson(int age){
            System.out.println("年龄:"+age);
        }

        public void m1() {
            System.out.println("m1");
        }

        public void m2(String name) {
            System.out.println(name);
        }

        public String m3(String name,int age) {
            System.out.println(name+":"+age);
            return "aaa";
        }

        private void m4(Date d) {
            System.out.println(d);
        }

        public static void m5() {
            System.out.println("m5");
        }

        public static void m6(String[] strs) {
            System.out.println(strs.length);
        }

        public static void main(String[] args) {
            System.out.println("main");
        }

    }





