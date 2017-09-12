package com.louis.exercise.thread.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 展示如何用同步块
 */
public class UseSynBlockDemo {

	final static Logger logger = LoggerFactory.getLogger(UseSynBlockDemo.class);

	private static final int THREAD_COUNT = 10;

	private static final int THREAD_RUN_TIME = 100;

	private static Object lock = new Object();

	// 自增元素
	private static int test = 0;

	public static void main(String[] args) {

		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread t = new Thread(() -> {
				long beginTime = System.currentTimeMillis();
				while ((System.currentTimeMillis() - beginTime) <= THREAD_RUN_TIME) {
					increase();
				}
			});
			t.setName("thread-" + i);
			t.start();
		}
	}

	/**
	 * 自增函数非线程安全，使用同步块保证线程安全
	 */
	public static void increase() {
		synchronized (lock) {
			test++;
			logger.info("Test value is {}", test);
		}
	}
}
