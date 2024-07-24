package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *  @Test
 *  
 *  Below two annotation are worked on xml level
 *  --------------------------------------------
 *  
 *  @BeforeTest
 *  @AftreTest
 * 
 */
public class TestNG_annotation_3_Part1 {

	//This method can be created in any class
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test Method");
	}
	@Test
	public void Test1() {
		System.out.println("This is Test 1 method");
	}
}
