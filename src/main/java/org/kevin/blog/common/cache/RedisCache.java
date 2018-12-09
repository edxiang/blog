package org.kevin.blog.common.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 12/3/18
 */
@Component
public class RedisCache {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

}
