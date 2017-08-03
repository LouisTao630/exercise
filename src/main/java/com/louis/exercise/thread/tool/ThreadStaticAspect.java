package com.louis.exercise.thread.tool;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ThreadStaticAspect {

	@Pointcut("execution(public * call())")
	public void monitThread() {
	}

	@Around("monitThread()")
	public void statics(ProceedingJoinPoint jp) {
		long beginTime = System.currentTimeMillis();
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		System.out.println(String.format("threadName=%s,beginTime=%d,endTime=%d,expiredTime=%d", Thread.currentThread().getName(), beginTime, endTime, endTime - beginTime));	}

}
