package TestNG_Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("Execution Stared.");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Stared.");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success.");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed.");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped.");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finish.");
	}
}
