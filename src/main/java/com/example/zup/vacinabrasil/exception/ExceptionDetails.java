package com.example.zup.vacinabrasil.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String developerMessage;
    protected String details;
    protected LocalDateTime timeStamp;

    public ExceptionDetails(String title, int status, String developerMessage, String details, LocalDateTime timeStamp) {
        this.title = title;
        this.status = status;
        this.developerMessage = developerMessage;
        this.details = details;
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
