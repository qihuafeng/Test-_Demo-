package com.example.test.tinet.yewu;

import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;

/**
 * @Author ShineQi
 * @Date 2020/12/21 15:43
 */
public class DateTest {

//       [{"name":"00:00","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:5","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:10","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:15","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:20","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:25","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:30","value":0,"obCount":0,"answerCount":0},{"name":"00:35","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:40","value":0,"obCount":0,"answerCount":0},{"name":"00:45","value":0,"obCount":0,"answerCount":0},
//    {"name":"00:50","value":0,"obCount":0,"answerCount":0},{"name":"00:55","value":0,"obCount":0,"answerCount":0},
//    {"name":"01:00","value":0,"obCount":0,"answerCount":0},{"name":"01:5","value":0,"obCount":0,"answerCount":0},
//    {"name":"01:10","value":0,"obCount":0,"answerCount":0},{"name":"01:15","value":0,"obCount":0,"answerCount":0},
//    {"name":"01:20","value":0,"obCount":0,"answerCount":0},{"name":"01:25","value":0,"obCount":0,"answerCount":0},


    //        String s = "00:5";
//        String s1 = "01:10";
//        String s2 = "00:5";
//        int x = Integer.parseInt("00");  0
//        int y = Integer.parseInt("01");    1
    public static void main(String[] args) {
        // 5 10 15 30 60
        int interval = 15;
        // 5 30  1h 3h 6h
        int timeRange = 2000;
        JSONArray newJsonArray = new JSONArray();
        JSONArray json = JSONArray.parseArray("[{\"name\":\"00:00\",\"value\":0,\"obCount\":7,\"answerCount\":3},{\"name\":\"00:5\",\"value\":0,\"obCount\":3,\"answerCount\":1},{\"name\":\"00:10\",\"value\":0,\"obCount\":20,\"answerCount\":10},{\"name\":\"00:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"00:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"01:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"02:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"03:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"04:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"5:55\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:00\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:5\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:10\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:15\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:20\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:25\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:30\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:35\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:40\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:45\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:50\",\"value\":0,\"obCount\":0,\"answerCount\":0},{\"name\":\"6:55\",\"value\":0,\"obCount\":0,\"answerCount\":0}]");
        int jsonSize = json.size();

        String lastTime = json.getJSONObject(jsonSize - 1).getString("name");
        String[] split = lastTime.split(":");
        // 最后一个点时间的分钟形式
        int lastMiuTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

        //筛选时间的开始时间段
        int startTime = lastMiuTime - timeRange;


        for (int i = 0; i < json.size(); i++) {
            String name = json.getJSONObject(i).getString("name");
            String[] splits = name.split(":");
            int curPointTime = Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);

            // 若最后一个时间点可以整除当前周期,获取当前时间范围的点，否则获取开始时间更前一个点，以保证时间范围固定
            if (lastMiuTime % interval == 0) {
                //如果开始时间段在零点之后
                if (startTime >= 0) {
                    //当前的时间点能整除时间间隔并且在筛选时间范围内
                    if (curPointTime >= startTime && curPointTime % interval == 0 && curPointTime <= lastMiuTime) {
                        calAnswerRate(newJsonArray, json, i);
                    }
                } else {
                    if (curPointTime % interval == 0 && curPointTime <= lastMiuTime) {
                        calAnswerRate(newJsonArray, json, i);
                    }
                }
            } else {
                //如果开始时间段在零点之后
                if (startTime - interval >= 0) {
                    //当前的时间点能整除时间间隔并且在筛选时间范围内
                    if (curPointTime >= startTime - interval && curPointTime % interval == 0 && curPointTime <= lastMiuTime) {
                        calAnswerRate(newJsonArray, json, i);
                    }
                } else {
                    if (curPointTime % interval == 0 && curPointTime <= lastMiuTime) {
                        calAnswerRate(newJsonArray, json, i);
                    }

                }
            }

        }



        System.out.println(newJsonArray.size());
    }

    // 计算实时接听率
    private static void calAnswerRate(JSONArray newJsonArray, JSONArray json, int i) {

        //实时接听率
        float answerRate;
        String answerPercent;
        Integer answerCount = (Integer) json.getJSONObject(i).get("answerCount");
        Integer obCount = (Integer) json.getJSONObject(i).get("obCount");
        if (obCount != 0) {
            answerRate = new BigDecimal(((float) answerCount / obCount * 100)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            answerPercent =  answerRate +"%";
        }else{
            answerPercent = "0.00%";
        }
        json.getJSONObject(i).put("answerPercent",answerPercent);
        newJsonArray.add(json.get(i));
    }
}





















