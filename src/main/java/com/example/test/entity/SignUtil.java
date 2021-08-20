package com.example.test.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Slf4j
public class SignUtil {

    /**
     * 参数签名验证
     */



    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("appKey","0qJNcxSX");
        map.put("relationNum","16517206774");
        map.put("calleeNum","18822081715");
        map.put("callerNum","19851628716");
        String serectKey = "8f8853d7b2d6beeea435ab8c9a35023a6ddd9559";
//        getSignature(map,serectKey);
    }
}
