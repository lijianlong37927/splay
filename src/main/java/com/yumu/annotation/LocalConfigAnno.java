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
}
