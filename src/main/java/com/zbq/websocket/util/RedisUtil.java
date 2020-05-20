package com.zbq.websocket.util;

import com.zbq.websocket.config.RedisConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
    @SuppressWarnings("rawtypes")

    @Resource
    private RedisConfig redisConfig;


    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 写入缓存
     * @param key String
     * @param value Object
     * @return boolean
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 写入缓存  指定时间  单位：秒
     * @param key String
     * @param value Object
     * @param expireTime Long
     * @return boolean
     */
    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key String
     * @return boolean
     */
    public boolean exists(final String key) {
        boolean flag = false;
        if (null != key) {
            flag = redisTemplate.hasKey(key);
        }
        return flag;
    }

    /**
     * 读取缓存
     *
     * @param key String
     * @return Object
     */
    /*public String get(final String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        System.out.println("SessionId:"+key);
        String result = operations.get(key);
        System.out.println("PoolResult:"+result);
        if (null == result || "".equals(result)) {
            result = getJedisToJson(key);
            System.out.println("NoPoolResult:"+result);
        }
        return result;
    }*/
    /**
     * 读取缓存
     * @param key String
     * @return Object
     */
    public String get(final String key) {
        String result = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 删除对应的value
     * @param key String
     */
    public synchronized void remove(final String key) {
        if (null != key && exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern String
     */
    public synchronized void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (null != keys && keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 批量删除对应的value
     * @param keys String
     */
    public synchronized void removes(final String... keys) {
        if (keys != null) {
            for (String key : keys) {
                remove(key);
            }
        }
    }

    /**
     * @description 直连redis获取值
     * @param sessionId String
     * @return JSONObject
     */
    public String getJedisToJson(String sessionId) {
        Jedis jedis = new Jedis(redisConfig.getHost(), Integer.parseInt(redisConfig.getPort()));
        if (null != redisConfig.getPassword() && !"".equals(redisConfig.getPassword())) {
            jedis.auth(redisConfig.getPassword());
        }
        String source = jedis.get(sessionId);
        if (null != jedis) {
            jedis.close();
        }
        return source;
    }
}
