package com.adactin.pages;

import com.adactin.utitlities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass {

	public WebDriver driver;
	
	@FindBy(id = "location")
	private WebElement loc;

	@FindBy(id = "hotels")
	private WebElement hotel;

	@FindBy(id = "room_type")
	private WebElement roomtype;

	@FindBy(id = "room_nos")
	private WebElement roomno;
	
	@FindBy(id="datepick_in")
	private WebElement datein;
	
	@FindBy(id="datepick_out")
	private WebElement dateout;
	
	@FindBy(id="adult_room")
	private WebElement adult;
	
	@FindBy(id="child_room")
	private WebElement child;
	
	@FindBy(id="Submit")
	private WebElement search;

	@FindBy(id ="checkin_span")
	private WebElement checkInError;

	@FindBy(id = "checkout_span")
	private WebElement checkOutError;

	public SearchPage(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
	}

	public void selectLocation(String location1){
		selectDropDownByText(loc,location1);
	}

	public void selectHotelName(String hotel1) {
		selectDropDownByText(hotel,hotel1);
	}

	public void selectRoomType(String roomType1) {
		selectDropDownByText(roomtype,roomType1);
	}

	public void selectNoOfRooms(String rooms) {
		selectDropDownByText(roomno,rooms);
	}

	public void setCheckInDate(String date) {
		sendValueToTextBox(datein,date);
	}

	public void setCheckOutDate(String date) {
		sendValueToTextBox(dateout,date);
	}

	public void selectAdults(String adults) {
		selectDropDownByText(adult,adults);
	}

	public void selectChild(String noOfChild){
		selectDropDownByText(child,noOfChild);
	}

	public void clickSearch() {
		clickOnElement(search);
	}

	public String getSearchPageTitle() {
		return getPageTitle();
	}

	public String getCheckInError() {
		return checkInError.getText();
	}

	public String getCheckOutError() {
		return checkOutError.getText();
	}
	
}
