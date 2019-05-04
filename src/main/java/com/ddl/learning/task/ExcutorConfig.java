package com.ddl.learning.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;
@Configuration
public class ExcutorConfig {
        /**
         * 配置线程池
         * @return
         */
        @Bean(name = "asyncPoolTaskExecutor")
        public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(20);
            taskExecutor.setMaxPoolSize(200);
            taskExecutor.setQueueCapacity(25);
            taskExecutor.setKeepAliveSeconds(200);
            taskExecutor.setThreadNamePrefix("oKong-");
            // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
            taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            taskExecutor.initialize();
            return taskExecutor;
    }
}
