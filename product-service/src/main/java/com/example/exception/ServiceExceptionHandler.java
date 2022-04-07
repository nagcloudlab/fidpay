package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public HttpError notFoundExceptionHandler(HttpServletRequest request, NotFoundException ex) {
        HttpError httpError = new HttpError();
        httpError.setUrl(request.getRequestURI());
        httpError.setErrorCode("NF");
        httpError.setLocalDateTime(LocalDateTime.now());
        httpError.setMessage(ex.getMessage());
        return httpError;
    }

}
