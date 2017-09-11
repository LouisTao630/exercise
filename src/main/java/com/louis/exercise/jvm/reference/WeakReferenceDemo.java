package com.louis.exercise.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louis.exercise.jvm.finalize.FinalizationObject;

/**
 * 展示弱引用机制，在GC发生之后就会释放资源。
 * 
 * @author Louis Tao
 *
 */
public class WeakReferenceDemo {

	final static Logger logger = LoggerFactory.getLogger(WeakReferenceDemo.class);

	public static void main(String[] args) throws InterruptedException {

		// 创建模拟的资源
		FinalizationObject test = new FinalizationObject();
		logger.info("创建测试对象：" + test);

		// 使用WeakReference标识模拟资源弱引用
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		WeakReference<Object> reference = new WeakReference<Object>(test, queue);
		logger.info("创建测试引用对象：" + reference);

		// 释放对引用资源的关联，GC可以顺利标记为回收资源
		test = null;
		logger.info("释放测试对象强引用：" + test);

		// 打印模拟资源是否被释放
		logger.info("GC调用之前...");
		logger.info("获取引用对象：" + reference.get());
		logger.info("回收资源队列中的对象：" + queue.poll());

		// 调用GC进行资源回收
		logger.info("GC调用中...");
		System.gc();

		// 等待完成一次GC
		Thread.sleep(300000);

		// 打印模拟资源是否被释放
		logger.info("GC调用之后...");

		logger.info("获取引用对象：" + reference.get());
		logger.info("回收资源队列中的引用对象：" + queue.poll());
	}
}
