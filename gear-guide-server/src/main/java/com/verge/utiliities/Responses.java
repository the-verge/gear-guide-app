package com.verge.utiliities;

import com.verge.dto.Dto;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class Responses {

    public static <T extends Dto> ResponseEntity<T> ok(T dto) {
        return ResponseEntity
                .status(OK)
                .body(dto);
    }

    public static ResponseEntity notFound() {
        return ResponseEntity
                .status(NOT_FOUND)
                .build();
    }

    public static <T extends Dto> ResponseEntity<T> created(T dto) {
        return ResponseEntity
                .status(CREATED)
                .body(dto);
    }

    public static ResponseEntity badRequest() {
        return ResponseEntity
                .status(BAD_REQUEST)
                .build();
    }
}
