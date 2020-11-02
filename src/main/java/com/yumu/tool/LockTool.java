package com.yumu.tool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.yumu.init.LocalConfig;

public class LockTool {

	private static final ConcurrentMap<String, Lock> keyLockMap = new ConcurrentHashMap<>();

	/**
	 * <p>Title: lock</p>
	 * <p>Description: 对key值加锁</p>
	 * @param key
	 */
	public static void lock(String key) {
		if (LocalConfig.isStoreTypeMemory()) {
			lockByMemory(key);
		} else {
			lockByRedis(key);
		}
	}

	/**
	 * <p>Title: unlock</p>
	 * <p>Description: 对key释放锁</p>
	 * @param key
	 */
	public static void unlock(String key) {
		if (LocalConfig.isStoreTypeMemory()) {
			unLockByMemory(key);
		} else {
			unLockByRedis(key);
		}
	}

	private static void lockByMemory(String key) {
		Lock keyLock = keyLockMap.get(key);
		if (keyLock == null) {
			keyLock = keyLockMap.putIfAbsent(key, new ReentrantLock());
		}
		keyLock.lock();
	}

	private static void lockByRedis(String key) {
		boolean getLockFlag = false;
		while (!getLockFlag) {
			getLockFlag = RedisTool.setIfAbsent(key, String.valueOf(System.currentTimeMillis()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void unLockByMemory(String key) {
		Lock keyLock = keyLockMap.get(key);
		if (keyLock != null) {
			keyLock.unlock();
		}
		keyLockMap.remove(key);
	}

	private static void unLockByRedis(String key) {
		if (key != null) {
			RedisTool.delete(key);
		}
	}
}
