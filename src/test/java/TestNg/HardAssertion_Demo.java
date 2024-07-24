package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion_Demo {

	@Test
	void test() {
//		Assert.assertEquals("xyz", "xyz"); //Pass
//		Assert.assertEquals(123, 345); //fail
//		
//		Assert.assertEquals("abc", 123); //Fail
//		Assert.assertEquals(123, 123); //Pass
//		
//		Assert.assertNotEquals(123, 123); //fail
//		Assert.assertNotEquals(123, 456); //Pass
//		
//		Assert.assertTrue(true); //Pass
//		Assert.assertTrue(false); //Fail
//		
//		Assert.assertTrue(1==2); //Fail
//		Assert.assertTrue(1==1); //Pass
//		
//		Assert.assertFalse(1==2); //Pass
//		Assert.assertFalse(1==1); //Fail
//		
		Assert.fail(); //Fail
	}
}
