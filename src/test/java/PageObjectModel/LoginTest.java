package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void LogInTest() {
		System.out.println("Login started using normal method");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName("Admin");
		lp.enterPassword("admin123");
		lp.clickOnLogin();
	}
	
	@Test
	public void LogInTest_PageFactory() {
		System.out.println("Login stared using Page factory approach");
		LoginPage_Using_PageFactory lp_pageFactory = new LoginPage_Using_PageFactory(driver);
		lp_pageFactory.enterUserName("Admin");
		lp_pageFactory.enterPassword("admin123");
		lp_pageFactory.clickOnLogin();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
