package para;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Yahoo {
	
	@Test
	@Parameters({"un","pwd"})
	public void yahooLogin(String uname,String passwd)
	{
		System.out.println("Yahoo Login");
		System.out.println(uname+"\n"+passwd);
	}

}
