package com.springBootLearning.spring_boot_0_1.Exception;


import com.springBootLearning.spring_boot_0_1.Dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptions {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundExceptions(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder().error(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
