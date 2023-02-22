package tr.gov.gib.rabbitpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"tr.gov.gib"})
@ComponentScan(basePackages = {
        "tr.gov.gib.rabbitpublisher.config",
        "tr.gov.gib.rabbitpublisher.publisher",
        "tr.gov.gib.**",
})
public class RabbitpublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitpublisherApplication.class, args);
    }

}
