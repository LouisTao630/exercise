package com.louis.exercise.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.config.java.context.JavaConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class ThreadPoolExercise {

	public static void main(String[] args) {

		ApplicationContext c = new JavaConfigApplicationContext("com.louis.exercise.thread");
		//
		ExecutorService s = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			Callable call = (Callable) c.getBean("DreamJob");
			s.submit(call);
		}
		s.shutdown();
		try {
			s.awaitTermination(20, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
