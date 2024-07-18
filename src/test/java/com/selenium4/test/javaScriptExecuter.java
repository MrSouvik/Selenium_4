package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExecuter {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//1. SendKeys in javascriptExecuter
		sendkeys(driver);
		
		//2. click method in javascriptExecuter
		click(driver);
		
		//3. Scrolling the page
		scroll(driver);
		
		//4. conditional scrolling
		conditionalScrool(driver);
		
		//5. scroll Till the end
		scrollTillTheEndAndGoBack(driver);
		
		//6. Zoom out & Zoom in
		zoom(driver);
		
		Thread.sleep(5000);
		driver.quit();
	}

	private static void zoom(WebDriver driver) throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeAsyncScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		js.executeAsyncScript("document.body.style.zoom='80%'");
	}

	private static void scrollTillTheEndAndGoBack(WebDriver driver) throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		//scroll till the end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		//scroll up to the initial position
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
	}

	private static void conditionalScrool(WebDriver driver) {
		//Scroll the page till the element is visible
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement submit = driver.findElement(By.xpath("//input[@id='FSsubmit']"));
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", submit);
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}

	private static void scroll(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}

	private static void click(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement male = driver.findElement(By.xpath("//input[@id='male']"));
		//male.click();
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", male);
		System.err.println("Clicked Sucessfully");
	}

	private static void sendkeys(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		//name.sendKeys("Souvik");
		
		//Alternate of sendkeys method, if we are getting element interceptedExeception then we can use javascriptexecute executer
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','John')", name);
		System.out.println("Value Entered Scucessfully");
	}
}
