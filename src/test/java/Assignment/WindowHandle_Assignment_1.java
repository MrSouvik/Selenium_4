package Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * 	1) Open the link - https://testautomationpractice.blogspot.com/
 *  2) Provide some string and Search for it
 *  3) count no of links
 *  4) click on each link using for loop
 *  5) Print Window ID for every browser window
 *  6) Close specific browser
 */

public class WindowHandle_Assignment_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button' and @type='submit']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		for(WebElement link :links) {
			link.click();
		}
		
		Set<String> windowHandles_set = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<String>(windowHandles_set);
		
		for(String handle : windowHandles) {
			
			driver.switchTo().window(handle);
			String title  = driver.getTitle();
			System.out.println(handle+" - "+title);
			if(title.equals("Test - Wikipedia")) {
				driver.close();
			}
		}
		driver.quit();
	}
}
