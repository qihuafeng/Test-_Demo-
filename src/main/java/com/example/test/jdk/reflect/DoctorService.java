package com.example.test.jdk.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author ShineQi
 * @Date 2021/8/20 17:21
 */
@Slf4j
public class DoctorService implements PersonBaseService{


    @Override
    public String eat() {
        return "DoctorService eat ...";
    }

    @Override
    public String sleep() {
        return "DoctorService sleep ...";
    }

    public String helpPerson(){
        log.info("DoctorService.helpPerson");
        return "DoctorService helpPerson";
    }
}
