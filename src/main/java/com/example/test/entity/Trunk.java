package com.tinet.vnc.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;


@Data
@Table(name = "trunk")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trunk  {


    private String trunk ; // 中继号码
    private String areaCode; // 目的码所在地区区号

    private String trunkGroupKey;
    private String trunkGroupName;

    private String enterpriseId ;

    private JSONObject tags ;
    public static  String getCode(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long s = System.currentTimeMillis() + 30000;
        Date date = new Date(s);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        Map<String,String> map = new HashMap<>();
        map.put("bindId","1");
        jsonArray.add(map);
        map.put("bindId","2");
        jsonArray.add(map);
        /*JSONObject jsonObject1 = new JSONObject();
        jsonObject.put("bindId","1");
        jsonArray.add(jsonObject);
        jsonObject1.put("bindId","2");
        jsonArray.add(jsonObject1);*/
        System.out.println(JSON.toJSONString(jsonArray));
       /* List<Trunk> list = new ArrayList<>();
        for(int i = 0;i<1;i++){
            Trunk trunk = new Trunk();
            trunk.setTrunk("19851628777");
            trunk.setAreaCode("010");
            trunk.setTrunkGroupKey("0121");
            trunk.setTrunkGroupName("中级组名");
            trunk.setEnterpriseId("7100001");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appKey","appkey123456");
            jsonObject.put("operatorChannelCode","hangzhou_channel");
            trunk.setTags(jsonObject);
            list.add(trunk);
        }
        System.out.println(JSON.toJSONString(list));*/

     /*   JSONObject jsonObject = new JSONObject();
        jsonObject.put("callNumA","19851628716");
        jsonObject.put("callNumB","18822081715");
        jsonObject.put("callNumX","18920133412");
        jsonObject.put("effectEndTime",getCode());
        jsonObject.put("bothWay","0");
        jsonObject.put("oneHide","0");
        System.out.println(JSON.toJSONString(jsonObject));*/

    }




}