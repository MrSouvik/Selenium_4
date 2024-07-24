package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HARSvsSOFT_Assertions {

	@Test(priority = 1)
	void hardAssertionPass() {
		System.out.println("Test started ..(Hard assertion Pass)");
		
		Assert.assertEquals(1, 1);
		
		System.out.println("Test Completed");
	}
	
	@Test(priority = 2)
	void hardAssertionFail() {
		System.out.println("Test started ..(Hard Assertion Fail)");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("Test Completed");
	}
	
	@Test(priority = 3)
	void softAssertionPass() {
		System.out.println("Test started ..(Soft Assertion Pass)");
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(1, 1);
		
		System.out.println("Test Completed");
	}
	
	@Test(priority = 4)
	void softAssertionFail() {
		System.out.println("Test started ..(Soft Assertion Fail)");
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(1, 2);
		
		System.out.println("Test Completed");
		
		sa.assertAll(); // if we don't use this statement then even assertion fail then also test will get pass
	}
}
