package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;


/*
 * Assertion - validation point
 * 
 *  2 Types of Assertion
 *  -----------------------
 *  1) Hard Assertion-
 *  ----------------
 *   we can access from 'Assert' class
 *   methods are static
 *   *if hard assertion failed rest of the statements will not be executed.
 *   
 *  2) Soft Assertion
 *  ------------------
 *  We can access though 'AoftAssert' object
 *  SoftAssert sa = new SoftAssert();
 *  sa.assertTrue();
 *  
 *  if soft assertion got failed then rest of the statements still execute
 */
public class Assertions_Demo {
	@Test
	void testTitle() {
		String expectedTitle = "OpenCart";
		String actualTitle = "OpenShop";
		
		/*if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}*/
		
		//Assert.assertEquals(expectedTitle,actualTitle);
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test Pass");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Test Fail");
			Assert.assertTrue(false);
		}
	}
}
