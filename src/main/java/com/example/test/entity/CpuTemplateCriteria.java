package com.example.test.entity;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class CpuTemplateCriteria {

    /*private LinkedHashMap<String, String> sortItemMap;
    private Map<String, Object> extFields;

    public LinkedHashMap<String, String> getSortItemMap() {
        return sortItemMap;
    }

    public void setSortItemMap(LinkedHashMap<String, String> sortItemMap) {
        this.sortItemMap = sortItemMap;
    }

    public Map<String, Object> getExtFields() {
        return extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }*/
    public static boolean isAllowTime(String allowTime) {
        boolean flag = false;
        if (StringUtils.isNotEmpty(allowTime)) {
            Calendar now = Calendar.getInstance();
            String[] timeRange = allowTime.split("-");
            String startTime = timeRange[0];
            String[] startTimeSplit = startTime.split(":");
            int startTimeMinute = Integer.parseInt(startTimeSplit[0]) * 60 + Integer.parseInt(startTimeSplit[1]);
            String endTime = timeRange[1];
            String[] endTimeSplit = endTime.split(":");
            int endTimeMinute = Integer.parseInt(endTimeSplit[0]) * 60 + Integer.parseInt(endTimeSplit[1]);
            int currentTimeMinute = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE);
            if (currentTimeMinute >= startTimeMinute && currentTimeMinute <= endTimeMinute) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
       /* System.out.println(isAllowTime("13:00-16:00"));
        Calendar now = Calendar.getInstance();
        LocalDateTime now = LocalDateTime.now();
        //当前的分钟数对配置的时间进行取余,每三分钟扫描一次
        if (now.getMinute() % 3 == 0) {


        System.out.println(now.get((Calendar.HOUR_OF_DAY)));
        System.out.println(now.get(Calendar.MINUTE));

        String serviceFailKey = String.format("system.now.request.channel.serviceFail.count.%s", "东盟");
        System.out.println(serviceFailKey);

        String serviceFailKey1 = String.format("system.now.request.channel.%s.serviceFail.%s.count", "5600001","东盟");
        System.out.println(serviceFailKey1);*/
        /*String url = "www.baidu.com;www.tianyan.com;top.qhf.com";
        String[] urls = url.split(";");
        String newUrl = "";
        for(int i =1;i<urls.length;i++){
            String domain = urls[i];
            System.out.println(domain + "  " + i);
            int urlLength = url.length();
            int firstUrlLength = urls[0].length();
            newUrl = url.substring(firstUrlLength+1,urlLength)+";"+url.substring(0,firstUrlLength);
            System.out.println(newUrl);
        }

        BigDecimal totalDecimal = new BigDecimal("100");
        BigDecimal failDecimal = new BigDecimal("99");
        double failRate = new BigDecimal("1").subtract(failDecimal.divide(totalDecimal, 5, BigDecimal.ROUND_HALF_UP)).doubleValue();
        System.out.println(failRate);
*/
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.getSecond());
        System.out.println(0 % 30);
        System.out.println(30 % 30);
        System.out.println(31 % 30);

    }
}
