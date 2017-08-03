package com.louis.tool.thread;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ThreadMonitor {

	@Pointcut("excution(** *.run())")
	public void monitThread() {
	}

	@Around("monitThread()")
	public void caculateTime(ProceedingJoinPoint jp) {
		long beginTime = System.currentTimeMillis();
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		long time = endTime - beginTime;
		String threadName = Thread.currentThread().getName();
		String methodName = jp.getSignature().getName();
		
		System.out.println(time);
		System.out.println(threadName);
	}

}
