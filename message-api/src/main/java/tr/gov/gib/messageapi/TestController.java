package tr.gov.gib.messageapi;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.gib.common.ServiceReturnObject;
import tr.gov.gib.common.enums.ServiceEnum;
import tr.gov.gib.mapping.ServiceMapper;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    private final ServiceMapper serviceMapper = Mappers.getMapper(ServiceMapper.class);
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<ServiceReturnObject<String>> getHealth(){
        LOG.info("Loglama yapildi.");
        ServiceReturnObject<String> serviceReturnObject = serviceMapper.getServiceReturnObject("Service is alive.",ServiceEnum.OK);
        return ResponseEntity.ok(serviceReturnObject);
    }
}
