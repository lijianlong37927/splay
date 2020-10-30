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

	/** 是否校验请求路径,0:否;1:是*/
	private static String checkPath;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Init LocalConfig begin");
		LocalConfigAnno anno = Application.class.getAnnotation(LocalConfigAnno.class);
		storeType = anno.storeType();
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

	public static boolean isCheckPath() {
		return "1".equals(checkPath);
	}
}
