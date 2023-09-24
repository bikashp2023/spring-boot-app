package com.bikash.java.DepartmentService.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DepartmentNotFoundException.class)
    DepartmentNotFoundException departmentNotFound(DepartmentNotFoundException e) {
        return  e;
    }
}
