package tr.gov.gib.rabbitpublisher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.gov.gib.common.ServiceInputObject;
import tr.gov.gib.rabbitpublisher.publisher.RabbitMQJsonProducer;
import tr.gov.gib.rabbitpublisher.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;
    private RabbitMQJsonProducer jsonProducer;

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
    public ResponseEntity<String> sendJsonMessage(@RequestBody ServiceInputObject<String> message){
        jsonProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
