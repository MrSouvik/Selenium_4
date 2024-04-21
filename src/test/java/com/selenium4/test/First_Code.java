package com.selenium4.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * Testcase->
 * -------------
 * 1. launch browser (chrome)
 * 2. Open url - https://demo.opencart.com/
 * 3. validate title should be "Your Store"
 * 4. close browser
 */
public class First_Code {
	
	public static void main(String[] args) {
		//1. launch browser (chrome)
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
        //WebDriver driver = new InternetExplorerDriver();
		//2. Open url - https://demo.opencart.com/
		driver.get("https://demo.opencart.com/");
		
		//3. validate title should be "Your Store"
		
		String actualTitle = driver.getTitle();
		if(actualTitle.equals("Your Store")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Pass");
		}
		
		// 4. close browser
		
		driver.close();
	}
}
