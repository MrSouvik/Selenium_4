package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_Popups {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// 1) Normal alert with ok button
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(5000);
		alert.accept();
		String resultAfterPerformAlertAction = driver.findElement(By.xpath("//h4[text()='Result:']/following-sibling::p")).getText();
		System.out.println("Result after clicking on alert - "+resultAfterPerformAlertAction);
		
//		2) confirmation alert - ok & cancel 
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		text = alert.getText();
		System.out.println(text);
		Thread.sleep(5000);
		alert.accept();
		resultAfterPerformAlertAction = driver.findElement(By.xpath("//h4[text()='Result:']/following-sibling::p")).getText();
		System.out.println("Result after clicking on OK - "+resultAfterPerformAlertAction);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		text = alert.getText();
		System.out.println(text);
		Thread.sleep(5000);
		alert.dismiss();
		resultAfterPerformAlertAction = driver.findElement(By.xpath("//h4[text()='Result:']/following-sibling::p")).getText();
		System.out.println("Result after clicking on Cancel - "+resultAfterPerformAlertAction);
		
//		3) Prompt alert - input box
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert = driver.switchTo().alert();
		text = alert.getText();
		System.out.println(text);
		alert.sendKeys("Test by Souvik");
		Thread.sleep(5000);
		alert.accept();
		resultAfterPerformAlertAction = driver.findElement(By.xpath("//h4[text()='Result:']/following-sibling::p")).getText();
		System.out.println("Result after entering & clicking on OK - "+resultAfterPerformAlertAction);
		
		//Handling alert without using switchTo().alert
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		text = alert.getText();
		System.out.println(text);
		Thread.sleep(5000);
		alert.accept();
		resultAfterPerformAlertAction = driver.findElement(By.xpath("//h4[text()='Result:']/following-sibling::p")).getText();
		System.out.println("Result after clicking on alert - "+resultAfterPerformAlertAction);
		
		driver.quit();

		
		
		
		
		
	}
}
