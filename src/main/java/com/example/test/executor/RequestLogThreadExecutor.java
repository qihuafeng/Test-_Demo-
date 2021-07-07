package com.example.test.executor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author ShineQi
 * @Date 2021/7/6 18:19
 */
@Slf4j
public class RequestLogThreadExecutor extends Thread {


    private static volatile boolean shutdown = false;

    public static LinkedBlockingQueue<JSONObject> linkedBlockingQueue = new LinkedBlockingQueue<>();


    public static boolean pushEvent(JSONObject jsonObject){
        boolean offer = linkedBlockingQueue.offer(jsonObject);
        return offer;
    }

    @Override
    public void run() {
        log.info(this.getName() + "线程开始执行");
        while (!shutdown) {
            try {
                JSONObject take = linkedBlockingQueue.take();
                if(take == null){
                    Thread.sleep(1000);
                    log.info(this.getName() + "线程睡眠1秒");
                }

                log.info(this.getName() + "消费数据数据入库:" + take.toJSONString());

            } catch (Exception e) {
                log.error(this.getName() + "thread run error");
            } finally {
                log.info(this.getName() + "线程执行完毕");
            }
        }

    }

}
