package tr.gov.gib.rabbitconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tr.gov.gib.entity.Actor;

@Component
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    private final ObjectMapper mapper;

    public RabbitMQJsonConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(Actor actor) throws JsonProcessingException {
        System.out.println("Buraya geldi.!");
        String actorStr = mapper.writeValueAsString(actor);
        LOGGER.info(String.format("Received JSON message -> %s", actorStr));
    }
}
