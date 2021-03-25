package com.example.zup.vacinabrasil.exception;

import java.time.LocalDateTime;

public class ValidationExceptionDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;

    public ValidationExceptionDetails(String title, int status, String developerMessage, String details, LocalDateTime timeStamp, String fields, String fieldsMessage) {
        super(title, status, developerMessage, details, timeStamp);
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
    }
}
