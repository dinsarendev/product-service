package kh.com.bbu.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<MessageResponse> handlerMessageApiException(
        ApiException exception
    ){
        return new ResponseEntity<>(
            new MessageResponse(
                null,
                false,
                exception.getMessage(), exception.getError()
            ),
            HttpStatus.OK
        );

    }
}
