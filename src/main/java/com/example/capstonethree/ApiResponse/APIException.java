package com.example.capstonethree.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class APIException extends RuntimeException {
    public APIException(String message){
        super(message);
    }
}
