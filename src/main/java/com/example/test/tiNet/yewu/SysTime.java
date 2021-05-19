package com.example.test.tiNet.yewu;

/**
 * @Author ShineQi
 * @Date 2021/4/2 14:34
 */
public class SysTime {
    public static void main(String[] args) {

        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        long FurtureTime = currentTime + 30000;
//        while(System.currentTimeMillis() <=FurtureTime){
//            System.out.println(System.currentTimeMillis());
//        }
       long currentTimeMinute =  System.currentTimeMillis() - (System.currentTimeMillis() % 60 *1000);
        System.out.println(currentTimeMinute);
    }
}
