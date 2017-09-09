package com.louis.exercise.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 展示虚引用机制，在GC发生之后就会释放资源。
 * 
 * @author Louis Tao
 *
 */
public class WeakReferenceDemo {

	public static void main(String[] args) throws InterruptedException {

		// 创建模拟的资源
		byte[] testResource = new byte[10240];

		// 使用WeakReference标识模拟资源非强引用
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		WeakReference<Object> reference = new WeakReference<Object>(testResource, queue);

		// 释放对引用资源的关联，GC可以顺利标记为回收资源
		testResource = null;

		// 打印模拟资源是否被释放
		System.out.println("模拟资源的引用地址为：" + reference.get());
		System.out.println("refrence的内存地址：" + reference);
		System.out.println("回收资源队列中的对象：" + queue.poll());

		// 调用GC进行资源回收
		System.gc();

		// 等待一段时间，防止GC没有完成
		Thread.sleep(50);

		// 打印模拟资源是否被释放
		System.out.println("完成GC以后...");

		System.out.println("模拟资源的引用地址为：" + reference.get());
		System.out.println("回收资源队列中的对象：" + queue.poll());

	}
}
