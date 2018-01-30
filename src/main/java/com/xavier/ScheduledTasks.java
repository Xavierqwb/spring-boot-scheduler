package com.xavier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xavier on 2018/1/30.
 */
@Component
public class ScheduledTasks {

	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 500)
	public void reportCurrentTime() {
		logger.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Scheduled(initialDelay = 5000, fixedDelay = 1000)
	public void reportAgain() {
		logger.info("Current time: {}", dateFormat.format(new Date()));
	}
}
