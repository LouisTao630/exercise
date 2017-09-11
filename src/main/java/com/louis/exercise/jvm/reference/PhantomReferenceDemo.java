package com.louis.exercise.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louis.exercise.jvm.finalize.FinalizationObject;

/**
 * 展示虚引用的机制，虚引用机制
 * 
 * @author Louis Tao
 *
 */
public class PhantomReferenceDemo {

	final static Logger logger = LoggerFactory.getLogger(PhantomReferenceDemo.class);

	public static void main(String[] args) throws InterruptedException {

		// 创建模拟的资源
		FinalizationObject test = new FinalizationObject();

		// 创建虚引用
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		PhantomReference<Object> reference = new PhantomReference<Object>(test, queue);

		// 释放对引用资源的关联，GC可以顺利标记为回收资源
		test = null;

		logger.info("GC调用之前...");
		logger.info("获取引用对象（虚引用无论何时获得的对象都是为空）：{}", reference.get());
		logger.info("回收资源队列中的对象：{}", queue.poll());

		// 调用GC进行资源回收
		logger.info("GC调用中...");
		System.gc();

		// 等待完成一次GC
		Thread.sleep(5000);

		logger.info("GC调用之后...");
		logger.info("获取引用对象（虚引用无论何时获得的对象都是为空）：{}", reference.get());
		logger.info("回收资源队列中的对象：{}", queue.poll());

	}
}
