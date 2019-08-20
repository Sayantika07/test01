package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aroha.qa.pages.Home_page;
import com.aroha.qa.pages.Loginpage;
import com.pages.testbase.TestBase;


public class LoginTest extends TestBase{
	Loginpage lp;
Home_page hp;
public LoginTest() {
super();
} 

@BeforeMethod
public void setUp()
{
initalization();
lp=new Loginpage();
}
@DataProvider
public void getTestData()
{
	
}

@Test
public void Logintest() throws InterruptedException
{
hp=	lp.login(prop.getProperty("username"),prop.getProperty("password"));
Thread.sleep(5000);
}
@AfterMethod
public void tearDown()
{
 
driver.quit();
 
 
}

}
