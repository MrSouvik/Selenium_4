package TestNg;

import org.testng.annotations.Test;

public class SuitClass_2 {
	
	@Test(priority=2)
	public void test1() {
		System.out.println("Test 1 method at suitClass 2");
	}
	
	@Test(priority=1)
	public void test2() {
		System.out.println("Test 2 method at suitClass 2");
	}
}
