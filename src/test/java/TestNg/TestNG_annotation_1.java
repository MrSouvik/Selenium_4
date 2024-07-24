package TestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 *  @Test
 *  
 *  @BeforeMethod
 *  @AfterMethod
 *  
 * 
 */
public class TestNG_annotation_1 {

	/*
	 *  Scenario -
	 *  --------
	 *  1. Login - @BeforeMethod 
	 *  2. Search - @Test
	 *  3. Logout - @AfterMethod
	 *  4. Login
	 *  5. Adv Search - @Test
	 *  6. Logout
	 */
	
	@BeforeMethod 
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
	
	@AfterMethod
	public void logout() {
		System.out.println("This is logout method");
	}
}
