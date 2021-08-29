package com.example.test.jdk.reflect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author ShineQi
 * @Date 2021/8/20 17:12
 */
@Slf4j
@Data
public class TeacherService implements PersonBaseService,BaseInterface {


    private String name;
    private String age;

    @Override
    public String eat() {
        return "teacher eat ...";
    }

    @Override
    public String sleep() {
        return "teacher sleep ...";
    }

    public String teachStudent(){
        log.info("TeacherService.teachStudent start");
        return "I,m TeacherService";
    }
}
