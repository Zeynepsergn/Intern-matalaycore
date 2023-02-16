package tr.gov.gib.messageapi;

import org.mapstruct.factory.Mappers;
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

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<ServiceReturnObject<String>> getHealth(){
        ServiceReturnObject<String> serviceReturnObject = serviceMapper.getServiceReturnObject("Service is alive.",ServiceEnum.OK);
        return ResponseEntity.ok(serviceReturnObject);
    }
}
