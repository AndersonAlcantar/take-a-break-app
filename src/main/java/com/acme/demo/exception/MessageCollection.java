package com.acme.demo.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum MessageCollection {
    SAVE_SUCCESS("Success saving new customer"),
    SERVER_ERROR("Connection error with data base server");

    private final String message;

    MessageCollection(String message) {
        this.message = message;
    }
}
