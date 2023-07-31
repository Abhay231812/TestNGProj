package list;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(list.TestNGList.class)
public class Calc {

	@Test
	public void add()
	{
		Assert.assertEquals(50,50);
	}
	@Test
	public void add1() 
	{
		Assert.assertEquals(50,30);
	}
}
