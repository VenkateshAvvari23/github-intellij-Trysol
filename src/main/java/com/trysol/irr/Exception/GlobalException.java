package com.trysol.irr.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(InvalidCredentialsException ex, HttpServletRequest request) {

        String requestUrl = request.getRequestURI();

        System.out.println(requestUrl);

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 401,requestUrl);

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    }



