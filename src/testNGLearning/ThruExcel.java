package testNGLearning;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThruExcel {
	Object[][] data;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	WebDriver driver; 
	String src="E:\\Selenium\\New Microsoft Excel Worksheet.xlsx";
	@DataProvider(name="data")
	public Object[][] readFromExcel() throws IOException
	{
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		//count number of rows and columns
		int rowCount=sheet.getLastRowNum();//5
		int colCount=sheet.getRow(0).getLastCellNum();//2
		System.out.println("Row Count="+rowCount);
		System.out.println("Column Count="+colCount);
		data=new Object[rowCount][colCount];
//		for(int i=1;i<rowCount;i++)//focus to row
//		{
//			for(int j=0;j<colCount;j++)
//			{
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
//			}
//		}
		for(int i=0;i<rowCount;i++)//focus to Row
		{
			for(int j=0;j<colCount;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j);
			}
		}
		wb.close();
		return(data);
		
		
	}
	@BeforeClass
	public void launchLogin()
	{
		driver= new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
	}

	@Test(dataProvider="data")
	public void login(String un,String passwd) throws InterruptedException 
	{
	System.out.println(un+"\t"+passwd);
	String title=driver.getTitle();
	//System.out.println("title="+title);
	Reporter.log("Title="+title);
	Assert.assertEquals(title,"Rediffmail");//hard assert
	System.out.println("Assert Executed...");
	driver.findElement(By.id("login1")).clear();
	driver.findElement(By.id("login1")).sendKeys(un);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(passwd);
	
	driver.findElement(By.id("remember")).click();
	Thread.sleep(6000);
	}
	@AfterClass
	public void closeRediff()
	{
		driver.quit();
	}

}
