package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTest {
	public static void main(String[] args) {
		//1. Open application in Incognito Mode
		incognitoMode();
		
		//2 . Before Accepting SSL certificate 
		beforeAceptingSSLCert();
				
		//3. After Accepting SSL Certificate 
		afterAceptingSSLCert();
		
		//4. Disable Automation massage on screen 
		disableAutomationMassageOnScreen();
		
		//5. Headless testing
		/*	Advantages of HeadLess testing -
		 *  --------------------------------
		 *  1) We can do multiple task (since execution is happen in backend).
		 *  2) Faster Execution 
		 * 
		 *  Disadvantages of HeadLess testing -
		 *  --------------------------------
		 *  1) User cannot see the actions on the page, so user cannot understand flow/functionality of the test  
		 */
		headlessTesting();
		
	}

	private static void headlessTesting() {
		// before setting chromeDriver we have to set chromeOptions
		ChromeOptions options  =  new ChromeOptions();
		options.addArguments("--headless=new"); //setting for headless mode of execution
				
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

	private static void disableAutomationMassageOnScreen() {
		ChromeOptions options  =  new ChromeOptions();
		//Below line will help to remove "<driver> is being control by automated software" on time of execution
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		String title=driver.getTitle();
		System.out.println("Page Title - "+title);
		driver.quit();
	}

	private static void incognitoMode() {
		ChromeOptions options  =  new ChromeOptions();
		options.addArguments("--incognito"); //to run the test case in Incognito mode 
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}
	
	private static void afterAceptingSSLCert() {
		ChromeOptions options  =  new ChromeOptions();
		options.setAcceptInsecureCerts(true); //This will accept ssl certificates
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		String title=driver.getTitle();
		System.out.println("After Accepting SSL Certificate, Page Title - "+title);
		driver.quit();
	}

	private static void beforeAceptingSSLCert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		String title=driver.getTitle();
		System.out.println("Before Accepting SSL Certificate, Page Title - "+title);
		driver.quit();
	}
}
