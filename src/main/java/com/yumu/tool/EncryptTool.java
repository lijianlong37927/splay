package com.yumu.tool;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class EncryptTool {

	private EncryptTool() {

	}

	public static String sha1Hex(String value) throws NoSuchAlgorithmException {
		if (StringUtils.isEmpty(value)) {
			return null;
		} else {
			return DigestUtils.sha1Hex(value);
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("[" + sha1Hex("U000001001") + "]");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
