package com.verge.utiliities;

import com.verge.dto.Dto;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class Responses {

    public static <T extends Dto> ResponseEntity<T> ok(T dto) {
        return new ResponseEntity<>(dto, OK);
    }

    public static ResponseEntity notFound() {
        return new ResponseEntity<>(NOT_FOUND);
    }

    public static <T extends Dto> ResponseEntity<T> created(T dto) {
        return new ResponseEntity<>(dto, CREATED);
    }

    public static ResponseEntity badRequest() {
        return new ResponseEntity<>(BAD_REQUEST);
    }
}
