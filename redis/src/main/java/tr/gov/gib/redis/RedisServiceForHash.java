package tr.gov.gib.redis;

import java.util.Map;

public interface RedisServiceForHash<K,HK,HV> {
    void putMapToRedis(K key, HK hashKey, HV hashValue);
    void putMapToRedis(K key, Map<HK,HV> map);
    void removeMapToRedis(K key, HK hashKey, HV hashValue);
    void removeMapToRedis(K key, Map<HK,HV> map);
}
