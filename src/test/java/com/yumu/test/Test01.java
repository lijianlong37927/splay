package com.yumu.test;

import java.util.HashSet;
import java.util.Set;

public class Test01 {

	public static void main(String[] args) {
		Set<String> ALLOWED_PATHS = new HashSet<String>();
		ALLOWED_PATHS.add("/");
		ALLOWED_PATHS.add("/login");
		boolean a = ALLOWED_PATHS.contains("/home");
		System.out.print(a);
	}

}
