package tr.gov.gib.productinquiryapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.gov.gib.entity.Actor;
import tr.gov.gib.productinquiryapi.service.ActorService;
import tr.gov.gib.repository.ActorRepository;
import tr.gov.gib.services.read.ReadOnlyServiceImpl;

@Service("ActorService")
@Transactional
public class ActorServiceImpl extends ReadOnlyServiceImpl<Actor,Integer, ActorRepository> implements ActorService {

    @Autowired
    public ActorServiceImpl(ActorRepository repository) {
        super(repository);
    }
}
