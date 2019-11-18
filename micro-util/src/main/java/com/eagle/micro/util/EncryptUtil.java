package com.eagle.micro.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
public class EncryptUtil {

	public static final String ENCODING = "UTF-8";

	public static String base64Encode(String msg) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(msg.getBytes(ENCODING)));
	}

	public static String base64Decode(String msg) throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64(msg.getBytes(ENCODING)));
	}

	public static String md5Encode(String msg) {
		return DigestUtils.md5Hex(msg);
	}

}
