package dev.allokanic.yando.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class YandoGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntryNotFoundException.class})
    protected ResponseEntity<Object> handleEntryNotFoundException(EntryNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(404, "Item not found"), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(400, "Validation Failed"), HttpStatus.BAD_REQUEST);
    }
}
