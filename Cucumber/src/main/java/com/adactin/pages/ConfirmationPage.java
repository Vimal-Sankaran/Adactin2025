package com.adactin.pages;

import com.adactin.utitlities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BaseClass {

	public WebDriver driver;

	public static String orderNo;

	@FindBy(id = "hotel_name")
	private WebElement hotelName;
	@FindBy(id = "location")
	private WebElement location;
	@FindBy(id = "room_type")
	private WebElement roomType;
	@FindBy(id = "arrival_date")
	private WebElement arrivalDate;
	@FindBy(id = "departure_text")
	private WebElement departureDate;
	@FindBy(id = "total_rooms")
	private WebElement totalRooms;
	@FindBy(id = "adults_room")
	private WebElement adultsPerRoom;
	@FindBy(id = "children_room")
	private WebElement childrenPerRoom;
	@FindBy(id = "price_night")
	private WebElement pricePerNight;
	@FindBy(id = "total_price")
	private WebElement totalPrice;
	@FindBy(id = "gst")
	private WebElement gst;
	@FindBy(id = "final_price")
	private WebElement finalBilledPrice;
	@FindBy(id = "first_name")
	private WebElement firstName;
	@FindBy(id = "last_name")
	private WebElement lastName;
	@FindBy(id = "address")
	private WebElement billingAddress;
	@FindBy(id = "order_no")
	private WebElement orderNumber;
	@FindBy(id = "search_hotel")
	private WebElement searchHotelButton;
	@FindBy(id = "my_itinerary")
	private WebElement myItineraryButton;
	@FindBy(id = "logout")
	private WebElement logoutButton;

	public String getHotelName(){
		return hotelName.getAttribute("value");
	}
	public String getLocation(){
		return location.getAttribute("value");
	}
	public String getRoomType(){
		return roomType.getAttribute("value");
	}
	public String getArrivalDate(){
		return arrivalDate.getAttribute("value");
	}
	public String getDepartureDate(){
		return departureDate.getAttribute("value");
	}
	public String getTotalRooms(){
		return totalRooms.getAttribute("value");
	}
	public String getAdultsPerRooms(){
		return adultsPerRoom.getAttribute("value");
	}
	public String getChildrenPerRooms(){
		return childrenPerRoom.getAttribute("value");
	}
	public String getPricePerNight(){
		return pricePerNight.getAttribute("value");
	}
	public String getTotalPrice(){
		return totalPrice.getAttribute("value");
	}
	public String getGST(){
		return gst.getAttribute("value");
	}
	public String getFinalBilledPrice(){
		return finalBilledPrice.getAttribute("value");
	}
	public String getFirstName(){
		return firstName.getAttribute("value");
	}
	public String getLastName(){
		return lastName.getAttribute("value");
	}
	public String getBillingAddress(){
		return billingAddress.getAttribute("value");
	}
	public String getOrderNo() {
		return orderNumber.getAttribute("value");
	}
	public void selectSearchHotelButton(){
		clickOnElement(searchHotelButton);
	}
	public void clickMyItineraryButton(){
		clickOnElement(myItineraryButton);
	}
	public void selectLogoutButton(){
		clickOnElement(logoutButton);
	}
	public ConfirmationPage(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
	}
}
