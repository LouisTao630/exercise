package com.louis.exercise.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 展示软引用的机制，当内存不够时才释放资源
 * 
 * @author Louis Tao
 *
 */
public class SoftReferenceDemo {

	public static void main(String[] args) {

		// 创建模拟的资源
		byte[] testResource = new byte[10240];

		// 使用WeakReference标识模拟资源非强引用
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		SoftReference<Object> reference = new SoftReference<Object>(testResource, queue);

		// 释放对引用资源的关联，GC可以顺利标记为回收资源
		testResource = null;

		// 打印模拟资源是否被释放
		System.out.println("模拟资源的引用地址为：" + reference.get());
		System.out.println("refrence的内存地址：" + reference);
		System.out.println("回收资源队列中的对象：" + queue.poll());

	}
}
