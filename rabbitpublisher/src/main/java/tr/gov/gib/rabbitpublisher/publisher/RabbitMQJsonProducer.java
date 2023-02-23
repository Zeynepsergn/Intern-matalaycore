package tr.gov.gib.rabbitpublisher.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tr.gov.gib.common.ServiceInputObject;
import tr.gov.gib.common.ServiceReturnObject;

@Component
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public <T> void sendJsonMessage(ServiceInputObject<T> serviceInputObject){
        T type = serviceInputObject.getInputBody();
        LOGGER.info(String.format("Json message sent -> %s", type.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, type);
    }
}
