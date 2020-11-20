package com.example.test.tiNet.stringTest;

import ch.qos.logback.classic.db.SQLBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ShineQi
 * @Date 2020/11/18 15:55
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        List<Integer> ids   = new ArrayList<>();
        ids.add(3);
        ids.add(1);
        ids.add(4);
        ids.add(5);
        ids.add(2);
        ids.add(6);
        map.put("ids",ids);
        /*List<Integer> ids = (List<Integer>) param.getValue();
        if (ids.size() > 0) {
            sqlBuilder.append(AND  + " " + key.substring(0, key.length() - 1) + " in (");
            for (int i = 0; i < ids.size(); i++) {
                sqlBuilder.append(ids.get(i));
                if (i != ids.size() - 1) {
                    sqlBuilder.append(",");
                }
            }
            sqlBuilder.append(") ");
        }
        break;*/
        List<Integer> newIds  = (List<Integer>) map.get("ids");
        StringBuilder sqlBuilder = new StringBuilder("where ");
        if(newIds.size()>0){
            sqlBuilder.append("AND" + " " +"task_id" + " in (");
            for (int i = 0; i < ids.size(); i++) {
                sqlBuilder.append(ids.get(i));
                if (i != ids.size() - 1) {
                    sqlBuilder.append(",");
                }
            }
            sqlBuilder.append(") ");
        }
        System.out.println(sqlBuilder);

    }


}
