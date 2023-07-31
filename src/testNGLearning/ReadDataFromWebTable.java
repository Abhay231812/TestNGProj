package testNGLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromWebTable {
	
	WebDriver driver;
	String src="E:\\Selenium\\data.txt";
	FileWriter fw;
	BufferedWriter bw;
	@Test
	public void web_table() throws IOException
	{
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		
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
				//System.out.println(allCols.get(j).getText());
				bw.write(allCols.get(j).getText());
				bw.newLine();
			}
		}
		bw.close();
	}

}
