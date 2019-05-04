package com.ddl.learning.event;

import org.springframework.context.ApplicationEvent;

/**
 * 编写事件源
 *
 * @author ddl
 */
@SuppressWarnings("serial")
public class CustomEvent extends ApplicationEvent {

    private MessageEntity messageEntity;

    public CustomEvent(Object source, MessageEntity messageEntity) {
        super(source);
        this.messageEntity = messageEntity;
    }

    public MessageEntity getMessageEntity() {
        return this.messageEntity;
    }
}
