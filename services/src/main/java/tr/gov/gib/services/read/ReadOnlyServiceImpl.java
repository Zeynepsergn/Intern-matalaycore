package tr.gov.gib.services.read;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class ReadOnlyServiceImpl<T,ID,R extends JpaRepository<T,ID>> implements ReadOnlyService<T,ID>{

    private final R repository;

    public ReadOnlyServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getOne(ID id) {
        return repository.findById(id);
    }
}
