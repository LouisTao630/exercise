package com.louis.exercise.nosql.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

	@Autowired
	private JedisPool pool;

	public String getValue(String key) {
		return pool.getResource().get(key);
	}

}
