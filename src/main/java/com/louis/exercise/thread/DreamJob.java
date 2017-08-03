package com.louis.exercise.thread;

import java.util.concurrent.Callable;

/**
 * 测试模拟类，主要模拟一个耗时的线程操作
 * 
 * @author taosheng
 *
 */
public class DreamJob implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
