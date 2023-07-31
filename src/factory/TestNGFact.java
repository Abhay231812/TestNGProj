package factory;

import org.testng.annotations.Factory;

public class TestNGFact {
	@Factory
	public Object[] allTests() 
	{
		Object[] allClasses=new Object[2];
		allClasses[0]=new Sample1();
		allClasses[1]=new Sample2();
		return allClasses;
	}

}
