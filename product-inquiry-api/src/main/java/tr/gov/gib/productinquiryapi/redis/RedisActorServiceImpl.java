package tr.gov.gib.productinquiryapi.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tr.gov.gib.redis.RedisServiceImpl;

@Service
public class RedisActorServiceImpl extends RedisServiceImpl<String,String,String> implements RedisActorService{

    public RedisActorServiceImpl(RedisTemplate redisTemplate) {
        super(redisTemplate);
    }
}
