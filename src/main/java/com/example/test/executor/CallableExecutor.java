package com.example.test.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Author ShineQi
 * @Date 2021/7/7 12:59
 */
@Slf4j
public class CallableExecutor implements Callable<Integer> {

    private Integer result = 0;
    private String taskName = "";

    public CallableExecutor(Integer iniResult, String taskName){
        result = iniResult;
        this.taskName = taskName;
        log.info("生成子线程计算任务: "+taskName);
    }
    public String getTaskName(){
        return this.taskName;
    }


    //  可以实现 Callable<Integer> 和Callable<String> 不实现返回结果是Object
    @Override
    public Integer call() throws Exception {

        for(int i = 0;i<100;i++){
            result = result + i;
        }

        // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成
        Thread.sleep(5000);
        log.info("子线程计算任务:"+ taskName +"执行完成,执行结果"+result);

        return result;
    }


}
