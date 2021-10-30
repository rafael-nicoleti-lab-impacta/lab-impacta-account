package br.com.lab.impacta.account.handler;

import br.com.lab.impacta.account.handler.exception.AccountDontExistsException;
import br.com.lab.impacta.account.handler.exception.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AccountDontExistsException.class)
    public ResponseEntity<ErrorMessageResponse> accountNotFoundException(AccountDontExistsException accountDontExistsException) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                accountDontExistsException.getMessage(),
                accountDontExistsException.getDescription());

        return new ResponseEntity<>(errorMessageResponse, HttpStatus.NOT_FOUND);
    }
}
