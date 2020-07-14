package com.example.test.demoTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.entity.Student;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;


public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(20);
        student1.setName("xiaoming");
        student1.setSex("男");
        Student student2 = new Student();
        student2.setAge(10);
        student2.setName("honghong");
        student2.setSex("女");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        System.out.println(student1);
        System.out.println(studentList);
        //JSONArray jsonArray = JSONArray.parseArray(studentList.toString());
        //System.out.println(jsonArray);
        System.out.println(JSON.toJSONString(student1));
        System.out.println(JSON.toJSONString(studentList));
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(studentList));
        System.out.println(jsonArray);
        DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactory() {
            @Override
            public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
                return null;
            }

            @Override
            public void setAttribute(String name, Object value) throws IllegalArgumentException {

            }

            @Override
            public Object getAttribute(String name) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void setFeature(String name, boolean value) throws ParserConfigurationException {

            }

            @Override
            public boolean getFeature(String name) throws ParserConfigurationException {
                return false;
            }
        };




    }
    @Test
    public void test(){
        String str = "{\"age\":\"10\",\"name\":\"cool_summer_moon\"}";
        JSONObject  jsonObject = JSONObject.parseObject(str);
        System.out.println("json对象是：" + jsonObject);
        Object object = jsonObject.get("name");
        System.out.println("name值是："+object);
    }
}
