package com.example.test.executor.threadpoolexecutorTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ShineQi
 * @Date 2021/8/2 23:11
 */
public class ThreadPool {
    // 先放入 核心，再放入 workQueue ,在创建最大
    public static int CORE_POOL_SIZE = 3;
    public static int MAX_POOL_SIZE = 5;  //有一个被拒绝

    public static int MAX_POOL_SIZE_SIX = 6;

    BlockingQueue workQueue;
    public static ThreadPoolExecutor  threadPoolExecutor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE_SIX,
            5L,
            TimeUnit.MICROSECONDS,
            new LinkedBlockingQueue<Runnable>(3));


    public static ThreadPoolExecutor exportTaskThreadPool = new ThreadPoolExecutor(3, 5,
            5L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(4),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    if (!executor.isShutdown()) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            });
    public static void main(String[] args) {
      /*  for(int i = 0;i<10;i++){
            threadPoolExecutor.execute(()->{
                System.out.println("测试线程池："+Thread.currentThread().getName()+","+threadPoolExecutor.toString());
            });
        }*/
        //  提交10个任务 给线程池

        for(int i = 0;i<10;i++){
//            threadPoolExecutor.execute(new TestExcutor());
            exportTaskThreadPool.execute(new TestExcutor());
        }
        JSONObject data = new JSONObject();
        JSONObject jsonObject = new JSONObject();;
        jsonObject.put("code",1);
        jsonObject.put("message","请求成功");
        jsonObject.put("data",data);
        System.out.println(JSON.toJSONString(jsonObject));
    }
}
