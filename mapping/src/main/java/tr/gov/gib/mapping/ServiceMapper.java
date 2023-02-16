package tr.gov.gib.mapping;

import org.mapstruct.Mapper;
import tr.gov.gib.common.ServiceReturnObject;
import tr.gov.gib.common.enums.ServiceEnum;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    default <T> ServiceReturnObject<T> getServiceReturnObject(T t, ServiceEnum serviceEnum){
        ServiceReturnObject<T> serviceReturnObject = new ServiceReturnObject<T>(serviceEnum, t);
        return serviceReturnObject;
    }


}
