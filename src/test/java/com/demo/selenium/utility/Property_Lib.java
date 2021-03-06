package com.demo.selenium.utility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Property_Lib {
	public static String getPropertyValue(String filePath, String key) {
		String value = "";
		Properties ppt = new Properties();
		try {
			ppt.load(new FileInputStream(filePath));
			value = ppt.getProperty(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static String setPropertyValue(String filePath, String key) {
		String value = "";
		Properties ppt = new Properties();
		try {
			ppt.load(new FileInputStream(filePath));
			int count = Integer.parseInt(ppt.getProperty(key));

			OutputStream output = null;

			count++;
			String abc = Integer.toString(count);
			output = new FileOutputStream(filePath);

			count++;
			ppt.setProperty("Count", abc);
			ppt.store(output, null);

		} catch (Exception e) {
		}
		return value;
	}
}

