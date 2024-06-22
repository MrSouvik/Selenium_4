package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication_popup {
	public static void main(String[] args) {
		
		/*
		 * For Authentication popup we have use below url syntax. we have to pass username and password along with user name
		 * URL - https://the-internet.herokuapp.com/basic_auth
		 * USERNAME - admin
		 * PASSWORD - admin 
		 * Syntax  -  https://<username>:<password>@the-internet.herokuapp.com/basic_auth
		 * 
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		String loginText  = driver.findElement(By.xpath("//p")).getText();
		System.out.println(loginText);
		driver.quit();
	}
}
