package tr.gov.gib.exception;

import tr.gov.gib.common.enums.ServiceEnum;

public class ServiceException extends RuntimeException{

    private ServiceEnum serviceEnum;

    public ServiceException(String message, ServiceEnum serviceEnum) {
        super(message);
        this.serviceEnum = serviceEnum;
    }

    public ServiceEnum getServiceEnum() {
        return serviceEnum;
    }

    public void setServiceEnum(ServiceEnum serviceEnum) {
        this.serviceEnum = serviceEnum;
    }
}
