package tr.gov.gib.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T,ID,R extends JpaRepository<T,ID>> implements CrudService<T,ID>{

    private final R repository;

    public CrudServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T addRecord(T entity) {
        return repository.save(entity);
    }

    @Override
    public T addRecordAndFlush(T entity) {
        return repository.saveAndFlush(entity);
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
