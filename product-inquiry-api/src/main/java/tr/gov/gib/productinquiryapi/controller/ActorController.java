package tr.gov.gib.productinquiryapi.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.gib.common.ServiceReturnObject;
import tr.gov.gib.common.enums.ServiceEnum;
import tr.gov.gib.entity.Actor;
import tr.gov.gib.mapping.ServiceMapper;
import tr.gov.gib.productinquiryapi.service.ActorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    private final ActorService actorService;
    private final ServiceMapper serviceMapper = Mappers.getMapper(ServiceMapper.class);

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    @ResponseBody
    public ResponseEntity<ServiceReturnObject<List<Actor>>> getActorList(){
        ServiceReturnObject<List<Actor>> actors = serviceMapper.getServiceReturnObject(actorService.getAll(), ServiceEnum.OK);
        return ResponseEntity.ok(actors);
    }
}
