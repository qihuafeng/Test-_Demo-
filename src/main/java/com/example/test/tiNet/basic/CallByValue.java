package com.example.test.tiNet.basic;

import com.example.test.tiNet.listSortDemo.Test;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

/**
 * @Author ShineQi
 * @Date 2020/11/25 14:59
 */
public class CallByValue {

    public  void test(List<Integer> list){
        if(list.contains(15)){
          list.remove((Object)15);
          list.remove((Object)15);
        }
        for(int i = 0;i<list.size();i++){
            if(list.get(i) == 12){
                list.remove(i);
            }
        }
    }

    public static void  test1(Integer i){
        i = i+1;
        System.out.println(i);
    }





    public static void main(String[] args) {

        // String Integer 都是用 final修饰的

        List<Integer> list = new ArrayList<>();
        list.add(1998);
        list.add(07);
        list.add(07);
        list.add(15);
        list.add(15);
        list.add(12);
        list.add(12);
        list.add(12);

        CallByValue call = new CallByValue();
        call.test(list);
        for(Integer i:list){
            System.out.println(i);
        }

        Integer ls = new Integer(2);
        test1(ls);
        System.out.println(ls);
    }
}
