package com.fernandopaniagua.ifct0062_2025_supergamesspring.logsystem;

/**
 * Es un evento del sistema- POJO
 *  "Plain Old Java Object"
 */

public class LogEvent {
    private String message;

    public LogEvent(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
