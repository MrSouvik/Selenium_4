package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//1. Single file upload
		singleFileUpload(driver);
		
		//2. Multiple file upload
		multipleFileUpload(driver);
		Thread.sleep(5000);
		driver.quit();
		
	}

	private static void multipleFileUpload(WebDriver driver) {
		String filePath_1 = System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\test.txt";
		String filePath_2 = System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\test.txt";
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@name='filesToUpload']"));
		uploadFile.sendKeys(filePath_1+"\n"+filePath_2);
		System.out.println("File Uploaded");
	}

	private static void singleFileUpload(WebDriver driver) {
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\test.txt";
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@name='filesToUpload']"));
		uploadFile.sendKeys(filePath);
		System.out.println("File Uploaded");
	}
}
