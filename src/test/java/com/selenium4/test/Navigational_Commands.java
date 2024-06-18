package com.selenium4.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigational_Commands {
	/*
	 * 	Navigational Commands
	 * ----------------------
	 * 1) navigate().to();
	 * 2) navigate().back();
	 * 3) navigate().forward();
	 * 4) navigate().refresh();
	 *  
	 */
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		
		// driver.get() - this method accepts URL in string format
		driver.get("https://demo.nopcommerce.com/"); 
		
		// 1) navigate().to() - this method accepts URL in the string format & URL object format 
		
		// Approach - 1 (String format)
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		// Approach - 2 (URL object format)
		URL myUrl = new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(myUrl);
		
		// 2) navigate().back()
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().back();
		System.out.println("Back - "+driver.getCurrentUrl());
		
		// 3) navigate().forward()
		
		driver.navigate().forward();
		System.out.println("Forward - "+driver.getCurrentUrl());
		
		// 4) navigate().refresh() - used to reload the page
		
		driver.navigate().refresh();
		
		driver.close();
		
		
	}
}
