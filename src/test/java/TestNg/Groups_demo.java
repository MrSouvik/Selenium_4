package TestNg;

import org.testng.annotations.Test;

public class Groups_demo {
	@Test(groups= {"sanity"})
	void m1() {
		System.out.println("Methods m1");
	}
	
	@Test(groups= {"sanity"})
	void m2() {
		System.out.println("Methods m2");
	}
	
	@Test(groups= {"regression"})
	void m3() {
		System.out.println("Methods m3");
	}
	
	@Test(groups= {"regression"})
	void m4() {
		System.out.println("Methods m4");
	}
	
	@Test(groups= {"sanity","regression","functional"})
	void m5() {
		System.out.println("Methods m5");
	}
	
	@Test(groups= {"sanity","regression","functional"})
	void m6() {
		System.out.println("Methods m6");
	}
}
