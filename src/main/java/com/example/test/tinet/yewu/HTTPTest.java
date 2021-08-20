package com.example.test.tinet.yewu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ShineQi
 * @Date 2021/8/11 10:05
 */
public class HTTPTest {

    private static CloseableHttpClient httpclient = null;

    private static  long accessTokenExpir;
    private static String accessToken;


    public static String doGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)// 请求超时时间
                    .setSocketTimeout(60000)// 数据读取超时时间
                    .build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String getAccessToken(String appKey,String secretKey){

        try{
            long currentTimeMillis = System.currentTimeMillis();
            if(currentTimeMillis < accessTokenExpir){
                System.out.println("获取token");
                return accessToken;
            }

            String url = "";

            url =   "http://223.255.252.183:30001/oauth/ue/auth/authenticate" + "?appkey=" +appKey + "&secret=" + secretKey;

            String result = doGet(url);
            if(StringUtils.isNotEmpty(result)){
                JSONObject jsonObject = JSON.parseObject(result);
                String tokenResult = jsonObject.getString("result");
                if(StringUtils.isNotEmpty(tokenResult)){
                    System.out.println("重新获取token");
                    accessToken = JSON.parseObject(tokenResult).getString("access_token");
                    Long expireIn = JSON.parseObject(tokenResult).getLong("expire_in");
                    accessTokenExpir = System.currentTimeMillis() + 10 * 1000;
                }
            }
        }catch (Exception e){
        }
        return accessToken;
    }


    public static void main(String[] args) throws InterruptedException {

     /*   System.out.println(accessTokenExpir);

        System.out.println(System.currentTimeMillis() < accessTokenExpir);*/
        String appkey = "8f958878225b43dd2d3e6f22f02a5e58";
        String sercetKey = "68e47545f219c7bcee6772df142521c5";

        // 请求失败的话重试30秒
        long retryTime = System.currentTimeMillis() + 30000;
        String url = "http://223.255.252.183:30001/oauth/ue/auth/authenticate?appkey=8f958878225b43dd2d3e6f22f02a5e58&secret=68e47545f219c7bcee6772df142521c5";

        String accessToken11 = getAccessToken(appkey, sercetKey);
        System.out.println(accessToken11);
        /*Thread.sleep(11000);
        System.out.println(getAccessToken(appkey, sercetKey));
        Thread.sleep(9000);
        System.out.println(getAccessToken(appkey, sercetKey));
*/
        System.out.println(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        long s = System.currentTimeMillis() + 30000;
        Date date = new Date(s);
        String format = simpleDateFormat.format(date);
        System.out.println(format);


//        System.out.println(transferCallDisplay(null));
        System.out.println(transferCallDisplay(""));
        System.out.println(transferCallDisplay("1,1"));
    }

    public static String transferCallDisplay(String callDisplay){
        switch (callDisplay) {
            case "0,0":
                return "0";
            case "0,1":
                return "1";
            case "1,0":
                return "2";
            case "1,1":
                return "3";
            default:
                return "0";
        }
    }

}
