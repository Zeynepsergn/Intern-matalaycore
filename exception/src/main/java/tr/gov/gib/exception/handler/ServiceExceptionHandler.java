package tr.gov.gib.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tr.gov.gib.common.ServiceReturnObject;
import tr.gov.gib.exception.ServiceException;
import tr.gov.gib.exception.error.ApiError;

@RestControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {ServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> ResponseEntity<ServiceReturnObject<T>> handleServiceException(ServiceException exception){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(exception.getMessage());
        ServiceReturnObject<T> serviceReturnObject = new ServiceReturnObject<>(exception.getServiceEnum());
        return buildResponseEntity(apiError,serviceReturnObject);
    }


    private <T> ResponseEntity<ServiceReturnObject<T>> buildResponseEntity(ApiError apiError, ServiceReturnObject<T> serviceReturnObject) {
        serviceReturnObject.setErrorObject(apiError);
        return new ResponseEntity<>(serviceReturnObject, apiError.getStatus());
    }
}

