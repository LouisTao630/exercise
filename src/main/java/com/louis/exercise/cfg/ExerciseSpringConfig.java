package com.louis.exercise.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.louis.exercise.spring.aop.TestAopExpressionBean;

@Configuration
@ComponentScan(basePackages = { "com.louis.exercise.spring.aop" })
public class ExerciseSpringConfig {

	@Bean
	public TestAopExpressionBean testAopExpressionBean() {
		return new TestAopExpressionBean();
	}

}
