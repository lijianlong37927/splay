package com.yumu.tool;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTool {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static RedisTool redisTool;

	private RedisTool() {
	}

	@PostConstruct
	public void init() {
		redisTool = this;
		redisTool.stringRedisTemplate = this.stringRedisTemplate;
	}

	/**
	 * <p>Title: setIfAbsent</p>
	 * <p>Description: 设置key-value（超时秒）</p>
	 * @param key
	 * @param value
	 * @param timeout
	 */
	public static void setIfAbsent(String key, String value, long timeout) {
		redisTool.stringRedisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
	}

	/**
	 * <p>Title: get</p>
	 * <p>Description: 根据key获取value</p>
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return redisTool.stringRedisTemplate.opsForValue().get(key);
	}
}
