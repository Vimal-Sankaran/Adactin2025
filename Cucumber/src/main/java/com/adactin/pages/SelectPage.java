package com.adactin.pages;

import com.adactin.utitlities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage extends BaseClass {

	public WebDriver driver;

	@FindBy(id = "radiobutton_0")
	private WebElement radioButtonSelect;
	@FindBy(id = "hotel_name_0")
	private WebElement hotelName;
	@FindBy(id = "location_0")
	private WebElement location;
	@FindBy(id = "rooms_0")
	private WebElement rooms;
	@FindBy(id = "arr_date_0")
	private WebElement arrivalDate;
	@FindBy(id = "dep_date_0")
	private WebElement departureDate;
	@FindBy(id = "no_days_0")
	private WebElement numberOfDays;
	@FindBy(id = "room_type_0")
	private WebElement roomType;
	@FindBy(id = "price_night_0")
	private WebElement pricePerNight;
	@FindBy(id = "total_price_0")
	private WebElement totalPrice;
	@FindBy(id = "continue")
	private WebElement continueButton;
	@FindBy(id = "cancel")
	private WebElement cancelButton;

	//constructor
	public SelectPage(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
	}
	public void selectRadioButton(){
		clickOnElement(radioButtonSelect);
	}
	public String getHotelName(){
		return hotelName.getAttribute("value");
	}
	public String getLocation(){
		return location.getAttribute("value");
	}
	public String getRoom(){
		return rooms.getAttribute("value");
	}
	public String getArrivalDate(){
		return arrivalDate.getAttribute("value");
	}
	public String getDepartureDate(){
		return departureDate.getAttribute("value");
	}
	public String getNumberOfDays(){
		return numberOfDays.getAttribute("value");
	}
	public String getRoomType(){
		return roomType.getAttribute("value");
	}
	public String getPricePerNight(){
		return pricePerNight.getAttribute("value");
	}
	public String getTotalPrice(){
		return totalPrice.getAttribute("value");
	}
	public void clickContinueButton(){
		clickOnElement(continueButton);
	}
	public void clickCancelButton(){
		clickOnElement(cancelButton);
	}
}
