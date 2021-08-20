package com.example.test.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

/**
 * @Author: zhoujiang
 * @Date: 2021/5/13 下午2:10
 */
@Service
public class RedisService {

    private Logger logger = LoggerFactory.getLogger(RedisService.class);

    private static final String LOCK_LUA_SCRIPT = "return redis.call('SET', KEYS[1], ARGV[1], 'NX', 'PX', ARGV[2]) ";
    private static final String UNLOCK_LUA_SCRIPT = "if (redis.call('GET', KEYS[1]) == ARGV[1]) then "
            + "return redis.call('DEL',KEYS[1]) " + "else " + "return 0 " + "end";
    public static final String LOCK_LUA_SCRIPT_RESULT_OK = "OK";
    private static final long DEFAULT_LOCK_TIME_OUT = 3000; // 单位毫秒
    private static final long DEFAULT_TRY_LOCK_TIME_OUT = 0;// 单位毫秒
    private static String LOCK_LUA_SCRIPT_SHA;
    private static String UNLOCK_LUA_SCRIPT_SHA;

    private static final String GET_AND_DEL_SCRIPT = "local val = redis.call('get', KEYS[1]);\n" +
            "if (val) then\n" +
            "   redis.call('del', KEYS[1]);\n" +
            "end\n" +
            "return val;";
    private static String GET_AND_DEL_LUA_SCRIPT_SHA;

    /**
     * 根据库号 封装redis的连接池
     */
    private static Map<Integer, JedisPool> redisPoolMap = new ConcurrentHashMap<>(2);

//    private static Map<Integer, RedisTemplate> redisTemplateMap = new ConcurrentHashMap<>(2);
//
//
//    @Autowired
//    private JedisPoolPool jedisPoolPool;

    @Autowired
    private JedisPool jedisPool;




    @PostConstruct
    public void init() {
        Jedis jedis = this.jedisPool.getResource();
        try {
            GET_AND_DEL_LUA_SCRIPT_SHA = jedis.scriptLoad(GET_AND_DEL_SCRIPT);
            LOCK_LUA_SCRIPT_SHA = jedis.scriptLoad(LOCK_LUA_SCRIPT);
            UNLOCK_LUA_SCRIPT_SHA = jedis.scriptLoad(UNLOCK_LUA_SCRIPT);
        } catch (Exception e) {
            logger.error("initScript error:", e);
        } finally {
            jedis.close();
        }

//        redisPoolMap.put(redisProperties.getDatabase(), jedisPoolPool.getBaseDataJedisPool());
//        redisPoolMap.put(bindNumProperties.getDatabase(), jedisPoolPool.getBindNumJedisPool());
//
//        redisTemplateMap.put(redisProperties.getDatabase(), redisTemplate);
//        redisTemplateMap.put(bindNumProperties.getDatabase(), bindNumRedisTemplate);
    }


    public Jedis getJedis(int db) {
        return this.getJedisByRedisPoolMap(db);
    }


    public boolean set(String key, String value, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            String rs = jedis.set(key, value);
            if (rs.equals("OK")) {
                flag = true;
            }

        } catch (Exception e) {
            logger.error("redisPoolMap set jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;

    }

    /**
     * 根据 库号 得到对应的jedis 记录
     *
     * @param db
     * @return
     */
    private Jedis getJedisByRedisPoolMap(int db) {
        // 根据库号 得到redis 的连接池
        JedisPool jedisPool = redisPoolMap.get(db);
        Jedis jedis = null;
        // 如果连接池为空 采用默认的连接池
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();

                // 如果jedis 不为空 并且jedis中的库号和传过来的库号相等 返回jedis
                if (jedis != null) {
                    if (jedis.getDB().intValue() != db) {
                        jedis.select(db);
                    }
                    return jedis;
                } else {
                    jedis = this.jedisPool.getResource();
                    if (jedis.getDB().intValue() != db) {
                        jedis.select(db);
                    }
                    return jedis;
                }
            } else {
                jedis = this.jedisPool.getResource();
                if (jedis.getDB().intValue() != db) {
                    jedis.select(db);
                }
                return jedis;
            }
        } catch (Exception e) {
            logger.error("redisPoolMap get jedis db:{},error:", db, e);
            if (jedis != null) {
                jedis.close();
            }
        }
        return new Jedis();
    }


    public boolean setnx(String key, String value, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            Long setnx = jedis.setnx(key, value);
            if (setnx > 0) {
                flag = true;
            }

        } catch (Exception e) {
            logger.error("redisPoolMap setnx jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;

    }


    public boolean setBit(String key, long offset, boolean value, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);

        try {
            flag = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            logger.error("redisPoolMap setBit jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;

    }


    public boolean getBit(String key, long offset, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);

        try {
            flag = jedis.getbit(key, offset);
        } catch (Exception e) {
            logger.error("redisPoolMap getBit jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;
    }





    public boolean hset(String key, String field, String value, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);

        try {
            Long rs = jedis.hset(key, field, value);
            if (rs > 0) {
                flag = true;
            }

        } catch (Exception e) {
            logger.error("redisPoolMap hset jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;

    }

    public boolean mset(int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            jedis.mset("");
        } catch (Exception e) {
            logger.error("redisPoolMap mset jedis error:", e);
        } finally {
            jedis.close();
        }
        return true;
    }


    public boolean setEx(String key, Integer second, String value, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            String rs = jedis.setex(key, second, value);
            if (rs.equals("OK")) {
                flag = true;
            }

        } catch (Exception e) {
            logger.error("redisPoolMap setEx jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;

    }


    public long expire(String key, Integer second, int db) {
        long expire = 0L;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            expire = jedis.expire(key, second);
        } catch (Exception e) {
            logger.error("redisPoolMap expire jedis error:", e);
        } finally {
            jedis.close();
        }
        return expire;

    }


    public String get(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("redisPoolMap get jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Map<String, String> mget(Map<String, String> keys, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            Iterator<String> keysIterator = keys.keySet().iterator();
            String[] mkeys = new String[keys.size()];
            int i = 0;
            while (keysIterator.hasNext()) {
                mkeys[i] = keysIterator.next();
                i++;
            }
            List<String> result = jedis.mget(mkeys);
            for (int j = 0; j < mkeys.length; j++) {
                keys.put(mkeys[j], result.get(j));
            }
            return keys;
        } catch (Exception e) {
            logger.error("redisPoolMap mget jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public String hget(String key, String field, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.error("redisPoolMap hget jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Long hicr(String key, String field, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.hincrBy(key, field, 1);
        } catch (Exception e) {
            logger.error("redisPoolMap hicr jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Map<String, String> hgetAll(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.hgetAll(key);
        } catch (Exception e) {
            logger.error("redisPoolMap hgetAll jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Long del(String key, int db) {

        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.del(key);
        } catch (Exception e) {
            logger.error("redisPoolMap del jedis error:", e);
        } finally {
            jedis.close();
        }
        return new Long(0);

    }


    public Long batchDel(List<String> listKey, int db) {
        Long flag = new Long(0);
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            for (String key : listKey) {
                flag = flag + jedis.del(key);
            }

        } catch (Exception e) {
            logger.error("redisPoolMap batchDel jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;
    }


    public Boolean exists(String key, int db) {
        boolean flag = false;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            flag = jedis.exists(key);
        } catch (Exception e) {
            logger.error("redisPoolMap exists jedis error:", e);
        } finally {
            jedis.close();
        }
        return flag;
    }


    public Long lpush(String key, int db, String... values) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.lpush(key, values);

        } catch (Exception e) {
            logger.error("redisPoolMap lpush jedis error:", e);
        } finally {
            jedis.close();
        }
        return new Long(0);
    }


    public String lPop(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            byte[] bytes = jedis.lpop(key.getBytes("UTF-8"));
            return bytes == null ? null : new String(bytes, "UTF-8");
        } catch (Exception e) {
            logger.error("redisPoolMap lPop jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public List<String> lrange(String key, Long start, Long end, int db) {
        List<String> list = new ArrayList<String>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            list = jedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error("redisPoolMap lrange jedis error:", e);
        } finally {
            jedis.close();
        }
        return list;
    }




    public Long sadd(String key, int db, String... values) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.sadd(key, values);
        } catch (Exception e) {
            logger.error("redisPoolMap sadd jedis error:", e);
        } finally {
            jedis.close();
        }
        return new Long(0);
    }


    public boolean sismember(String key, String member, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.sismember(key, member);
        } catch (Exception e) {
            logger.error("redisPoolMap sismember jedis error:", e);
        } finally {
            jedis.close();
        }
        return false;
    }


    public Set<String> smembers(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.smembers(key);
        } catch (Exception e) {
            logger.error("redisPoolMap smembers jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public String spop(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.spop(key);
        } catch (Exception e) {
            logger.error("redisPoolMap spop jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Long srem(String key, int db, String... values) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.srem(key, values);
        } catch (Exception e) {
            logger.error("redisPoolMap srem jedis error:", e);
        } finally {
            jedis.close();
        }
        return new Long(0);
    }


    public String srandmember(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.srandmember(key);
        } catch (Exception e) {
            logger.error("redisPoolMap srandmember jedis error:", e);
        } finally {
            jedis.close();
        }
        return "";
    }


    public Long scard(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.scard(key);
        } catch (Exception e) {
            logger.error("redisPoolMap scard jedis error:", e);
        } finally {
            jedis.close();
        }
        return new Long(0);
    }


    public Long inc(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        Long res = new Long(0);
        try {
            res = jedis.incr(key);
        } catch (Exception e) {
            logger.error("redisPoolMap inc jedis error:", e);
        } finally {
            jedis.close();
        }

        return res;
    }


    public Long dec(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        Long res = new Long(0);
        try {
            res = jedis.decr(key);
        } catch (Exception e) {
            logger.error("redisPoolMap dec jedis error:", e);
        } finally {
            jedis.close();
        }

        return res;
    }


    public Long TTL(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        Long res = new Long(-1);
        try {
            res = jedis.ttl(key);
        } catch (Exception e) {
            logger.error("redisPoolMap TTL jedis error:", e);
        } finally {
            jedis.close();
        }

        return res;
    }


    public String rpoplpush(String key, String dstkey, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.rpoplpush(key, dstkey);
        } catch (Exception e) {
            logger.error("redisPoolMap rpoplpush jedis error:", e);
        } finally {
            jedis.close();
        }

        return null;
    }


    public String rpop(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.rpop(key);
        } catch (Exception e) {
            logger.error("redisPoolMap rpop jedis error:", e);
        } finally {
            jedis.close();
        }

        return null;
    }


    public String brpop(String key, int timeOut, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            List<String> brpop = jedis.brpop(timeOut, key);
            return CollectionUtils.isEmpty(brpop) ? null : brpop.get(1);
        } catch (Exception e) {
            logger.error("redisPoolMap brpop jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Long llen(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.llen(key);
        } catch (Exception e) {
            logger.error("redisPoolMap llen jedis error:", e);
        } finally {
            jedis.close();
        }
        return 0L;
    }


    public long zadd(String key, double score, String values, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        Long res = new Long(0);
        try {
            res = jedis.zadd(key, score, values);
        } catch (Exception e) {
            logger.error("redisPoolMap zadd jedis error:", e);
        } finally {
            jedis.close();
        }

        return res;
    }


    public Long zcard(String key, int db) {
        Long result = 0L;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zcard(key);
        } catch (Exception e) {
            logger.error("redisPoolMap zcard jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public Set<String> zrange(String key, long start, long stop, int db) {
        Set<String> result = new HashSet<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zrange(key, start, stop);
        } catch (Exception e) {
            logger.error("redisPoolMap zrange jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int limit, int db) {
        Set<Tuple> result = new HashSet<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, limit);
        } catch (Exception e) {
            logger.error("redisPoolMap zrangeByScoreWithScores jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public Set<String> zrangeByScore(String key, double min, double max, int offset, int limit, int db) {
        Set<String> result = new HashSet<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zrangeByScore(key, min, max, offset, limit);
        } catch (Exception e) {
            logger.error("redisPoolMap zrangeByScore jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public List<Tuple> zscan(String key, int db) {
        List<Tuple> result = new ArrayList<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        boolean flag = true;
        String cursor = "0";
        try {
            ScanResult<Tuple> zscan;
            while (flag) {
                zscan = jedis.zscan(key, cursor);
                cursor = zscan.getStringCursor();
                result.addAll(zscan.getResult());
                if ("0".equals(cursor)) {
                    flag = false;
                }
            }
        } catch (Exception e) {
            logger.error("redisPoolMap zscan jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public Set<Tuple> zrangeWithScores(String key, long start, long stop, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.zrangeWithScores(key, start, stop);
        } catch (Exception e) {
            logger.error("redisPoolMap zrangeWithScores jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public long zremByScore(String key, long start, long end, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            logger.error("redisPoolMap zremByScore jedis error:", e);
        } finally {
            jedis.close();
        }
        return 0;
    }


    public long zrem(String key, int db, String... values) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        long res = 0;
        try {
            res = jedis.zrem(key, values);
        } catch (Exception e) {
            logger.error("redisPoolMap zrem jedis error:", e);
        } finally {
            jedis.close();
        }
        return res;
    }


    public Set<String> zrevRange(String key, long start, long stop, int db) {
        Set<String> result = new LinkedHashSet<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zrevrange(key, start, stop);
            return result;
        } catch (Exception e) {
            logger.error("redisPoolMap zrevRange jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * 判断member在zset中是否存在
     *
     * @param key
     * @param member
     * @param db
     * @return
     */

    public Double zscore(String key, String member, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.zscore(key, member);
        } catch (Exception e) {
            logger.error("redisPoolMap zscore jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Set<Tuple> zrevRangeWithScores(String key, long start, long stop, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.zrevrangeWithScores(key, start, stop);
        } catch (Exception e) {
            logger.error("redisPoolMap zrevRangeWithScores jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public boolean hexists(String key, String value, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        boolean exist = false;
        try {
            exist = jedis.hexists(key, value);
        } catch (Exception e) {
            logger.error("redisPoolMap hexists jedis error:", e);
        } finally {
            jedis.close();
        }
        return exist;
    }


    public long hlen(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        long len = 0;
        try {
            len = jedis.hlen(key);
        } catch (Exception e) {
            logger.error("redisPoolMap hlen jedis error:", e);
        } finally {
            jedis.close();
        }
        return len;
    }


    public double zinc(String key, double score, String value, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            return jedis.zincrby(key, score, value);
        } catch (Exception e) {
            logger.error("redisPoolMap zinc jedis error:", e);
        } finally {
            jedis.close();
        }
        return 0;
    }


    public long hdel(String key, String value, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        long res = 0;
        try {
            res = jedis.hdel(key, value);
        } catch (Exception e) {
            logger.error("redisPoolMap hdel jedis error:", e);
        } finally {
            jedis.close();
        }
        return res;
    }


    public Boolean lock(String key, String value, long expireTime, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            Object obj = jedis.evalsha(LOCK_LUA_SCRIPT_SHA, 1, key, value, String.valueOf(expireTime));
            if (obj != null && LOCK_LUA_SCRIPT_RESULT_OK.equals(obj.toString())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("redisPoolMap lock jedis error:", e);
        } finally {
            jedis.close();
        }
        return false;
    }


    public void unLock(String key, String value, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            Object obj = jedis.evalsha(UNLOCK_LUA_SCRIPT_SHA, 1, key, value);
        } catch (Exception e) {
            logger.error("redisPoolMap unLock jedis error:", e);
        } finally {
            jedis.close();
        }
    }



    public String getAndDel(String key, int db) {
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            Object obj = jedis.evalsha(GET_AND_DEL_LUA_SCRIPT_SHA, 1, key);
            return obj == null ? null : obj.toString();
        } catch (Exception e) {
            logger.error("redisPoolMap getAndDel jedis error:", e);
        } finally {
            jedis.close();
        }
        return null;
    }




    public <T> boolean convertAndSend(String channel, T message) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            logger.info("[convertAndSend] " + channel + " " + json);
            jedis.publish(channel, json);
        } catch (JsonProcessingException e) {
            logger.error("RedisService.convertAndSend  channel :{} message:{} error : {}", channel, message, e);
            return false;
        } finally {
            jedis.close();
        }
        return true;
    }


    public <T> boolean convertAndSendAnother(String channel, T message) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            logger.info("[convertAndSendAnother] " + channel + " " + json);
            jedis.publish(channel, json);
            // 消息同步
            /*BindNumV3Service bindNumV3Service = (BindNumV3Service) ContextUtil.getContext().getBean("bindNumV3Service");
            bindNumV3Service.convertMsgAnother(channel, JSON.toJSONString(message));*/
        } catch (JsonProcessingException e) {
            logger.error("RedisService.convertAndSendAnother  channel :{} message:{} error : {}", channel, message, e);
            return false;
        } finally {
            jedis.close();
        }
        return true;
    }


    public String ping() {
        Jedis jedis = this.jedisPool.getResource();
        try {
            return jedis.ping();
        } catch (Exception e) {
            logger.error("RedisService ping error:{}", e);
        } finally {
            jedis.close();
        }
        return null;
    }


    public Long zrank(String key, String value, int redisDb) {
        Long result = null;
        Jedis jedis = this.getJedisByRedisPoolMap(redisDb);
        try {
            result = jedis.zrank(key, value);
        } catch (Exception e) {
            logger.error("redisPoolMap unLock jedis error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Map<String, String> hscan(String key, String cursor, int db) {
        Map<String, String> result = new HashMap<>();
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            do {
                ScanResult<Map.Entry<String, String>> scanResult = jedis.hscan(key, cursor);
                cursor = scanResult.getStringCursor();
                List<Map.Entry<String, String>> scanResultResult = scanResult.getResult();
                scanResultResult.forEach(a -> result.put(a.getKey(), a.getValue()));
            } while (!ScanParams.SCAN_POINTER_START.equals(cursor));

        } catch (Exception e) {
            logger.error("hscan error:", e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public Long zcount(String key, long min, long max, int db) {
        Long result = 0L;
        Jedis jedis = this.getJedisByRedisPoolMap(db);
        try {
            result = jedis.zcount(key, min, max);
        } catch (Exception e) {
            logger.error("redisPoolMap zcount jedis error:",e);
        } finally {
            jedis.close();
        }
        return result;
    }
}
