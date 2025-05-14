package com.fernandopaniagua.ifct0062_2025_supergamesspring.logsystem;

import org.springframework.context.event.EventListener;

public class LogManager {

    @EventListener
    public void writeLog(LogEvent event){
        System.err.println(event.getMessage());
    }
}
