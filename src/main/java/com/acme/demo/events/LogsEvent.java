package com.acme.demo.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LogsEvent extends ApplicationEvent {

    private final String message;

    public LogsEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
