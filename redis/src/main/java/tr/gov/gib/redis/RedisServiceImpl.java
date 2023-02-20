package tr.gov.gib.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public abstract class RedisServiceImpl<K,HK,HV> implements RedisServiceForHash<K,HK,HV>{

    private final RedisTemplate<K,HV> redisTemplate;

    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void putMapToRedis(K key, HK hashKey, HV hashValue) {
        redisTemplate.opsForHash().put(key,hashKey,hashValue);
    }

    @Override
    public void putMapToRedis(K key, Map<HK, HV> map) {
        redisTemplate.opsForHash().putAll(key,map);
    }

    @Override
    public void removeMapToRedis(K key, HK hashKey, HV hashValue) {
        redisTemplate.opsForHash().delete(key,hashKey);
    }

    @Override
    public void removeMapToRedis(K key, Map<HK, HV> map) {
        redisTemplate.opsForHash().delete(key,map.keySet());
    }
}
