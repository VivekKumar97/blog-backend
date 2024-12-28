package com.bloggingbackend.blog_api.utils;

import com.bloggingbackend.blog_api.exception.BlogException;
import com.bloggingbackend.blog_api.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BlogException.class)
    public ResponseEntity<ApiResponse> resourceNotFound(BlogException exception){
        ApiResponse apiResponse= new ApiResponse(exception.getMessage(), false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
