package com.example.test.tinet.javaReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author ShineQi
 * @Date 2020/11/20 14:10
 */
public class ReflectConstructorDemo {
    // https://blog.csdn.net/ju_362204801/article/details/90578678
//      思考：在讲反射之前，先思考一个问题，java中如何创建一个对象，有哪几种方式?
//       Java中创建对象大概有这几种方式：
//            1、使用new关键字：这是我们最常见的也是最简单的创建对象的方式
//            2、使用Clone的方法：无论何时我们调用一个对象的clone方法，JVM就会创建一个新的对象，将前面的对象的内容全部拷贝进去
//            3、使用反序列化：当我们序列化和反序列化一个对象，JVM会给我们创建一个单独的对象
//       上边是Java中常见的创建对象的三种方式，其实除了上边的三种还有另外一种方式，就是接下来我们要讨论的 “反射”

    /*反射就是把Java类中的各个部分，映射成一个个的Java对象，拿到这些对象后可以做一些事情。
    既然说反射是反射Java类中的各个组成部分，所以说咱们得知道一个类中有哪儿些部分？
    例如，一个类有：成员变量，方法，构造方法，等信息，利用反射技术咱们可以把这些组成部分映射成一个个对象。 反射是框架设计的灵魂*/

//    我们知道一个类里一般有构造函数、方法、成员变量(字段/属性)这三部分组成
//    翻阅API文档，可以看到
//    Class对象提供了如下常用方法：

    //反射无参的构造函数
    @Test
    public  void test() throws Exception{
        Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象
        Constructor constructor = clazz.getConstructor(null);//得到Person类的构造方法,可以创建对象
        constructor.newInstance(null);  //sout  默认的无参构造方法执行了

    }
//    从上边的例子看出，要想反射，首先第一步就是得到类的字节码
//    所以简单说一下得到类的字节码的几种方式
//            (1)、Class.forName("com.cj.test.Person"); 这就是上边我们用的方式
//            (2)、对象.getClass();
//            (3)、类名.class;
//    2.1反射构造方法  没有参数的构造函数

    //2.1.1反射无参的构造函数    public Person()
    public void test1() throws Exception{
        Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象

        ConstructorPerson p  = new ConstructorPerson();
        Class<? extends ConstructorPerson> aClass = p.getClass();//对象.getClass()

        Class<ConstructorPerson> personClass = ConstructorPerson.class;//类名.class
    }
    // 2.1.2反射“一个参数”的构造函数  public Person(String name)
    @Test
    public  void test2() throws Exception{
        Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象
        Constructor constructor = clazz.getConstructor(String.class);//得到Person类的构造方法,可以创建对象
        constructor.newInstance("张三");  //sout  姓名:张三
    }

    //2.1.3反射“多个参数”的构造函数  public Person(String name,int age)
    @Test
    public  void test3() throws Exception{
        Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象
        Constructor constructor = clazz.getConstructor(String.class,int.class);//得到Person类的构造方法,可以创建对象
        constructor.newInstance("张三",18);  //sout  张三  =18
    }

//    注意：在反射私有的构造函数时，用普通的clazz.getConstructor（）会报错，因为它是私有的，所以提供了专门反射私有构造函数的方法
//    clazz.getDeclaredConstructor(int.class);//读取私有的构造函数，用这个方法读取完还需要设置一下暴力反射才可以
//    c.setAccessible(true);//暴力反射

    //2.1.4反射“私有”的构造函数  private Person(int age)
    @Test
    public  void test4() throws Exception{
        //得到字节码文件
        Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象
        Constructor constructor = clazz.getDeclaredConstructor(int.class);//读取私有的构造函数
        constructor.setAccessible(true);  //暴力反射
        constructor.newInstance(28);  //年龄:28
    }

//    2.1.5反射得到类中所有的构造函数
        @Test
        public  void test5() throws Exception{
            //得到字节码文件
            Class clazz  = Class.forName("com.example.test.tinet.javaReflect.ConstructorPerson");//代表person类在内存中的字节码对象
            Constructor[] constructors = clazz.getDeclaredConstructors();//可以获取全部的，还有获取公有的方法
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
        }






}
