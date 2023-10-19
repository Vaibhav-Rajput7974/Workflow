package com.example.Workflows.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
public class ResponseEntity<T> {
    private String message;
    private T data;
    private HttpStatus status;

}
