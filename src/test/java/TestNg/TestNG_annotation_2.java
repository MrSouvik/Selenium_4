package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 *  @Test
 *
 *  @BeforeClass
 *  @AfterClass
 * 
 */
public class TestNG_annotation_2 {

	/*
	 *  Scenario -
	 *  --------
	 *  1. Login - @BeforeClass 
	 *  2. Search - @Test
	 *  3. Adv Search - @Test
	 *  4. Logout - @AfterClass
	 */
	
	@BeforeClass
	public void login() {
		System.out.println("This is Login Method");
	}
	@Test(priority=1)
	public void search() {
		System.out.println("This is search method");
	}
	
	@Test(priority=2)
	public void advSearch() {
		System.out.println("This is advSearch method");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("This is logout method");
	}
}
