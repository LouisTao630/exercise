package com.louis.exercise.jvm.finalize;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 演示finalize调用的时机
 * 
 * @author taosheng
 *
 */
public class FinalizationDemo {

	public static void main(String[] args) throws IllegalArgumentException, InterruptedException {

		// 创建测试对象
		FinalizationObject test = new FinalizationObject();
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		PhantomReference<FinalizationObject> reference = new PhantomReference<FinalizationObject>(test, queue);

		System.out.println(reference.isEnqueued());
		// 调用GC, 此时不符合GC条件，不会触发finalize函数
		System.gc();
		System.out.println("GC没有回收对象，不满足GC条件。");
		System.out.println(reference.isEnqueued());
		System.out.println(reference.isEnqueued());

		test = null;

		System.gc();
		System.out.println(reference.isEnqueued());
		Thread.currentThread().sleep(10000);
		System.out.println(reference.isEnqueued());
	}
}
