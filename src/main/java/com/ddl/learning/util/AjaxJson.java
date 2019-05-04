package com.ddl.learning.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AjaxJson<T> {
    private String code;
    private String msg;
    private T data;
}
