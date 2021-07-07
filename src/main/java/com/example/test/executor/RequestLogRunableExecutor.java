package com.example.test.executor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author ShineQi
 * @Date 2021/7/7 11:15
 */
@Slf4j
public class RequestLogRunableExecutor implements  Runnable{

    public static boolean shutdown  = false;

    public static LinkedBlockingQueue<JSONObject> linkedBlockingQueue = new LinkedBlockingQueue<>();

    public static void  pushEvent(JSONObject jsonObject){
        linkedBlockingQueue.offer(jsonObject);
    }


    @Override
    public void run() {
        while (!shutdown){
            try{
                JSONObject take = linkedBlockingQueue.take();
                if(take == null){
                    Thread.sleep(200);
                }
                log.info("数据入库:{}",take.toJSONString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
