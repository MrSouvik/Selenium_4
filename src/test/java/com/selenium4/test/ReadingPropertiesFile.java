package com.selenium4.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
	public static void main(String[] args) throws IOException {
		//location of the properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\config.properties");
		
		//Reading properties file
		Properties prop = new Properties();
		prop.load(fis);
		
		//Reading data from properties file 
		String url = prop.getProperty("appurl");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String customerid = prop.getProperty("customerid");
		
		System.out.println(url);
		System.out.println(email);
		System.out.println(password);
		System.out.println(customerid);
		
		
		//Reading all the keys
		Set<String> keys = prop.stringPropertyNames();
		System.out.println(keys);
		
		//reading all the values from the file
		
		Collection<Object> values = prop.values();
		System.out.println(values);
		fis.close();
		
	}
}
