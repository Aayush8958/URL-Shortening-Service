package com.URL_Shortening_Service.project.GlobalExceptionHandler;

public class AlreadyExists extends RuntimeException {
    public AlreadyExists(String message) {
        super(message);
    }
}
