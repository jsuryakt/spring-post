package com.jsuryakt.postservice.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private final HttpStatus httpStatus;
    private final String message;
    private final Object payload;

    public Response(HttpStatus httpStatus, String message, Object payload) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.payload = payload;
    }
}
