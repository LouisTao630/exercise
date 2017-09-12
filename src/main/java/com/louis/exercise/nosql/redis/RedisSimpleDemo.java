package com.louis.exercise.nosql.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.louis.exercise.cfg.BaseConfig;

public class RedisSimpleDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
		RedisService service = (RedisService) context.getBean("redisService");
		service.getValue("first_word");
		context.close();
	}

}
