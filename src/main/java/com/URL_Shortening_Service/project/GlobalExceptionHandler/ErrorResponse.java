package com.URL_Shortening_Service.project.GlobalExceptionHandler;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    String message;
    LocalDateTime Date;
    HttpStatus status;
}
