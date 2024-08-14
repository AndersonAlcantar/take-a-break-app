package com.acme.demo.service;

import com.acme.demo.events.LogsEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ReturnInputMessage {
    private final ApplicationEventPublisher applicationEventPublisher;

    public ReturnInputMessage(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String printLog(String message) {
        LogsEvent logsEvent = new LogsEvent(this, message);
        applicationEventPublisher.publishEvent(logsEvent);
        return message;
    }
}
