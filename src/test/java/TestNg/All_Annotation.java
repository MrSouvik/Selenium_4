package TestNg;

import org.testng.annotations.*;

public class All_Annotation {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is BEFORE SUITE");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is BEFORE TEST");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is BEFORE CLASS");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is BEFORE METHOD");
	}
	@Test
	public void test1() {
		System.out.println("This is TEST 1");
	}
	@Test
	public void test2() {
		System.out.println("This is TEST 2");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is AFTER METHOD");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("This is AFTER CLASS");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("This is AFTER TEST");
	}
	@AfterSuite
    public void AfterSuite() {
    	System.out.println("This is AFTER SUITE");
	}
}
