package com.ddl.learning.controller;

import com.ddl.learning.task.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    SyncService syncService;

    @GetMapping("/async")
    public String doAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        //调用同步方法
        syncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法用时：{}", syncTime - start);
        //调用异步方法
        syncService.asyncEvent2();
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", asyncTime - syncTime);
        log.info("方法执行完成：{}!",asyncTime);
        return "async!!!";
    }

    @GetMapping("/async3")
    public String doAsync3() throws InterruptedException,ExecutionException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        //调用同步方法
        syncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法用时：{}", syncTime - start);
        //调用异步方法
        Future<String> doFutrue = syncService.asyncEvent3();
        while(true) {
            //判断异步任务是否完成
            if(doFutrue.isDone()) {
                log.info("异步线程已经执行完 ... {}",doFutrue.get());
                break;
            }
            log.info("异步线程没执行完，休息一会 ... ",System.currentTimeMillis());
            Thread.sleep(100);
        }
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", asyncTime - syncTime);
        log.info("方法执行完成：{}!",asyncTime);
        return "async!!!";
    }
}
