package com.example.test.executor.threadpoolexecutorTest;

/**
 * @Author ShineQi
 * @Date 2021/8/2 23:28
 */
public class TestExcutor extends Thread{


    @Override
    public void run(){
//        System.out.println("测试线程池："+Thread.currentThread().getName()+","+ThreadPool.threadPoolExecutor.toString());
        System.out.println("测试线程池："+Thread.currentThread().getName()+","+ThreadPool.exportTaskThreadPool.toString());

    }
}
