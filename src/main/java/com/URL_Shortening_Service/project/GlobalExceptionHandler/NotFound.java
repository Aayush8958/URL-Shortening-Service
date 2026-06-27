package com.URL_Shortening_Service.project.GlobalExceptionHandler;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
