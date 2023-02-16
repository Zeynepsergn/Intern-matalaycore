package tr.gov.gib.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ServiceInputObject<T> extends BaseObject {

    private T inputBody;
}
