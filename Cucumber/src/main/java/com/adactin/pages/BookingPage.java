package com.adactin.pages;

import com.adactin.utitlities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage extends BaseClass {

	public WebDriver driver;

	@FindBy(id="hotel_name_dis")
	private WebElement hotelName ;

	public String getHotelName(){
		return hotelName.getAttribute("value");
	}

	@FindBy(id="location_dis")
	private WebElement location ;

	public String getLocation(){
		return location.getAttribute("value");
	}

	@FindBy(id="room_type_dis")
	private WebElement roomType;

	public String getRoomType(){
		return roomType.getAttribute("value");
	}

	@FindBy(id="room_num_dis")
	private WebElement noOfRooms;

	public String getNoOfRoom(){
		return noOfRooms.getAttribute("value");
	}


	@FindBy(id="total_days_dis")
	private WebElement noOfDays;

	public String getNoDays(){
		return noOfDays.getAttribute("value");
	}


	@FindBy(id="price_night_dis")
	private WebElement pricePerNight ;

	public String getPricePerNight(){
		return pricePerNight.getAttribute("value");
	}

	@FindBy(id="total_price_dis")
	private WebElement totalPriceExcludingGST ;

	public String getTotalPriceExtGst(){
		return totalPriceExcludingGST.getAttribute("value");
	}

	@FindBy(id="gst_dis")
	private WebElement gst ;

	public String getGst(){
		return gst.getAttribute("value");
	}

	@FindBy(id="final_price_dis")
	private WebElement finalPrice;

	public String getFinalPrice(){
		return finalPrice.getAttribute("value");
	}

	@FindBy(id="first_name")
	private WebElement firstName ;

	public void setFirstname (String firstname1){
		sendValueToTextBox(firstName,firstname1);
	}

	@FindBy(id="last_name")
	private WebElement lastname;

	public void setLastName (String lastname1){
		sendValueToTextBox(lastname,lastname1);
	}

	@FindBy(id="address")
	private WebElement address ;

	public void setAddress (String address1){
		sendValueToTextBox(address,address1);
	}


	@FindBy(id="cc_num")
	private WebElement creditCardNo;

	public void setCreditCardNo(String ccNo)
	{
		sendValueToTextBox(creditCardNo,ccNo);
	}


	@FindBy(id="cc_type")
	private WebElement ccType ;

	public void setCcType(String ccType1) {
		selectDropDownByText(ccType,ccType1);
	}

	@FindBy(id="cc_exp_month")
	private WebElement ccMonth ;

	public void setMonth(String month1 ){
		selectDropDownByValue(ccMonth,month1);
	}

	@FindBy(id="cc_exp_year")
	private WebElement ccYear;

	public void setExpYear(String expYear1){
		selectDropDownByText(ccYear,expYear1);
	}

	@FindBy(id="cc_cvv")
	private WebElement cvv;

	public void setCvv(String cvv1){
		sendValueToTextBox(cvv,cvv1);
	}

	@FindBy(id="book_now")
	private WebElement bookNow ;

	public void clickBookNow(){
		clickOnElement(bookNow);
	}

	@FindBy(id="cancel")
	private WebElement cancel ;

	public void clickCancel(){
		clickOnElement(cancel);
	}

	public BookingPage(WebDriver driverr) {
		this.driver=driverr;
		PageFactory.initElements(driver, this);
	}
}
