package TestNg;

import org.testng.annotations.Test;

/*
 * TestNG - Test New Generation
 * Java based unit testing tool
 * 
 * Advantages :
 * -----------
 * 1) Test cases & Test suites.
 * 2) Grouping of Test cases.
 * 3) Prioritize
 * 4) Parameterization
 * 5) Parallel Testing
 * 6) Reports
 * 
 * TestNG Configuration :
 * ---------------------
 * 1) Install TestNG in eclipse
 * 2) Add TestNG library to build path / Add TestNG dependency in pom.xml
 * 
 * @Test - annotation
 * 
 * 1) TestNg execute method based on alphabetical order.
 * 2) @Test(priority=num) controls the order of execution
 * 3) Once you provide priority to the test methods, then order of methods is not considered.
 * 4) Priorities can be random numbers ( no need to have the consecutive numbers )
 * 5) If you do not provide priority then default value is Zero (0).
 * 6) If the priority is same then again execute method in alphabetical order.
 * 7) Negative values are allowed in priority.
 * 8) TestNG execute test methods only if they are having @Test annotation.
 * 
 * 
 */
public class FirstTestNG_Class {
	
	@Test(priority=-1)
	public void setUp() {
		System.out.println("This is set up method");
	}
	
	@Test(priority=0)
	public void test() {
		System.out.println("This is test method");
	}
	
	@Test(priority=1)
	public void tearDown() {
		System.out.println("This is teardown method");
	}

}
