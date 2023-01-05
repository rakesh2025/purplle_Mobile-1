package tests;

import java.util.HashSet;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Listener.class)
public class Demo {

	
	@Test(priority = 1,description = "Test case no 2")
	public void two() throws Throwable {
		System.out.println("Two");
		Thread.sleep(15000);
		System.out.println("Two_Two");
		
	}

	@Test(priority=2,description = "Test case no 1")
	public void one() throws Throwable {
		System.out.println("One");

		Thread.sleep(15000);
		System.out.println("One_One");
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
