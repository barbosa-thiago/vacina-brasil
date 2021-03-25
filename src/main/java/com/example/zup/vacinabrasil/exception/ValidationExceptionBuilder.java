package com.example.zup.vacinabrasil.exception;

import java.time.LocalDateTime;

public class ValidationExceptionBuilder {
    private String title;
    private int status;
    private String developerMessage;
    private String details;
    private LocalDateTime timeStamp;
    private String fields;
    private String fieldsMesssage;

    public ValidationExceptionBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ValidationExceptionBuilder status(int status) {
        this.status = status;
        return this;
    }

    public ValidationExceptionBuilder developerMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ValidationExceptionBuilder details(String details) {
        this.details = details;
        return this;
    }

    public ValidationExceptionBuilder timeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ValidationExceptionBuilder fields(String fields) {
        this.fields = fields;
        return this;
    }

    public ValidationExceptionBuilder fieldsMesssage(String fieldsMesssage) {
        this.fieldsMesssage = fieldsMesssage;
        return this;
    }

    public ValidationExceptionDetails createValidationExceptionDetails() {
        return new ValidationExceptionDetails(title, status, developerMessage, details, timeStamp, fields, fieldsMesssage);
    }
}