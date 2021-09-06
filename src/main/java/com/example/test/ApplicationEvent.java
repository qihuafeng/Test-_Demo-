/*
package com.example.test;

import com.example.test.executor.ProducerEvent;
import com.example.test.executor.RequestLogRunableExecutor;
import com.example.test.executor.RequestLogThreadExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

*/
/**
 * @Author ShineQi
 * @Date 2021/7/6 18:10
 *//*

@Slf4j
@Component
public class ApplicationEvent implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {

        ProducerEvent.productData();

        // extends Thread
        for(int i = 0; i < 10 ; i++){
            RequestLogThreadExecutor requestLogThreadExecutor = new RequestLogThreadExecutor();
            requestLogThreadExecutor.setName("RequestLogExecutor_"+i);
            requestLogThreadExecutor.start();
            log.info("ApplicationEvent————" + requestLogThreadExecutor.getName() + "处于就绪状态");
        }
        // implements runAble
        for(int i = 0;i<10;i++){
            RequestLogRunableExecutor requestLogRunableExecutor = new RequestLogRunableExecutor();
            Thread t = new Thread(requestLogRunableExecutor,"requestLogRunableExecutor-"+i);
            t.start();
            log.info("ApplicationEvent————" + t.getName() + "处于就绪状态");
        }

    }
}
*/
