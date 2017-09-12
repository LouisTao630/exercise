package com.louis.exercise.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;

@Configuration
@PropertySource("classpath:/com/louis/exercise/db/redis.properties")
public class RedisConfig {

	@Value("${redis.host}")
	private String host;

	@Bean
	public JedisPool jedisPool() {
		JedisPool pool = new JedisPool(host);
		return pool;
	}
}
