package tr.gov.gib.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.gov.gib.common.enums.ServiceEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceReturnObject<T> extends BaseObject{

    private boolean result;
    private int resultCode;
    private String resultMessage;
    private Object errorObject;
    private T data;

    public ServiceReturnObject(ServiceEnum serviceEnum){
        this.result = serviceEnum.isResult();
        this.resultCode = serviceEnum.getResultCode();
        this.resultMessage = serviceEnum.getResultMessage();
    }

    public ServiceReturnObject(ServiceEnum serviceEnum, T data){
        this.result = serviceEnum.isResult();
        this.resultCode = serviceEnum.getResultCode();
        this.resultMessage = serviceEnum.getResultMessage();
        this.data = data;
    }

    public ServiceReturnObject(ServiceEnum serviceEnum, T data,Object errorObject){
        this.result = serviceEnum.isResult();
        this.resultCode = serviceEnum.getResultCode();
        this.resultMessage = serviceEnum.getResultMessage();
        this.data = data;
        this.errorObject = errorObject;
    }
}
