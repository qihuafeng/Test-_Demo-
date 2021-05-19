package com.example.test.tiNet.yewu;

import java.util.concurrent.*;

/**
 * @Author ShineQi
 * @Date 2020/12/22 19:55
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        TimeUnit unit;
//        BlockingQueue workQueue;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //使用这个比较多   核心线程为0   等待的为Integer.MAX
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);


    }
}
