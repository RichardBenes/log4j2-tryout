package com.rbenes.log4j2tryout;

import java.util.ArrayList;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.layout.PatternLayout;

import lombok.Getter;

public class InMemAppender extends AbstractAppender {

    @Getter
    ArrayList<LogEvent> logEvents;

    @Getter
    ArrayList<String> messages;

    public InMemAppender(String name) {

        var filter = new AbstractFilter() {};
        var layout = PatternLayout.createDefaultLayout();
        var ignoreExceptions = false;
        var properties = Property.EMPTY_ARRAY;

        super(name, filter, layout, ignoreExceptions, properties);

        logEvents = new ArrayList<>();
        messages = new ArrayList<>();
    }

    @Override
    public void append(LogEvent event) {
        
        logEvents.add(event);
        messages.add(event.getMessage().getFormattedMessage());
    }    
}
