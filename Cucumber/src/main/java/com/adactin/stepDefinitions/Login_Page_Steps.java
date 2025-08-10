package com.adactin.stepDefinitions;

import com.adactin.pages.Login_Page;
import com.adactin.utitlities.BaseClass;
import com.adactin.utitlities.FileReaderManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login_Page_Steps extends BaseClass {

    public WebDriver driver;
    public FileReaderManager frm;

    public Login_Page loginPage;

    public Login_Page_Steps(){
        driver = setChromeBrowser();
        frm = new FileReaderManager();
        loginPage = new Login_Page(driver);
    }

    @Given("I have navigated to Login Page")
    public void navigateToLoginPage() throws IOException {
//        driver.get(frm.getPropertyValue("url"));
        driver.get(frm.getPropertyValue("urlbuild2"));
    }

    @Given("I enter username {string} in Login Page")
    public void setUserName(String userName) {
        loginPage.setUsername(userName);
    }

    @Given("I enter password {string} in Login Page")
    public void setPassword(String password) {
        loginPage.setPassword(password);
    }

    @Given("I click on login button in Login Page")
    public void clickButton() {
        loginPage.clickLogin();
    }

    @Given("I enter user details and complete login")
    public void completeLogin() throws IOException {
        loginPage.setUsername(frm.getPropertyValue("username"));
        loginPage.setPassword(frm.getPropertyValue("password"));
        loginPage.clickLogin();
    }

}
