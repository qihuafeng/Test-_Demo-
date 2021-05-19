package com.example.test.tiNet.yewu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author ShineQi
 * @Date 2021/2/22 14:07
 */
public class SearchData {

    /** 根据查询参数生成签名
     * genj
     * @param params
     * @param secret
     * @return
     */
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

    /**
     * 循环查询
     * @param args
     */
    /*public static  String searchData(){
        int page = 100;
        int size;
        for(int i = 0;i<page;i++){

        }
    }*/

    /**
     * codeBy ycy
     * 发送post请求
     * @param url  路径
     * @param jsonObject  参数(json类型)
     * @param encoding 编码格式
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, String jsonObject, String encoding) throws ParseException, IOException {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        StringEntity s = new StringEntity(jsonObject, "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        //设置参数到请求对象中
        httpPost.setEntity(s);
        System.out.println("请求地址："+url);
//        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
//        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity =  response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;

    }



    public static void main(String[] args) throws IOException, ParseException {

        FileWriter fw = new FileWriter("D:\\callText1.txt");
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        String corp_key = "5030451906476738";
        int ts = 1615800432;
        int page;
        int size = 100;
        String start_time = "2021-02-19 00:00:00";
        String end_time = "2021-02-19 14:13:16";

        String secert = "WVb54XN624hP9E9H4y9K9S8PH5788seN";
        String result;
        String finalResult = "";
        for (int i = 1; i <= 65; i++) {
            //生成签名sign
            page = i;
            map.put("page", page);
            map.put("corp_key", corp_key);
            map.put("ts", ts);

            map.put("size", size);
            map.put("start_time", start_time);
            map.put("end_time", end_time);
            String sign = getUnicomSign(map, secert);

            // 循环请求接口
            params.put("corp_key", corp_key);
            params.put("ts", ts);
            params.put("size", size);
            params.put("page", page);
            params.put("start_time", start_time);
            params.put("end_time", end_time);
            params.put("sign", sign);
            String requestParam = JSON.toJSONString(params);
            result = send("http://124.160.63.235:81/ykt-ucrm-provider/json/1/cdrFetch", requestParam, "utf-8");
            fw.write(result);
            fw.flush();

//            finalResult += result;
        }
            fw.close();


//        System.out.println(finalResult);

    }
}
