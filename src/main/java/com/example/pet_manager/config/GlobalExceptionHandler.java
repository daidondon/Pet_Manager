package com.example.pet_manager.config;

import com.example.pet_manager.exception.APIException;
import com.example.pet_manager.response.EntityCustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder("Lỗi : ");
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.append(error.getDefaultMessage()).append(",")
        );
        String mess = errors.toString();
        if(mess.endsWith(",")){
            mess =  mess.substring(0,mess.lastIndexOf(","));
        }
        return ResponseEntity.badRequest().body(new EntityCustomResponse(0, mess, 400, null));
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> handleValidationExceptionApi(APIException apiException) {
        return ResponseEntity.badRequest().body(new EntityCustomResponse(0, apiException.getMessage(), apiException.getStatus().value(), null));
    }


}

