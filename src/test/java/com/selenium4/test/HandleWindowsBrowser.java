package com.selenium4.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v121.browser.model.WindowID;

public class HandleWindowsBrowser {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		String window  = driver.getWindowHandle();
		System.out.println(window);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);	
		//Approach 1
		
		List<String> windowsID = new ArrayList(windows); 
		String parentWindow = windowsID.get(0);
		String childWindow = windowsID.get(1);
		driver.switchTo().window(childWindow);
		System.out.println("Child Window Title - "+driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title - "+driver.getTitle());
		
		
		//Approach 2
		
		for(String winId : windowsID) {
			String title = driver.switchTo().window(winId).getTitle();
			
			//closing parent and child window
			if(title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM")) {
				driver.close();
			}
		}
		
	}
}
