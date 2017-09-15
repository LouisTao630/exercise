package com.louis.exercise.db;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.louis.exercise.cfg.DBConfig;
import com.louis.exercise.cfg.MyBatisConfig;
import com.louis.exercise.db.dao.User;
import com.louis.exercise.db.dao.UserFactory;

public class ExerciseRunner {

	private static ApplicationContext c = new AnnotationConfigApplicationContext(DBConfig.class, MyBatisConfig.class);

	public static void main(String[] args) throws ParseException {

		UserService us = (UserService) c.getBean("userService");
		UserFactory factory = c.getBean(UserFactory.class);
		
		// Insert 100000 simulator users
		for (int i = 0; i < 100000; i++) {
			User test = factory.simulateUser();
			us.addUser(test);
		}
	}

}
