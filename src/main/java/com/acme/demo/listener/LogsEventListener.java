package com.acme.demo.listener;

import com.acme.demo.events.LogsEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogsEventListener {

    @EventListener(condition = "#logsEvent.message == 'hello world!!'")
    public void handlerLogsCompletedEvents(LogsEvent logsEvent) {
        log.info("Event successfully registered with next message: {}", logsEvent.getMessage());
    }
}
