package tr.gov.gib.productinquiryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="tr.gov.gib")
@EntityScan("tr.gov.gib.entity")
@EnableJpaRepositories(basePackages = {"tr.gov.gib.repository"})
@ComponentScan(
        {
                "tr.gov.gib.mapping",
                "tr.gov.gib.services",
                "tr.gov.gib.productinquiryapi.config",
                "tr.gov.gib.**"
        })
public class ProductInquiryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductInquiryApiApplication.class, args);
    }

}
