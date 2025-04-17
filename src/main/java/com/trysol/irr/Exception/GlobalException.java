package com.trysol.irr.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(InvalidCredentialsException ex, HttpServletRequest request) {

        String requestUrl = request.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(401);
        errorResponse.setError("Unauthorized");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(requestUrl);

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
     }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex, HttpServletRequest request) {

        String requestUrl = request.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(409);
        errorResponse.setError("Conflict");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(requestUrl);

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse>handleIllegalArgumentException(IllegalArgumentException ex,HttpServletRequest request){

        String requestUrl = request.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();
      //  errorResponse.setStatus(400);
        errorResponse.setError("BadRequest");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(requestUrl);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(UserNotFound ex, HttpServletRequest request) {

        String requestUrl = request.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(requestUrl);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    }



