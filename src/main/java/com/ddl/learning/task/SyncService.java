package com.ddl.learning.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SyncService {

    @Async
    public void asyncEvent() throws InterruptedException {
        //休眠1s
        Thread.sleep(1000*10);
        log.info("====异步方法输出：{}!", System.currentTimeMillis());
    }

    public void syncEvent() throws InterruptedException {
        Thread.sleep(1000*10);
        log.info("!!!!同步方法输出：{}!", System.currentTimeMillis());
    }

}
