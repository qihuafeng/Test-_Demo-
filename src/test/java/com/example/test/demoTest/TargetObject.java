package com.example.test.demoTest;

public class TargetObject {
    private  String value;

    public TargetObject(){
        value = "戚华锋";
    }
    public  void publicMethod(String s){
        System.out.println("I am"+s);
    }
    private void privateMethod(){
        System.out.println("value is"+value);
    }
}
