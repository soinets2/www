package com.imaeil.util;

import java.util.UUID;

public class Utils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String getSplitExt(String fullName) {
		String[] str = fullName.split("\\.");
		
		return str[str.length-1];
	}
}
