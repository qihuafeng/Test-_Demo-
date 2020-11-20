package com.example.test.tiNet.javaReflect;

import java.util.Date;

/**
 * @Author ShineQi
 * @Date 2020/11/20 14:41
 */
public class ConstructorPerson {



        public ConstructorPerson(){
            System.out.println("默认的无参构造方法执行了");
        }

        public ConstructorPerson(String name){
            System.out.println("姓名:"+name);
        }

        public ConstructorPerson(String name, int age){
            System.out.println(name+"="+age);
        }

        private ConstructorPerson(int age){
            System.out.println("年龄:"+age);
        }



    }





