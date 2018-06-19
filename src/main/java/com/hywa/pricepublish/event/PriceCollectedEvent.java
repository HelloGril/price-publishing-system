package com.hywa.pricepublish.event;

import org.springframework.context.ApplicationEvent;

public class PriceCollectedEvent extends ApplicationEvent {
    public PriceCollectedEvent(Object source) {
        super(source);
    }
}
