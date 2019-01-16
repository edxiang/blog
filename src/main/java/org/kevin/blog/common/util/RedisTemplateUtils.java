package org.kevin.blog.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2019-01-02
 */
@Component
public class RedisTemplateUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * put cache into redis without expire time
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * put cache into redis with expire time.
     * the default unit is million seconds
     *
     * @param key
     * @param value
     * @param expire
     */
    public void setWithExpireTime(String key, Object value, int expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MILLISECONDS);
    }

    public void setWithExpireTimeAndUnit(String key, Object value, int expire, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, expire, unit);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void deleteMore(List<String> keys) {
        redisTemplate.delete(keys);
    }

    public boolean checkIfExist(String key) {
        return redisTemplate.hasKey(key);
    }
}
