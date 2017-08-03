package com.louis.exercise.thread.job;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试模拟类，主要模拟一个耗时的线程操作
 * 
 * @author taosheng
 *
 */
public class DreamJob implements Callable<Object> {

	private static AtomicInteger count = new AtomicInteger();

	private int id = 0;

	public DreamJob() {
		id = count.getAndIncrement();
	}

	@Override
	public Object call() throws Exception {
		try {
			System.out.println("Make a dream -" + id);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
