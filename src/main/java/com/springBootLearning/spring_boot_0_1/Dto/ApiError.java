package com.springBootLearning.spring_boot_0_1.Dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {

    private LocalDateTime localDateTime;
    private String error;
    private HttpStatus httpStatus;
}
