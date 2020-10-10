package com.example.test.demoTest;

/**
 * @Author ShineQi
 * @Date 2020/8/18 7:33
 */
public class Singleton {
    private Singleton(){};
    private static  Singleton instance;
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance  = new Singleton();
        System.out.println(instance);
        //Singleton instance = new Singleton();
        System.out.println(instance);
    }
}
