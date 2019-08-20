package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pages.testbase.TestBase;

public class Test_util extends TestBase {

public static long Page_Load_Timeout=20;
public static long implict_wait=50;
static Workbook book;
static Sheet sheet;
/*public static String TestPath="ArohaProject/src/main/java/com/aroha/testdata/Aroha_user_details.xlsx";
public static Object[][]getTestData(String sheetName){
	FileInputStream file = null;
	try {
		file=new FileInputStream(TestPath);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		
	}
	try {
		book=WorkbookFactory.create(file);
	}catch(InvalidFormatException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();

		

	
	}
}*/
public static void takeScreenshotAtEndOfTest() throws IOException {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
String currentDir = System.getProperty("user.dir");
FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}




}

	

