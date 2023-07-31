package testNGLearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Exp {
	
	Object[][] data;
	@DataProvider(name="data")
	public Object[][] dp() 
	{
		data=new Object[3][2];

		data[0][0]="tani";
		data[0][1]="tani11";
		
		data[1][0]="pooja";
		data[1][1]="pooja11";
		
		data[2][0]="reena";
		data[2][1]="reena11";
		return (data);
	}
	@Test(dataProvider="data")
	public void login(String un ,String passwd) 
	{
	System.out.println(un+"\t"+passwd);
	}
	
	

}
