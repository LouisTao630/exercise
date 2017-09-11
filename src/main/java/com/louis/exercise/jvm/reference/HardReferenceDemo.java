package com.louis.exercise.jvm.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louis.exercise.jvm.finalize.FinalizationObject;

/**
 * 展示强引用的机制，不会被GC释放引用
 * 
 * @author Louis Tao
 *
 */
public class HardReferenceDemo {

	final static Logger logger = LoggerFactory.getLogger(HardReferenceDemo.class);

	public static void main(String[] args) throws InterruptedException {

		// 创建模拟的资源
		FinalizationObject test = new FinalizationObject();

		// 打印模拟资源是否被释放
		logger.info("模拟资源的引用地址为：{}", test);

		// 调用GC进行资源回收
		System.gc();

		// 等待一段时间，防止GC没有完成
		Thread.sleep(3000);

		logger.info("完成GC以后...");

		// 打印模拟资源是否被释放
		logger.info("模拟资源的引用地址为：" + test);
	}

}
