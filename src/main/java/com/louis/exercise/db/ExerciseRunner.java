package com.louis.exercise.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.louis.exercise.cfg.DBConfig;
import com.louis.exercise.cfg.MyBatisConfig;

public class ExerciseRunner {

	private static ApplicationContext c = new AnnotationConfigApplicationContext(DBConfig.class, MyBatisConfig.class);

	public static void main(String[] args) {

		UserService us = (UserService) c.getBean("userService");
		us.getUsers();
	}

}
