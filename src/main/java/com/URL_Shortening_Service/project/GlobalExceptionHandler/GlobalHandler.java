package com.URL_Shortening_Service.project.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = NotFound.class)
    public ResponseEntity<ErrorResponse> noTFound(NotFound notFound){
       ErrorResponse response=new ErrorResponse();
       response.setDate(LocalDateTime.now());
       response.setMessage(notFound.getMessage());
       response.setStatus(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(value = AlreadyExists.class)
    public ResponseEntity<ErrorResponse> AlreadyExist(AlreadyExists exists){
        ErrorResponse response=new ErrorResponse();
        response.setDate(LocalDateTime.now());
        response.setMessage(exists.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public  ResponseEntity<ErrorResponse> Notvalid(MethodArgumentNotValidException e){
        ErrorResponse response=new ErrorResponse();
        response.setDate(LocalDateTime.now());
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


}
