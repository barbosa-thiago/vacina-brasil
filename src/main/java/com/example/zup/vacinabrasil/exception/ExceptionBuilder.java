package com.example.zup.vacinabrasil.exception;

import java.time.LocalDateTime;

public class ExceptionBuilder {
    private String title;
    private int status;
    private String developerMessage;
    private String details;
    private LocalDateTime timeStamp;

    public ExceptionBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ExceptionBuilder status(int status) {
        this.status = status;
        return this;
    }

    public ExceptionBuilder developerMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ExceptionBuilder details(String details) {
        this.details = details;
        return this;
    }

    public ExceptionBuilder timeStamp(LocalDateTime timestamp) {
        this.timeStamp = timestamp;
        return this;
    }

    public ExceptionDetails createExceptionDetails() {
        return new ExceptionDetails(title, status, developerMessage, details, timeStamp);
    }
}