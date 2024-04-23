package com.selenium4.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WebDriverMethod2 {
	public static void main(String[] args) throws InterruptedException {
		
		
//		threadDotSleep(driver);
//		implicitWait();
//		explicitWait();
		fluentWait();
		
		/*
		 * Wait commands
		 * 1) Implicit wait
		 * 2) Explicit wait / Fluent wait
		 * 
		 * 	Thread.sleep(1000) - it a java method, not webdriver method
		 * 
		 *  NoSuchElementException - locator is correct, but there is sync problem
		 *  ElementNotFoundException - when locator is incorrect
		 */
		}
	
	static void threadDotSleep() throws InterruptedException {
		WebDriver driver  = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);   //pause the execution
		
		/*
		 * *Advantage of thread.sleep - 
		 * --------------------------
		 * 1)easy to use
		 * 
		 * *Disadvantage of thtead.sleep -
		 * ---------------------------- 
		 * 1) if the time is not sufficient then it will throw exception.
		 * 2) it will wait for maximum time out. then it will reduce performance script.
		 * 3) when ever you are getting sync problem you have to use multiple time 
		 */
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.close();
	
	}
	static void implicitWait() {
		WebDriver driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
		/*
		 * 
		 * Advantages
		 * ------------
		 * 1) Single time/one statement - only need to specify one time
		 * 2) it will not wait for maximum time if element is available
		 * 3) Applicable for all the element
		 * 4) Easy to use
		 * 
		 * Disadvantage
		 * -------------
		 * 1) if the time is not sufficient then there might be a chance of getting exception
		 *   
		 */
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.close();
	}
	
	static void explicitWait() {
		WebDriver driver  = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		/*
		 *  Explicit wait - there are 2 steps
		 *  1) Declaration 2) use
		 * 
		 * Advantages/Disadvantages-
		 * -----------
		 * 1) Conditional based, it will work more effectively
		 * 2) Finding element is inclusive (for some element)
		 * 3) it will wait for condition to be true, then consider the timer
		 * 4) We need to write multiple statement for multiple element
		 */
		
		//declaration of explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Use
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		password.sendKeys("admin123");
		
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()=\"Login\"]")));
		loginBtn.click();
		
		driver.close();
	}
	
	static void fluentWait() {
		WebDriver driver  = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		/*
		 *  Fluent wait - there are 2 steps
		 *  1) Declaration 2) use
		 * 
		 * Advantages/Disadvantages-
		 * -----------
		 * 
		 */
		driver.findElement(By.xpath("//span[normalize-space()=\"Checkout\"]"));
		//FluentWait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(30))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);
		
		//Use
		WebElement username = mywait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
			}
		});
		
		username.sendKeys("Admin");
		driver.close();
	}
}
