package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *  @Test
 *  
 *  Below two annotation are worked on xml level
 *  --------------------------------------------
 *  
 *  @BeforeSuit
 *  @AftreSuit
 * 
 */
public class TestNG_annotation_4 {

	//This method can be created in any class
	@AfterSuite
	public void AfterSuit() {
		System.out.println("This is Aftre Suite Method");
	}
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("This is Before Suite method");
	}
}
