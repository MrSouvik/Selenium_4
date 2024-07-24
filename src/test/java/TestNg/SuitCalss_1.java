package TestNg;

import org.testng.annotations.Test;

public class SuitCalss_1 {

	@Test(priority=1)
	public void test1() {
		System.out.println("Test 1 method at suitClass 1");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Test 2 method at suitClass 1");
	}
}
