package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames_iframes {
	/*
	 * 	Syntax of switching in a frame/iframe - driver.switchTo().frame(<id> or <name> or <webelement> or <index>)
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//switching to the frame 1 using webelement
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test_Frame-1");
		
		driver.switchTo().defaultContent(); // switching to main page
		
		// Switching to frame 2 using webelement 
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test_Frame-2");
		
		driver.switchTo().defaultContent(); // switching to main page
		
		// Switching to frame 3 using index
		driver.switchTo().frame(2); //frame index start from 0
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Test_Frame-3");
		
		// switching to inner iframe of frame 3
		driver.switchTo().defaultContent(); // switching to main page
		driver.switchTo().frame(2); //switching to frame 3
		driver.switchTo().frame(0); //switching to iframe of frame 3
		
		driver.findElement(By.xpath("//span[text()='Hi, I am the UI.Vision IDE']")).click();
		driver.findElement(By.xpath("//span[text()='General Web Automation']")).click();
		
		driver.switchTo().defaultContent(); // switching to main page
		
		System.out.println("Completed .............");
		
		Thread.sleep(10000);
		
		driver.quit();
		
		
	}
}
