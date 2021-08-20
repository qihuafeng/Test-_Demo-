package com.example.test.entity;

import java.time.LocalDate;

/**
 * @Author ShineQi
 * @Date 2021/7/7 16:56
 */
public class Const {

    private static final String REDIS_KEY_PREFIX = "vnc.baseData.";

    /**
     * 账户信息
     * vnc.account.appId.${appId}
     */
    public static final String REDIS_KEY_ACCOUNT_APPID = REDIS_KEY_PREFIX + "account.appId.%s";


    public static void main(String[] args) {
        LocalDate yesterday = LocalDate.now().minusDays(25);
        System.out.println(yesterday);
        System.out.println(System.currentTimeMillis());
    }
}
