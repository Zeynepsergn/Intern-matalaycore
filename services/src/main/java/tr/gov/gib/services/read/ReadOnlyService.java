package tr.gov.gib.services.read;

import java.util.List;
import java.util.Optional;

public interface ReadOnlyService<T,ID> {
    List<T> getAll();
    Optional<T> getOne(ID id);
}
