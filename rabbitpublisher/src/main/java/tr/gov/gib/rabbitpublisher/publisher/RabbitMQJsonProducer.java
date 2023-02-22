package tr.gov.gib.rabbitpublisher.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tr.gov.gib.common.ServiceInputObject;
import tr.gov.gib.common.ServiceReturnObject;

@Service
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

    public void sendJsonMessage(ServiceInputObject<String> serviceInputObject){
        LOGGER.info(String.format("Json message sent -> %s", serviceInputObject.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, serviceInputObject);
    }
}
