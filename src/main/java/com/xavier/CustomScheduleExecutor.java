package com.xavier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xavier on 2018/1/30.
 */
@Configuration
public class CustomScheduleExecutor {

	@Bean(destroyMethod = "shutdown")
	public ScheduledExecutorService taskScheduler() {
		return new ScheduledThreadPoolExecutor(10, new ThreadFactory() {
			private AtomicInteger count = new AtomicInteger(0);

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r, "customScheduledThread-" + count.incrementAndGet());
			}
		});
	}
}
