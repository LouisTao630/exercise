package com.louis.exercise.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louis.exercise.jvm.finalize.FinalizationObject;

/**
 * 展示软引用的机制，当内存不够时才释放资源
 * 
 * @author Louis Tao
 *
 */
public class SoftReferenceDemo {

	final static Logger logger = LoggerFactory.getLogger(SoftReferenceDemo.class);

	public static void main(String[] args) throws InterruptedException {
		// 创建模拟的资源
		FinalizationObject test = new FinalizationObject();
		logger.info("创建测试对象：" + test);

		// 创建软引用
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		SoftReference<Object> reference = new SoftReference<Object>(test, queue);

		// 释放对引用资源的关联，GC可以顺利标记为回收资源
		test = null;
		logger.info("释放测试对象强引用(object==null)。");

		// 打印模拟资源是否被释放
		logger.info("GC调用之前...");
		logger.info("获取引用对象：" + reference.get());
		logger.info("回收资源队列中的对象：" + queue.poll());

		// 调用GC进行资源回收
		logger.info("GC调用中...");
		System.gc();

		// 等待完成一次GC
		Thread.sleep(3000);

		logger.info("（测试对象没有被调用Finalize方法，说明没有被GC回收）");

		// 打印模拟资源是否被释放
		logger.info("GC调用之后...");

		logger.info("获取引用对象(软引用只有在内存不够的情况下才会回收对象)：" + reference.get());
		logger.info("回收资源队列中的引用对象：" + queue.poll());
	}
}
