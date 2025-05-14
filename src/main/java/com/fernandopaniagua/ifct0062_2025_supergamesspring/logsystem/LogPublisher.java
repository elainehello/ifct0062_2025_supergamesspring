package com.fernandopaniagua.ifct0062_2025_supergamesspring.logsystem;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LogPublisher {
    private final ApplicationEventPublisher publisher;

    public LogPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishLogEvent(String message){
       LogEvent event = new LogEvent(message);
       publisher.publishEvent(event);
    }
}
