package com.wooyoo.learning.exception;

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

        @ExceptionHandler(value=Exception.class)
        @ResponseBody
        public Map<String, String> handleException(RuntimeException runtimeException) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("msg", runtimeException.getMessage());
            //data.put("msg", runtimeException.sta);
            return data;
        }
}
