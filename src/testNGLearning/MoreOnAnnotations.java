package testNGLearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoreOnAnnotations {
	
	@Test
	public void testCase1() 
	{
		System.out.println("In Test Case1");
	}
	@Test
	public void testCase2() 
	{
		System.out.println("In Test Case2");
	}
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("In beforeMethod");
	}
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("In afterMetod");
	}
}
