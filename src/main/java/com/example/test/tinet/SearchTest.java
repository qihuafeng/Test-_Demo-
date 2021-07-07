package com.example.test.tinet;

import java.util.Date;

/**
 * @Author ShineQi
 * @Date 2020/11/12 11:10
 */
public class SearchTest {
    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap();
//        // 放进的字符串   {"key":"callId,applyNo","name":"user_field","value":"1,1"}
//        hashMap.put("user_field","{\"key\":\"callId,applyNo\",\"name\":\"user_field\",\"value\":\"1,1\"}");
//
//        /*//{"name":"user_field","value":"1,1"}
//        hashMap.put("kkk","{\"name\":\"user_field\",\"value\":\"1,1\"}");*/
//        //  1  json字符串转化为对象
//        SearchCondition condition = JSON.parseObject(String.valueOf(hashMap.get("user_field")), SearchCondition.class);
//
//        SearchCondition searchCondition = new SearchCondition();
//        JSONObject jsonObject = JSON.parseObject(String.valueOf(hashMap.get("user_field")));
//        System.out.println("=================json string to javaBean=================");
//        System.out.println(condition);
//        System.out.println("=================json string to jsonObject=================");
//        System.out.println(jsonObject);
//
//        // 2 对象转化为json字符串
//        String s = JSON.toJSONString(condition);
//        System.out.println("=================javaBean  to json string=================");
//        System.out.println(s);
        System.out.println(new Date());
        Date date = new Date();
        System.out.println(date.getTime());

        System.out.println(System.currentTimeMillis());

    }

}
