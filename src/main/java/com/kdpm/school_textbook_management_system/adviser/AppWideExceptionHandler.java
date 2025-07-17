package com.kdpm.school_textbook_management_system.adviser;

import com.kdpm.school_textbook_management_system.exception.NotFoundException;
import com.kdpm.school_textbook_management_system.util.StandardResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Error Coming", e.getMessage() + "Hellow Error!?"),
                HttpStatus.NOT_FOUND
        );
    }
}
