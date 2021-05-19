package com.example.test.tiNet.yewu;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author ShineQi
 * @Date 2021/2/20 16:52
 */
public class SignTest {

    public static String getUnicomSign(Map<String, Object> params, String secret) {
        String result = null;
        if (params == null) {
            return result;
        }

        Map<String, Object> treeMap = new TreeMap<String, Object>();
        treeMap.putAll(params);

        Iterator<String> iter = treeMap.keySet().iterator();
        StringBuffer orgin = new StringBuffer();
        while (iter.hasNext()) {
            String name = iter.next();
            Object o = params.get(name);
            if (o == null) {
                continue;
            }
            String value = String.valueOf(o);
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            orgin.append(name).append("=").append(value).append("&");
        }
        orgin.append("corp_secret=").append(secret);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
//            logger.debug("加密字符串:" + orgin.toString());
            System.out.println(orgin.toString());
            result = V3_AXB_Byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
            if (StringUtils.isNotEmpty(result)) {
                result = result.toLowerCase();
            }
        } catch (Exception e) {
            throw new java.lang.RuntimeException("sign error");
        }
        return result;
    }
    public static String V3_AXB_Byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int i = 0; i < b.length; i++) {
            stmp = Integer.toHexString(b[i] & 0XFF);
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        System.out.println(hs.toString().toUpperCase());
        return hs.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String corp_key = "5030451906476738";
        int ts = 1615800432;
        int page = 1;
        int size = 10;
        String start_time = "2021-02-19 00:00:00";
        String end_time = "2021-02-19 14:13:36";
        map.put("corp_key",corp_key);
        map.put("ts",ts);
        map.put("page",page);
        map.put("size",size);
        map.put("start_time",start_time);
        map.put("end_time",end_time);
        String secert = "WVb54XN624hP9E9H4y9K9S8PH5788seN";
        String s = getUnicomSign(map,secert);

    }
}
