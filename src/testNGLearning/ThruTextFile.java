package testNGLearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class ThruTextFile {
	
	File fc;
	FileWriter fw;
	BufferedWriter bw;
	BufferedReader br;
	FileReader fr;
	String src="E:\\Selenium\\data.txt";
	
	@Test
	public void readfrmTextFile() throws IOException
	{
		fc=new File(src);
		fc.createNewFile();
		//to write content to the file create objects for the FileWriter and Buffered writer classes
		fw =new FileWriter(src);
		bw=new BufferedWriter(fw);
		bw.write("This is my first line");
		bw.newLine();
		bw.write("This is my second line");
		bw.newLine();
		bw.write("This is my third line");
		bw.close();
		
		// to read the content from the file create objects for FileReader and BufferdReader classes
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String content=null;
		while((content=br.readLine())!=null);
		{
			System.out.println(content);
		}
		
		br.close();
		
		
		
	}

}
