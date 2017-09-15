package com.louis.exercise.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.louis.exercise.cfg.BaseConfig;
import com.louis.exercise.cfg.ExerciseSpringConfig;

public class AopExepriseDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class, ExerciseSpringConfig.class);

		TestAopExpressionBean method = context.getBean(TestAopExpressionBean.class);

		method.methodWithoutModifier();

		method.methodWithPublic();

		method.methodWithProtected();

		context.close();
	}

}
