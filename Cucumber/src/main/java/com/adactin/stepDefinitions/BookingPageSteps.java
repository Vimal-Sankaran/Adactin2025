package com.adactin.stepDefinitions;

import com.adactin.entitymanager.EntityHelper;
import com.adactin.pages.BookingPage;
import com.adactin.utitlities.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


public class BookingPageSteps extends BaseClass {
    public WebDriver driver;

    public BookingPage bookingPage;

    public EntityHelper entityHelper;

    public BookingPageSteps(){
        driver = setChromeBrowser();
        bookingPage = new BookingPage(driver);
        entityHelper = new EntityHelper();
    }

    @Then("I validate details in Booking page with json {string}")
    public void validateBooking(String id) {
        assertTrue(bookingPage.getHotelName(),entityHelper.getCustomerDataById(id).getHotelName(),"Hotel name valid");
        assertTrue(bookingPage.getLocation(),entityHelper.getCustomerDataById(id).getLocation(),"Location valid");
        assertTrue(bookingPage.getRoomType(),entityHelper.getCustomerDataById(id).getRoomType(),"Room type valid");
        assertTrue(bookingPage.getNoOfRoom().substring(0,1),entityHelper.getCustomerDataById(id).getNoOfRooms().substring(0,1),"No of rooms valid");
        assertTrue(bookingPage.getPricePerNight(),entityHelper.getCustomerDataById(id).getPricePerNight(),"Price valid");
        assertTrue(bookingPage.getTotalPriceExtGst(),entityHelper.getCustomerDataById(id).getTotalPriceExcGST(),"Price valid");
    }

    @Given("I capture GST details in Booking page with json {string}")
    public void captureBooking(String id) {
        entityHelper.getCustomerDataById(id).setGst(bookingPage.getGst());
        entityHelper.getCustomerDataById(id).setTotalPriceIncGST(bookingPage.getFinalPrice());
        entityHelper.saveBookingData();
    }

    @Given("I enter details with json {string} and continue booking")
    public void continueBooking(String id) throws InterruptedException {
        bookingPage.setFirstname(entityHelper.getCustomerDataById(id).getFirstName());
        bookingPage.setLastName(entityHelper.getCustomerDataById(id).getLastName());
        bookingPage.setAddress(entityHelper.getCustomerDataById(id).getBillingAddress());
        bookingPage.setCreditCardNo(entityHelper.getCustomerDataById(id).getCcNum());
        bookingPage.setCcType(entityHelper.getCustomerDataById(id).getCcType());
        String ccExp = entityHelper.getCustomerDataById(id).getCcExpiry();//12/27
        bookingPage.setMonth(ccExp.split("/")[0]);
        bookingPage.setExpYear(ccExp.split("/")[1]);
        bookingPage.setCvv(entityHelper.getCustomerDataById(id).getCvv());
        bookingPage.clickBookNow();
    }
}
