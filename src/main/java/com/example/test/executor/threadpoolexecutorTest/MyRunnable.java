package com.example.test.executor.threadpoolexecutorTest;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ShineQi
 * @Date 2021/7/8 9:39
 */
@Slf4j
public class MyRunnable implements Runnable {

    private String name;

//    public MyRunnable(String name) {
//        this.name = name;
//    }

    @Override
    public void run() {

        log.info(Thread.currentThread().getName() + "Start.Time = " + new Date());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(Thread.currentThread().getName() + "End.Time = " + new Date());

    }

    private static final int CORE_POOL_SIZE = 5;

    private static final int MAX_POOL_SIZE = 10;

    private static final int QUEUE_CPACITY = 100;

    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {

            ////创建WorkerThread对象（WorkerThread类实现了Runnable 接⼝）
            MyRunnable myRunnable = new MyRunnable();

            //执⾏Runnable
            threadPoolExecutor.execute(myRunnable);
        }

        //终止线程池
        threadPoolExecutor.shutdown();

        while (threadPoolExecutor.isTerminated()) {
            log.info("Finished all Threads");
        }

    }
}
