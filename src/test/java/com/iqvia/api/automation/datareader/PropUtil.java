package com.iqvia.api.automation.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public Properties prop;

	public PropUtil() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\iqvia\\api\\automation\\datareader\\config.properties");
			prop.load(ip); // C:\API\IQVIARestAssuredAutomation\src\test\java\com\iqvia\api\automation\datareader\config.properties
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
