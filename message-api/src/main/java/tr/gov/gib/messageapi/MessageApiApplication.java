package tr.gov.gib.messageapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="tr.gov.gib")
@ComponentScan(
        {
                "tr.gov.gib.mapping",
                "tr.gov.gib.**"
        })
public class MessageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApiApplication.class, args);
    }

}
