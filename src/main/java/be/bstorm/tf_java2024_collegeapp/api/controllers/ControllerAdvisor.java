package be.bstorm.tf_java2024_collegeapp.api.controllers;

import be.bstorm.tf_java2024_collegeapp.bll.exceptions.CourseAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.FlexibleHashMap;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CourseAlreadyExistException.class)
    public ResponseEntity<String> handleRunTimeException(CourseAlreadyExistException e){
        log.error(e.toString());
        return ResponseEntity.status(406).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));

        return ResponseEntity.status(406).body(errors);
    }

}
