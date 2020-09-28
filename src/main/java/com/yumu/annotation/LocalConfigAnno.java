package com.yumu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LocalConfigAnno {
	/**
	 * <p>Title: storeType</p>
	 * <p>Description: 信息存储类型,0:session内存;1:redis</p>
	 * @return
	 */
	String storeType() default "0";

	/**
	 * <p>Title: checkPath</p>
	 * <p>Description: 是否校验请求路径。如果是，则需要数据库配置请求的路径权限</p>
	 * @return
	 */
	String checkPath() default "1";
}
