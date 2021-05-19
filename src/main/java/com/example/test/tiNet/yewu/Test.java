package com.example.test.tiNet.yewu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.tiNet.listSortDemo.Student;

import java.util.*;

/**
 * @Author ShineQi
 * @Date 2020/12/10 15:35
 */
public class Test {
    public static void main(String[] args) {

        /*String bindClidByAgentArea = "1";
        String areaCodeRule = "1";
        String isMatchCapital = "1";
        String matchAreaCode = "123,101,201";
        String[] matchAreaCodes = matchAreaCode.trim().split(",");

        TreeMap<String,Object> map = new TreeMap<>();
        List<Object> list = new ArrayList<>();
        list.add(bindClidByAgentArea);
        list.add(areaCodeRule);
        list.add(isMatchCapital);
        list.add(matchAreaCode);
        String s1 = JSON.toJSONString(list);
        System.out.println(s1);
        map.put("bindClidByAgentArea",bindClidByAgentArea);
        map.put("areaCodeRule",areaCodeRule);
        map.put("isMatchCapital",isMatchCapital);
        map.put("matchAreaCodes",matchAreaCodes);
        System.out.println(map.toString()+"map数据");
        String s = JSON.toJSONString(map);
        System.out.println(s);
        JSONObject jsonObject = JSONArray.parseObject(s);
        System.out.println(jsonObject.get("bindClidByAgentArea"));
        System.out.println(jsonObject.get("matchAreaCodes"));*/
//        Map<String,Object> map = new HashMap<>();
//        map.put("key1","12345");
//        map.put("key2","12345");
//        map.put("key3","12345");
//        System.out.println(map.toString());

//        private String requestId;
//        private String telA;
//        private String telX;
//        private String telB;
//        private String subId;
//        private String callType;
//        private String callTime;
//        private String ringingTime;
//        private String startTime;
//        private String releaseTime;
//        private String callId;
//        private String releaseDir;
//        private String releaseCause;
//        private String callRecording;
//        private Integer duration;
//        private String recordUrl;
//        private String remark;
//        List<DXT> dxtArrayList = new ArrayList<>();
//        DXT dxt1 = new DXT();
//        dxt1.setRequestId("1");
//        dxt1.setTelA("11");
//        dxt1.setTelX("11");
//        dxt1.setTelB("11");
//        dxt1.setSubId("11");
//        dxt1.setCallType("11");
//        dxt1.setCallTime("11");
//        dxt1.setRingingTime("11");
//        dxt1.setStartTime("11");
//        dxt1.setReleaseTime("11");
//        dxt1.setCallId("11");
//        dxt1.setReleaseDir("11");
//        dxt1.setReleaseCause("11");
//        dxt1.setCallRecording("11");
//        dxt1.setDuration(1);
//        dxt1.setRecordUrl("1");
//        dxt1.setRemark("111");
//
//        dxtArrayList.add(dxt1);
//        System.out.println(JSON.toJSONString(dxtArrayList));
//        String A = "+8619851628716";
//        System.out.println(A.substring(3,A.length()));
//        System.out.println(A.length());
        String telA =  "010123456";

        if( "400".equals(telA.substring(0,3))){
            telA = "86" + telA ;
        }else if(telA.charAt(0)=='0'){
            telA = "86" + telA.substring(1,telA.length());
        }
        System.out.println(telA);



    }
}
