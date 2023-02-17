package tr.gov.gib.productinquiryapi.cache;

import java.util.Map;

public interface RedisCacheService<HK,HV> {

    void putToCache(String key, HK hashKey, HV hashValue);
    void putToCache(String key, Map<HK,HV> map);
}
