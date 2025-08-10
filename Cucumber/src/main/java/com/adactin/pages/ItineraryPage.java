package com.adactin.pages;

import com.adactin.entitymanager.EntityHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItineraryPage {

	public WebDriver driver;
	public EntityHelper entityHelper;
	@FindBy(id="logout")
	private WebElement logout;

	public ItineraryPage(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
		entityHelper = new EntityHelper();
	}


	public String getHotelName(String orderNumber) {
		return driver.findElement(By.xpath("//input[@value='"+orderNumber+"']//parent::td//following-sibling::td//input[contains(@id,'hotel_name_')]")).getAttribute("value");
	}

	public String getLocation(String orderNumber) {
		return driver.findElement(By.xpath("//input[@value='"+orderNumber+"']//parent::td//following-sibling::td//input[contains(@id,'location')]")).getAttribute("value");
	}
}
