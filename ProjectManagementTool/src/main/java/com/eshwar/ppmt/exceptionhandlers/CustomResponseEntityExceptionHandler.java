package com.eshwar.ppmt.exceptionhandlers;

import com.eshwar.ppmt.exceptions.ProjectIdException;
import com.eshwar.ppmt.exceptions.ProjectIdExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleProjectException(ProjectIdException projectIdException, WebRequest webRequest) {
        ProjectIdExceptionResponse projectIdExceptionResponse = new ProjectIdExceptionResponse(projectIdException.getMessage());
        return new ResponseEntity(projectIdExceptionResponse, HttpStatus.BAD_REQUEST);

    }
}
