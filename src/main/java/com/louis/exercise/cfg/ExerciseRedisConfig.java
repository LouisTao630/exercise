package com.louis.exercise.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:/com/louis/exercise/db/redis.properties")
public class ExerciseRedisConfig {

	@Value("${redis.host}")
	private String host;

	@Value("${redis.password}")
	private String password;

	@Value("${redis.db.index}")
	private int index;

	@Bean
	public JedisPool jedisPool() {
		JedisPool pool = new JedisPool(host);
		return pool;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolConfig) {

		JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
		factory.setHostName(host);
		factory.setPassword(password);
		factory.setDatabase(index);
		return factory;
	}

	@Bean
	public JedisPoolConfig poolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		return poolConfig;
	}

	@Bean
	@Scope("prototype")
	public Jedis jedis(JedisConnectionFactory factory) {
		Jedis jedis = (Jedis) factory.getConnection().getNativeConnection();
		return jedis;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(factory);
		return template;
	}

}
