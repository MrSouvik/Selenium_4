package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class svgElement_handle {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("admin123");
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]"));
		loginBtn.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']")).click();
		System.out.println("SVG element clicked");
		driver.quit();
	}
}
