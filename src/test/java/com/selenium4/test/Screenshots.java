package com.selenium4.test;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//1. Full Page screenshots
		fullPageScreenshots(driver);
		
		//2. Specific area of the page
		specificAreaOfThePageAcreenshots(driver);
		
		//3. Web Element screenshots
		webElementScreenshots(driver);
		
		driver.quit();
	}

	private static void webElementScreenshots(WebDriver driver) {
		driver.get("https://demo.nopcommerce.com/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\fullPage.png");
		sourceFile.renameTo(targetFile);
		//will search previous screenshot method
	}

	private static void specificAreaOfThePageAcreenshots(WebDriver driver) {
		driver.get("https://demo.nopcommerce.com/");
		WebElement area = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sourceFile = area.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\area.png");
		sourceFile.renameTo(targetFile);
	}

	private static void fullPageScreenshots(WebDriver driver) {
		driver.get("https://demo.nopcommerce.com/");
		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']"));
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\logo.png");
		sourceFile.renameTo(targetFile);
	}
}
