package com.yumu.tool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

public class BeanTool {

	private BeanTool() {
	}

	public static <T, R> List<R> convertList(List<T> list, Class<R> classObj) {
		if (CollectionUtils.isEmpty(list)) {
			return new ArrayList<>(0);
		}
		List<R> result = new ArrayList<>(list.size());
		list.forEach(each -> {
			try {
				R rObj = classObj.newInstance();
				BeanUtils.copyProperties(each, rObj);
				result.add(rObj);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return result;
	}

	public static <T> T convertBean(Object target, Class<T> classObj) {
		try {
			T result = classObj.newInstance();
			BeanUtils.copyProperties(target, result);
			return result;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
