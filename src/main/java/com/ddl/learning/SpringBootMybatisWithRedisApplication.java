package com.ddl.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Slf4j
@EnableAsync//开启异步任务
public class SpringBootMybatisWithRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisWithRedisApplication.class, args);
        log.info("程序启动打印日志... ... ");
    }
}
