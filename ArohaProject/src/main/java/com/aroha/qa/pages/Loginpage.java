package com.aroha.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.testbase.TestBase;


public class Loginpage extends TestBase{
 
@FindBy(xpath="/html/body/div[4]/div[1]/div/div/div/a[1]")
@CacheLookup
WebElement LoginButton;
@FindBy(name="username")
WebElement Username;
@FindBy(name="password")
WebElement Password;
@FindBy(xpath="/html/body/div[4]/div[2]/form/input[2]")
WebElement Login;

public Loginpage() {
PageFactory.initElements(driver,this);
}
public void ValidateLogin() {
}
public Home_page login(String username,String passowrd) throws InterruptedException
{
LoginButton.click();
Username.sendKeys(username);
        Password.sendKeys(passowrd);
        Thread.sleep(5000);
        Login.click(); 
        
        
        return new Home_page();
}



	

}
