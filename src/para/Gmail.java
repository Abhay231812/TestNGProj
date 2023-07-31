package para;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Gmail {
	
	@Test
	@Parameters({"un","pwd"})
	public void gmailLogin(String uname,String passwd) 
	{
		System.out.println("Gmail Login");
		System.out.println(uname+"\t"+passwd);
	}

}
