package com.adactin.pages;

import com.adactin.utitlities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BaseClass {

	public WebDriver driver;
	
	@FindBy(id ="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="login")
	private WebElement login_Btn;

	public Login_Page(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String username1) {
		sendValueToTextBox(username,username1);
	}

	public void setPassword(String password1) {
		sendValueToTextBox(password,password1);
	}

	public void clickLogin() {
		clickOnElement(login_Btn);
	}
	
}
