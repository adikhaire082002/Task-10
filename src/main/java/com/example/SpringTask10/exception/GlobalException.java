package com.example.SpringTask10.exception;

import com.example.SpringTask10.DTO.ResponseDto;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errors.put(field,defaultMessage);
        });
        ResponseDto response = new ResponseDto(new Timestamp(System.currentTimeMillis()),HttpStatus.BAD_REQUEST,errors,request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handlerRuntimeException(RuntimeException e, HttpServletRequest request) {

        ResponseDto response = new ResponseDto(new Timestamp(System.currentTimeMillis()),HttpStatus.BAD_REQUEST,e.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseDto> handlerResourceNotFound(ResourceNotFound e,HttpServletRequest request) {
        ResponseDto response = new ResponseDto(new Timestamp(System.currentTimeMillis()),HttpStatus.NOT_FOUND,e.getMessage(),request.getRequestURI());
        return new ResponseEntity<ResponseDto>(response,HttpStatus.NOT_FOUND);
    }

//    private String getPath(Exception ex) {
//        StringBuilder path = new StringBuilder();
//
//        for (StackTraceElement element : ex.getStackTrace()) {
//            path.append("class:").append(element.getClassName())
//            .append("method:").append(element.getMethodName())
//            .append("line:").append(element.getLineNumber());
//        }
//
//        return path.toString();
//    }
}
