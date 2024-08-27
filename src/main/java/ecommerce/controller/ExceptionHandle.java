package ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandle {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler() {
        return "null_page";
    }
}
