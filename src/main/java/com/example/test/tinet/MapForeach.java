package com.example.test.tinet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapForeach {
    public static void main(String[] args) {
        /*
         * 1.调用map集合的方法keyset，所有的键存储到set集合中
         * 2.遍历set集合，获取出set集合中的所有元素（map中的键）
         * 3.调用map集合方法get，通过键获取到值
         */
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("a", 11);
        map.put("b", 12);
        map.put("c", 13);
        map.put("d", 14);
        map.put("e", 15);

        //调用map集合的方法keyset，所有的键存储到set集合中
        Set<String>set=map.keySet();
        System.out.println(map);
        //遍历set集合，获取出set集合中的所有元素（map中的键）
        //迭代器遍历
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            //it.next返回的是set集合元素，也就是map中的键
            //遍历set集合，获取出set集合中的所有元素（map中的键）
            String key=it.next();
            Integer value=map.get(key);
            System.out.println(key+"...."+value);
        }
        System.out.println("======================");
        //增强for遍历
        for(String key:set){
            Integer value=map.get(key);
            System.out.println(key+"...."+value);
        }
    }
}