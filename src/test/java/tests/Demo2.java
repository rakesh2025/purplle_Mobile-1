package tests;

import java.util.HashSet;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(utils.Listener.class)
public class Demo2 {

	
	@Test(priority = 1,description = "Test case no 2")
	public void three() throws Throwable {
		System.out.println("Three");
		Thread.sleep(15000);
		System.out.println("Three_Three");
		
	}

	@Test(priority=2,description = "Test case no 1")
	public void Four() throws Throwable {
		System.out.println("One");

		Thread.sleep(15000);
		System.out.println("Four_Four");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		
	}
}
