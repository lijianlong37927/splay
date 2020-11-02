package com.yumu.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.yumu.Application;
import com.yumu.annotation.LocalConfigAnno;

@Component
public class LocalConfig implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(LocalConfig.class);

	/** 登录信息存储类型,0:内存;1:redis*/
	private static String storeType;
	public static final String STORETYPE_MEMORY = "MEMORY";
	public static final String STORETYPE_REDIS = "REDIS";

	/** 是否校验请求路径,0:否;1:是*/
	private static String checkPath;
	public static final String CHECKPATH_NOT_CHECK = "NOT_CHECK";
	public static final String CHECKPATH_CHECK = "CHECK";

	@Override
	public void run(String... args) throws Exception {
		logger.info("Init LocalConfig begin");
		LocalConfigAnno anno = Application.class.getAnnotation(LocalConfigAnno.class);
		storeType = anno.storeType();
		checkPath = anno.checkPath();
		logger.info("Init LocalConfig storeType[{}]", storeType);
		logger.info("Init LocalConfig checkPath[{}]", checkPath);
		logger.info("Init LocalConfig end");
	}

	public static String getStoreType() {
		return storeType;
	}

	public static String getCheckPath() {
		return checkPath;
	}

	public static boolean isStoreTypeMemory() {
		return LocalConfig.STORETYPE_MEMORY.equals(storeType);
	}

	public static boolean isCheckPath() {
		return LocalConfig.CHECKPATH_CHECK.equals(checkPath);
	}
}
