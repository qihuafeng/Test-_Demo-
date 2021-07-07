package com.example.test.tinet.stringTest;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @Author ShineQi
 * @Date 2020/12/9 18:42
 */
public class JsonAppend {

//    String obClidProperty = "{"+"bindClidByAgentArea:"+Integer.valueOf(bindClidByAgentArea)+","+"areaCodeRule:"+Integer.valueOf(areaCodeRule)+","+
//            "isMatchCapital:"+Integer.valueOf(isMatchCapital)+","+ "matchAreaCode:" + areaCodes;
public static void main(String[] args) {
    String bindClidByAgentArea = "1";
    String areaCodeRule = "1";
    String isMatchCapital = "1";
    String matchAreaCode = "123,101,201";

    String[]  areaCodes = matchAreaCode.split(",");
    StringBuilder stringBuilder = new StringBuilder("");

    String obClidProperty = "{"+"bindClidByAgentArea:"+Integer.valueOf(bindClidByAgentArea)+","+"areaCodeRule:"+Integer.valueOf(areaCodeRule)+","+
            "isMatchCapital:"+Integer.valueOf(isMatchCapital)+","+ "matchAreaCode:" + "["+matchAreaCode+ "]" +"}";
    System.out.println(obClidProperty);
    HashMap<String,Object> map = new HashMap<>();
    map.put("bindClidByAgentArea",Integer.valueOf(bindClidByAgentArea));
    map.put("areaCodeRule",Integer.valueOf(areaCodeRule));
    map.put("isMatchCapital",Integer.valueOf(isMatchCapital));
    map.put("matchAreaCode",areaCodes);
    String json= JSON.toJSONString(map);
    System.out.println(json);
}
}
