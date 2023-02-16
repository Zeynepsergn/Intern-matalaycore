package tr.gov.gib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.gov.gib.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
