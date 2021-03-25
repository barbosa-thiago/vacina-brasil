package com.example.zup.vacinabrasil.handler;


import com.example.zup.vacinabrasil.exception.ExceptionBuilder;
import com.example.zup.vacinabrasil.exception.ExceptionDetails;
import com.example.zup.vacinabrasil.exception.ValidationExceptionBuilder;
import com.example.zup.vacinabrasil.exception.ValidationExceptionDetails;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDetails>
    handleConstraintViolationException(ConstraintViolationException exception, HttpServletRequest request) {
        return new ResponseEntity<>(
                new ExceptionBuilder()
                        .title(exception.getClass().getName())
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(exception.getCause().getCause().getMessage())
                        .developerMessage(exception.getCause().getMessage())
                        .createExceptionDetails(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetails>
    handleDataIntegrityViolationException(DataIntegrityViolationException exception) {

        ExceptionDetails exceptionDetails = new ExceptionBuilder()
                .title(exception.getClass().getName())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .details(exception.getCause().getCause().getMessage())
                .developerMessage(exception.getCause().getMessage())
                .createExceptionDetails();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDetails);
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionDetails>
    handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        return new ResponseEntity<>(new ExceptionBuilder()
                .title(exception.getClass().getName())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .details(exception.getCause().getCause().getMessage())
                .developerMessage(exception.getCause().getMessage())
                .createExceptionDetails(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionBuilder()
                .title(exception.getClass().getName())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .details(exception.getCause().getCause().getMessage())
                .developerMessage(exception.getCause().getMessage())
                .createExceptionDetails();
        return new ResponseEntity<>(exceptionDetails, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        ValidationExceptionDetails exceptionDetails = new ValidationExceptionBuilder()
                .title(exception.getClass().getName())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .details(exception.getCause().getCause().getMessage())
                .developerMessage(exception.getCause().getMessage())
                .fields(fields)
                .fieldsMesssage(fieldsMessage)
                .createValidationExceptionDetails();
        return new ResponseEntity<>( exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}

