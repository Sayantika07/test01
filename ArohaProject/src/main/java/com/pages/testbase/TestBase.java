package com.pages.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utility.Test_util;
import com.qa.utility.WebEventListener;

//import com.utility.Test_util;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
public TestBase()
{
try {
prop=new Properties();
FileInputStream ip=new FileInputStream("C:\\Users\\sayantika\\git\\test01\\ArohaProject\\src\\main\\java\\com\\qa\\config\\conf.properties");
prop.load(ip);
}
catch(FileNotFoundException e )
{
e.printStackTrace();
}
catch(IOException e)
{
e.printStackTrace();
}
}
public static void initalization()
{
String Browsername=prop.getProperty("browser");
if(Browsername.equals("chrome"))
{
System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantika\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
driver=new ChromeDriver();

}
e_driver = new EventFiringWebDriver(driver);
//Now create object of EventListerHandler to register it with EventFiringWebDriver
eventListener = new WebEventListener();
e_driver.register(eventListener);
driver = e_driver;




driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Test_util.Page_Load_Timeout,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(Test_util.implict_wait,TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
 
 

}
}