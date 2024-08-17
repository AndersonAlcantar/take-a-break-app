package com.acme.demo.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface ExceptionMessage {
    Logger LOG = LoggerFactory.getLogger(ExceptionMessage.class);

    default ResponseEntity<?> successMessage() {
        var message = MessageCollection.SAVE_SUCCESS.getMessage();
        LOG.info("message={}", message);
        return ResponseEntity.ok(message);
    }

    default ResponseEntity<?> exceptionDBServer() {
        var message = MessageCollection.SERVER_ERROR.getMessage();
        LOG.info("exception={}", message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}
