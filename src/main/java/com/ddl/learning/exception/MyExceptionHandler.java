package com.ddl.learning.exception;

import com.alibaba.fastjson.JSONObject;
import com.ddl.learning.util.Constants;
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
        public String handleRunException(RuntimeException runtimeException) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("msg", runtimeException.getMessage());
            data.put("code", Constants.failCode);
            //data.put("cause", runtimeException.getCause());//获取不到吗？
            return JSONObject.toJSONString(data);
        }

        @ExceptionHandler(value=Exception.class)//上下顺序 有关系没？
        @ResponseBody
        public String handleException(Exception exception) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("msg", exception.getMessage());
            data.put("code", Constants.failCode);
            //data.put("cause", exception.getCause());//获取不到吗？
            return JSONObject.toJSONString(data);
        }

        @ExceptionHandler(value=ExecutionException.class)//上下顺序 有关系没？
        @ResponseBody
        public String handleExecutionException(ExecutionException exception) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("msg", exception.getMessage());
            data.put("code", Constants.failCode);
            //data.put("cause", exception.getCause());
            return JSONObject.toJSONString(data);
        }//
}
