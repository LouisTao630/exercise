package com.louis.exercise.jvm.reference;

/**
 * 展示强引用的机制，不会被GC释放引用
 * 
 * @author Louis Tao
 *
 */
public class HardReferenceDemo {

	public static void main(String[] args) throws InterruptedException {

		// 创建模拟的资源
		byte[] testResource = new byte[10240];

		// 打印模拟资源是否被释放
		System.out.println("模拟资源的引用地址为：" + testResource);

		// 调用GC进行资源回收
		System.gc();

		// 等待一段时间，防止GC没有完成
		Thread.sleep(50);

		System.out.println("完成GC以后...");

		// 打印模拟资源是否被释放
		System.out.println("模拟资源的引用地址为：" + testResource);
	}

}
