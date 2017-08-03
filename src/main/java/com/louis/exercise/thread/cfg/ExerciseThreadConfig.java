package com.louis.exercise.thread.cfg;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.louis.exercise.thread.job.DreamJob;
import com.louis.exercise.thread.tool.ThreadStaticAspect;

@Configuration
@EnableAspectJAutoProxy
public class ExerciseThreadConfig {

	@Bean()
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DreamJob dreamJob() {
		DreamJob job = new DreamJob();
		return job;
	}

	@Bean()
	public ThreadStaticAspect threadMonitor() {
		ThreadStaticAspect monitor = new ThreadStaticAspect();
		return monitor;
	}

}
