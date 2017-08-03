package com.louis.exercise.thread.cfg;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.config.java.annotation.Bean;
import org.springframework.config.java.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.louis.exercise.thread.DreamJob;

@Configuration()
public class Config {

	@Bean(scope = BeanDefinition.SCOPE_PROTOTYPE)
	public DreamJob dreamJob() {
		DreamJob job = new DreamJob();
		return job;
	}

}
