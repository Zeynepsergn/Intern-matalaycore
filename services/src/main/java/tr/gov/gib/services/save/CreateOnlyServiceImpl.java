package tr.gov.gib.services.save;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CreateOnlyServiceImpl<T, ID, R extends JpaRepository<T,ID>> implements SaveOnlyService<T,ID> {

    private final R repository;

    public CreateOnlyServiceImpl(R repository) {
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
}
