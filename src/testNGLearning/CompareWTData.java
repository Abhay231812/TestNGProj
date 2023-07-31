package testNGLearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CompareWTData {
ArrayList<String>act_data= new ArrayList<String>();
ArrayList<String>exp_data= new ArrayList<String>();

String src="E:\\Selenium\\data.txt";
FileReader fr;
BufferedReader br;
WebDriver driver;
	
	@Test(priority=1)
	public void readFrmWebTb()
	{

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement myTable=driver.findElement(By.xpath("/html/body/table"));
		List<WebElement>allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total rows="+allRows.size());
		
		//fetch content from the web table
		for(int i=1;i<allRows.size();i++)//focus to row
		{
			List<WebElement>allCols=allRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<allCols.size();j++) //focus on column
			{
				System.out.println(allCols.get(j).getText());
				act_data.add(allCols.get(j).getText());
			}
		}
		driver.quit();
	}
@Test(priority=2)
	public void readDataFrmTextFile() throws IOException 
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String content=null;
		while((content=br.readLine())!=null)
		{
			System.out.println(content);
			exp_data.add(content);
		}
		
	}
@Test(priority=3)
public void compareExpAndAct() 
{
	for(int i=0;i<exp_data.size();i++)
	{
		if(exp_data.get(i).equals(act_data.get(i)))
		{
			System.out.println("Item Matched..");
		}
		else
		{
			System.out.println("Item not Matched..");
		}
	}
}
}
