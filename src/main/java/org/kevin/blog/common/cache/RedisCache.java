package org.kevin.blog.common.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kevin.Z
 * @version 12/3/18
 *
 * 可以使用 redis 了。01-15
 */
@Component
public class RedisCache {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

}
