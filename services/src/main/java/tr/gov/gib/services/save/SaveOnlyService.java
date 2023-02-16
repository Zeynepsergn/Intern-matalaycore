package tr.gov.gib.services.save;

public interface SaveOnlyService<T,ID> {
    T addRecord(T entity);

    T addRecordAndFlush(T entity);
}
