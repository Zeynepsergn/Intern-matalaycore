package tr.gov.gib.rabbitpublisher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.gib.common.ServiceInputObject;
import tr.gov.gib.common.ServiceReturnObject;
import tr.gov.gib.common.enums.ServiceEnum;
import tr.gov.gib.entity.Actor;
import tr.gov.gib.rabbitpublisher.publisher.RabbitMQJsonProducer;
import tr.gov.gib.rabbitpublisher.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer producer;
    private final RabbitMQJsonProducer jsonProducer;

    public MessageController(RabbitMQProducer producer,RabbitMQJsonProducer jsonProducer) {
        this.producer = producer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    @PostMapping("/publish")
    public ResponseEntity<ServiceReturnObject<Actor>> sendJsonMessage(@RequestBody ServiceInputObject<Actor> inputObject){
        jsonProducer.sendJsonMessage(inputObject);
        ServiceReturnObject<Actor> serviceReturnObject = new ServiceReturnObject<>(ServiceEnum.CREATED,inputObject.getInputBody());
        return ResponseEntity.ok(serviceReturnObject);
    }
}
