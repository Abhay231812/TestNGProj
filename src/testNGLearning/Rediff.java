package testNGLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Rediff {
	WebDriver driver;
	@Test(priority=1)
	
	public void launchrediff()
	{

		driver= new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
	}
	@Test(priority=2,description="Hard Assert",enabled=false)
	public void loginRediff()
	{
		String title=driver.getTitle();
		//System.out.println("title="+title);
		Reporter.log("Title="+title);
		Assert.assertEquals(title,"Rediffmail");//hard assert
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("abhay.1234");
		driver.findElement(By.id("password")).sendKeys("Abhay1234");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("proceed")).click();
		
	}
	@Test(priority=2,description="soft Assert")
	public void loginRediffsoftAssert()
	{
		SoftAssert assertion=new SoftAssert();
	
		String title=driver.getTitle();
		//System.out.println("title="+title);
		Reporter.log("Title="+title);
		assertion.assertEquals(title,"Rediffmail");//soft assert
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("abhay.1234");
		driver.findElement(By.id("password")).sendKeys("Abhay1234");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("proceed")).click();
		assertion.assertAll();
	}
		
	@Test(priority=3)
	public void closeRediff()
	{
		driver.quit();
	}

}
