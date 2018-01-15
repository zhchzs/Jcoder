package org.nlpcn.jcoder.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * 得到一个文件的md5
	 *
	 * @param file
	 * @return
	 */
	public synchronized static String getMd5ByFile(File file) {

		if (file.isDirectory()) {
			return MD5Util.md5(file.getName());
		}

		String value = "ERROR";

		try (FileInputStream in = new FileInputStream(file)) {
			value = DigestUtils.md5Hex(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}


	public static String md5(String content) {
		return DigestUtils.md5Hex(content);
	}
}
