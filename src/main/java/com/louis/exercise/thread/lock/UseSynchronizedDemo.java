package com.louis.exercise.thread.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 展示如何用同步关键字来实现线程安全的。
 * 
 * @author Louis Tao
 *
 */
public class UseSynchronizedDemo {

	final static Logger logger = LoggerFactory.getLogger(UseSynchronizedDemo.class);

	private static final int THREAD_COUNT = 10;

	private static final int THREAD_RUN_TIME = 100;

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
	 * 自增函数非线程安全，使用同步字段来确保此函数是原子操作， 只有一个线程可以使test元素自增。
	 */
	public static synchronized void increase() {
		test++;
		logger.info("Test value is {}", test);
	}
}
