package com.springBootLearning.spring_boot_0_1.Exception;


import com.springBootLearning.spring_boot_0_1.Dto.ApiError;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptions {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundExceptions(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder().error(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleError(Exception ex){
        ApiError apiError = ApiError.builder().error(ex.getMessage()).httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationExceptions(AuthenticationException exception){
        ApiError apiError = ApiError.builder().error(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiError,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtExceptions(JwtException exception){
        ApiError apiError = ApiError.builder().error(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiError,HttpStatus.UNAUTHORIZED);
    }


}
