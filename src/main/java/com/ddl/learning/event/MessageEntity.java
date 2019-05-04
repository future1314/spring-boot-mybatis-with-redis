package com.ddl.learning.event;

import lombok.*;

/**
 * 消息实体类
 *
 * @author oKong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

    String message;

    String code;
}
