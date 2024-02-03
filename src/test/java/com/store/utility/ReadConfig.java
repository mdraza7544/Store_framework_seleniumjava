package com.store.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path = "C:\\Users\\Lenovo\\Desktop\\Store\\Store\\configuration\\config.properties";

	public ReadConfig() {

		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream(path);
			properties.load(file);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	//this method access config file and get base URL
	public String getBaseUrl() {
		String baseUrl = properties.getProperty("baseUrl");
		if(baseUrl!=null)
			return baseUrl;
		else 
			throw new RuntimeException("URL not declare in config file");
	}
	//this method access config file and get browser
	public String getBrowser() {
		String browser = properties.getProperty("Browser");
		if(browser!=null) 
			return browser;
		else 
			throw new RuntimeException("URL not declare in config file");
	}

}
