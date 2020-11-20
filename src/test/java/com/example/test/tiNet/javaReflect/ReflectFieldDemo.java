package com.example.test.tiNet.javaReflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Author ShineQi
 * @Date 2020/11/20 18:24
 */
public class ReflectFieldDemo {

    //public String name="李四";
    @Test
    public void test1() throws Exception{
        Class clazz = FieldPerson.class;
        FieldPerson p = (FieldPerson)clazz.newInstance();
        Field f = clazz.getField("name");
        String s = (String)f.get(p);
        System.out.println(s);

        //更改name的值
        f.set(p, "王六");
        System.out.println(p.name);
    }
    @Test//private int age = 18;
    public void test2() throws Exception{
        Class clazz = FieldPerson.class;
        FieldPerson p = (FieldPerson)clazz.newInstance();
        Field f = clazz.getDeclaredField("age");
        f.setAccessible(true);
        int age = (Integer)f.get(p);
        System.out.println(age);

        f.set(p, 28);
        age = (Integer)f.get(p);
        System.out.println(age);
    }
    @Test//public static Date time;
    public void test3() throws Exception{
        Class clazz = FieldPerson.class;
        Field f = clazz.getField("time");
        f.set(null, new Date());
        System.out.println(FieldPerson.time);
    }

}
