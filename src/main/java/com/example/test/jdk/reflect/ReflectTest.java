package com.example.test.jdk.reflect;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.ansi.AnsiOutput;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author ShineQi
 * @Date 2021/8/20 17:25
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 两种方式获取类 1.类的全限定名  2 对象.getClass
        Class<?> aClass = Class.forName("com.example.test.jdk.reflect.TeacherService");
        TeacherService teacherService = new TeacherService();
        Class<?> aClass1 = teacherService.getClass();

        // 获取全部属性名
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class<?> type = declaredField.getType();
            String name = declaredField.getName();
            System.out.println("aClass.getDeclaredFields() type:" + type +" name:" +name);

        }
        String filedName = declaredFields[0].getName();
        System.out.println("declaredFields[0].getName():" + filedName);

//        System.out.println("ReflectTest.declaredFields" + JSON.toJSONString(declaredFields));

        System.out.println("=======================================================");

        //获取类对象的方法
        Method[] declaredMethods1 = aClass.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println("aClass.getDeclaredMethods() " + method.getName());
        }

        // 获取类实现的接口的方法
        Class<?>[] interfaces = aClass.getInterfaces();
        for(Class<?> anInterface:interfaces){
            Method[] declaredMethods = anInterface.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                String declaredMethodName = declaredMethod.getName();
                System.out.println("declaredMethod.getName() " + declaredMethodName);
//                declaredMethod.invoke();
            }


            System.out.println("aClass.getInterfaces()" + anInterface.getSimpleName() + "   anInterface.getDeclaredMethods()" );
        }


//        System.out.println(interfaces);
        //获取属性名
        Field name1 = aClass.getDeclaredField("name");
        System.out.println("获取特定属性名:" + name1);

        String name = aClass.getName();
        System.out.println("获取类名:" +name);
    }
}
