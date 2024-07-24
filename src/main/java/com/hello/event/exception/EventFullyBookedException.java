package com.hello.event.exception;

import org.aspectj.bridge.IMessage;

public class EventFullyBookedException extends RuntimeException {
    public EventFullyBookedException(String message) {
        super(message);
    }
}
