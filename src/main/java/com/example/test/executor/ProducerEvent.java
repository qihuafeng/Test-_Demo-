package com.example.test.executor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author ShineQi
 * @Date 2021/7/6 18:47
 */
@Slf4j
@Component
public class ProducerEvent {

    public static void productData(){
        for(int i = 0 ;i < 50; i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","阿彬" + i +"号");
            boolean flag = RequestLogThreadExecutor.pushEvent(jsonObject);
            log.info("推送生产者数据到队列Thread:{},成功:{}",jsonObject.toJSONString(),flag);
        }

        for(int i = 0;i< 50 ;i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("姓名","小明"+i +"号");
            RequestLogRunableExecutor.pushEvent(jsonObject);
            log.info("推送生产者数据到队列Runnable:{}",jsonObject.toJSONString());
        }
    }
}
