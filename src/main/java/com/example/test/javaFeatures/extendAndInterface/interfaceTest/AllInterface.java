package com.example.test.javaFeatures.extendAndInterface.interfaceTest;

import com.example.test.javaFeatures.extendAndInterface.interfaceTest.EatInterface;
import com.example.test.javaFeatures.extendAndInterface.interfaceTest.SayInterface;

/**
 * @Author ShineQi
 * @Date 2020/7/22 11:09
 */
public interface AllInterface extends EatInterface, SayInterface {
    void readBook();
    void playBall();
    void swim();

}
