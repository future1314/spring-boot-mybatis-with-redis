package com.ddl.learning.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

        @ExceptionHandler(value=RuntimeException.class)
        @ResponseBody
        public Map<String, String> handleRunException(RuntimeException runtimeException) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("msg", runtimeException.getMessage());
            return data;
        }

        @ExceptionHandler(value=Exception.class)//上下顺序 有关系没？
        @ResponseBody
        public Map<String, String> handleException(Exception exception) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("msg", exception.getMessage());
            //data.put("msg", runtimeException.sta);
            return data;
        }
}
