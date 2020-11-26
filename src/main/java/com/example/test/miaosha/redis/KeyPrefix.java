package com.example.test.miaosha.redis;

/**
 * @Author ShineQi
 * @Date 2020/11/26 20:38
 */
public interface KeyPrefix {
    public int expireSeconds();
    public String getPrefix();


}
