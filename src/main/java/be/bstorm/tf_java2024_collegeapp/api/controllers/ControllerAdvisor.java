package be.bstorm.tf_java2024_collegeapp.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRunTimeException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
