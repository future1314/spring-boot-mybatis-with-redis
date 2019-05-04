package com.ddl.learning.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class SyncService {

    @Async
    public void asyncEvent() throws InterruptedException {
        //休眠1s
        Thread.sleep(1000*10);
        log.info(Thread.currentThread().getName() +"====异步方法输出：{}!", System.currentTimeMillis());
    }

    @Async(value = "asyncPoolTaskExecutor")
    public void asyncEvent2() throws InterruptedException {
        //休眠1s
        Thread.sleep(1000*1);
        log.info(Thread.currentThread().getName() +"====异步方法输出：{}!", System.currentTimeMillis());
    }

    @Async(value = "asyncPoolTaskExecutor")
    public Future asyncEvent3() throws InterruptedException {
        //休眠1s
        Thread.sleep(1000*1);
        log.info(Thread.currentThread().getName() +"====异步方法输出：{}!", System.currentTimeMillis());
        return new AsyncResult("异步返回结果");
    }

    public void syncEvent() throws InterruptedException {
        Thread.sleep(1000*1);//SimpleAsyncTaskExecutor
        log.info(Thread.currentThread().getName() +"!!!!同步方法输出：{}!", System.currentTimeMillis());
    }

}
