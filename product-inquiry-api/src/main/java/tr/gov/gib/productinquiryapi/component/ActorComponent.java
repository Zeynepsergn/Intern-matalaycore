package tr.gov.gib.productinquiryapi.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import tr.gov.gib.entity.Actor;
import tr.gov.gib.productinquiryapi.service.ActorService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ActorComponent {

    private final RedisTemplate redisTemplate;
    private final ActorService actorService;
    private final ObjectMapper objectMapper;

    public ActorComponent(RedisTemplate redisTemplate,ActorService actorService,ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
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
        redisTemplate.opsForHash().putAll("aktorler",map);
    }

    @Bean
    public void actorGething() throws JsonProcessingException {
        Object actor = redisTemplate.opsForHash().get("aktorler","41");
        System.out.println(objectMapper.writeValueAsString(actor));
    }

}
