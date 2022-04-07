package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HttpError {
    private String url;
    private String errorCode;
    private String message;
    private LocalDateTime localDateTime;
}
