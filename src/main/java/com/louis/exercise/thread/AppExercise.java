package com.louis.exercise.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.louis.exercise.cfg.ExerciseThreadConfig;

public class AppExercise {

	// Test job count
	private static final int TEST_HOB_COUNT = 1000;

	private static final String JOB_BEAN = "dreamJob";

	// Load spring context
	private static ApplicationContext c = new AnnotationConfigApplicationContext(ExerciseThreadConfig.class);

	public static void main(String[] args) {

		ExecutorService s = Executors.newCachedThreadPool();
		for (int i = 0; i < TEST_HOB_COUNT; i++) {
			Callable call = (Callable) c.getBean(JOB_BEAN);
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
