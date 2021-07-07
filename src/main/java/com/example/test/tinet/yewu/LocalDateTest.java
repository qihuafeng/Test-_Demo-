package com.example.test.tinet.yewu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author ShineQi
 * @Date 2021/3/30 17:19
 */
public class LocalDateTest {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("requestUrl","1111");
//        jsonObject.put("requestUrl","3333");
        String s = JSON.toJSONString(jsonObject);
        System.out.println(jsonObject.toString());


    }
}
