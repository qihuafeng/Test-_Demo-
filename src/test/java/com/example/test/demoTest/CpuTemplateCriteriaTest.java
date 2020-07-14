package com.example.test.demoTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.test.entity.CpuTemplateCriteria;

import java.util.HashMap;
import java.util.Map;

public class CpuTemplateCriteriaTest {
    public static void main(String[] args) {
        CpuTemplateCriteria cpuTemplateCriteria = new CpuTemplateCriteria();
        Map<String,Object> map = new HashMap<>();
         map.put("ids","[456,457]");
        cpuTemplateCriteria.setExtFields(map);
        JSONArray s = JSONArray.parseArray(cpuTemplateCriteria.getExtFields().get("ids").toString());
        System.out.println(s);
//        Long bidids = new Long(JSONArray.size());


    }
}
