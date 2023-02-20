package tr.gov.gib.productinquiryapi.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tr.gov.gib.entity.Actor;
import tr.gov.gib.productinquiryapi.redis.RedisActorService;
import tr.gov.gib.productinquiryapi.service.ActorService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ActorRedisComponent {

    private final RedisActorService redisActorService;
    private final ActorService actorService;
    private final ObjectMapper objectMapper;

    public ActorRedisComponent(RedisActorService redisActorService, ActorService actorService, ObjectMapper objectMapper) {
        this.redisActorService = redisActorService;
        this.actorService = actorService;
        this.objectMapper = objectMapper;
    }

    @Bean
    @Primary
    public void actorCaching(){
        List<Actor> actors = actorService.getAll();
        Map<String, String> map =
                actors.stream().collect(Collectors.toMap(actor -> actor.getActorId().toString(), actor -> {
                    try {
                        return objectMapper.writeValueAsString(actor);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return "";
                    }
                }));
        redisActorService.putMapToRedis("aktorler",map);
    }

//    @Bean
//    public void actorGething() throws JsonProcessingException {
//        Object actor = redisTemplate.
//        System.out.println(objectMapper.writeValueAsString(actor));
//    }

}
