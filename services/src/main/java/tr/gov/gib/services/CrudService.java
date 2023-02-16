package tr.gov.gib.services;

import tr.gov.gib.services.save.SaveOnlyService;
import tr.gov.gib.services.read.ReadOnlyService;

public interface CrudService<T,ID> extends ReadOnlyService<T,ID>, SaveOnlyService<T,ID> {
}
