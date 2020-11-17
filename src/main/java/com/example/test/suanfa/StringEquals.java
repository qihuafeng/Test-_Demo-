package com.example.test.suanfa;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author ShineQi
 * @Date 2020/9/18 13:03
 */
public class StringEquals {
    public static void main(String[] args) {
        /*String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str4 = new String("test");
        System.out.println(str1 == str2);// true  指向同一个
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
        String s = "123";
        String b = "321";
        int a = Integer.valueOf(s);
        int c = Integer.parseInt(b);
        int i = 100;
        String  good = String.valueOf(i);
        System.out.println(good);

        System.out.println(a);
        System.out.println(c);*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","我是value");
        System.out.println(jsonObject.getString("key"));
        Map<String,String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("hello1","你好1");
        map.put("hello2","你好2");
        System.out.println(map);
        String s = "abcdecg";
        System.out.println(s.substring(0, 2));
        int agent = 1;
        for(int i = 0;i<20; i++){
            agent += agent;
        }
        System.out.println(agent);
        TimeUnit unit;
        BlockingQueue workQueue;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(, , , unit, workQueue);


    }
}
