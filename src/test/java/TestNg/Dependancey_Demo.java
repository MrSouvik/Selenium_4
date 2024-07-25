package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependancey_Demo {

	@Test(priority = 1)
	void Test1() {
		System.out.println("This is test 1 method");
//		Assert.fail();
	}
	
	@Test(priority = 2, dependsOnMethods= {"Test1"})
	void Test2() {
		System.out.println("This is test 2 method");
		Assert.fail();
	}
	
	@Test(priority = 3, dependsOnMethods= {"Test1","Test2"})
	void Test3() {
		System.out.println("This is test 3 method");
	}
}
