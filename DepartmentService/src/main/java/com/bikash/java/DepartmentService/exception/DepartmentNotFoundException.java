package com.bikash.java.DepartmentService.exception;

public class DepartmentNotFoundException extends RuntimeException{
    private String statudCode;
    public  DepartmentNotFoundException(String message, String statudCode) {
        super(message);
        this.statudCode = statudCode;
    }
}
