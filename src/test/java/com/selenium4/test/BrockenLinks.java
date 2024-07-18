package com.selenium4.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrockenLinks {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total No of links  - "+links.size());
		int noOfBrokenLinks =0;
		for(WebElement link : links) {
			String  hrefValue = link.getAttribute("href");
			if(hrefValue==null || hrefValue.isEmpty()) {
				System.out.println("href value is null or empty. So not possible to check");
				continue;
			}
			
			//Hit url to server
			URL linkUrl = new URL(hrefValue); //Convert herf to URL
			try {
				HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection(); //open url connection to server
				connection.connect(); //connect to server and send the request to server
				int responseCode = connection.getResponseCode();
				if(responseCode>=400) {
					System.out.println(linkUrl+" ======> Broken link");
					noOfBrokenLinks++;
				}
				else {
					System.out.println(linkUrl+" ======> Not a broken link");
				}
			}
			catch (Exception e) {
				System.out.println(linkUrl+" ======> Unable to check");
			}
			
		}
		System.out.println("No of broken links - "+noOfBrokenLinks);
		driver.quit();
	}
}
