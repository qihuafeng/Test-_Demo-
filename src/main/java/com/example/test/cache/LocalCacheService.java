package com.example.test.cache;

import com.example.test.entity.Account;
import com.example.test.entity.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ShineQi
 * @Date 2021/7/7 16:44
 */
@Service
@Slf4j
public class LocalCacheService {

    public static Map<String, Account> accountMap = new ConcurrentHashMap<>();


    public Account getAccount(Integer appid){
        try{
            String key = String.format(Const.REDIS_KEY_ACCOUNT_APPID,appid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
