package com.ddl.learning.exception;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
        public Map<String, Object> handleException(Exception exception) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("msg", exception.getMessage());
            data.put("cause", exception.getCause());
            //data.put("msg", runtimeException.sta);
            return data;
        }

        @ExceptionHandler(value=ExecutionException.class)//上下顺序 有关系没？
        @ResponseBody
        public Map<String, Object> handleExecutionException(ExecutionException exception) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("msg", exception.getMessage());
            data.put("cause", exception.getCause());
            //data.put("msg", runtimeException.sta);
            return data;
        }
}
