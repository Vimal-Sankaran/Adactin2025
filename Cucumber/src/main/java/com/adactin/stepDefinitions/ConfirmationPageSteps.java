package com.adactin.stepDefinitions;

import com.adactin.entitymanager.EntityHelper;
import com.adactin.pages.ConfirmationPage;
import com.adactin.utitlities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ConfirmationPageSteps extends BaseClass {
    public WebDriver driver;

    public ConfirmationPage confirmationPage;

    public EntityHelper entityHelper;

    String checkInEr = "Check-In Date shall be before than Check-Out Date";

    public ConfirmationPageSteps(){
        driver = setChromeBrowser();
        confirmationPage = new ConfirmationPage(driver);
        entityHelper = new EntityHelper();
    }

    @Then("I validate details in Confirmation Page with json {string}")
    public void validateConfirmationPage(String id){
        assertTrue(confirmationPage.getHotelName(),entityHelper.getCustomerDataById(id).getHotelName(),"Hotel name valid");
        assertTrue(confirmationPage.getLocation(),entityHelper.getCustomerDataById(id).getLocation(),"Location valid");
        assertTrue(confirmationPage.getTotalRooms().substring(0,1),entityHelper.getCustomerDataById(id).getNoOfRooms().substring(0,1),"No of rooms valid");
        assertTrue(confirmationPage.getPricePerNight(),entityHelper.getCustomerDataById(id).getPricePerNight(),"Price valid");
        assertTrue(confirmationPage.getTotalPrice(),entityHelper.getCustomerDataById(id).getTotalPriceExcGST(),"Price valid");
        assertTrue(confirmationPage.getGST(),entityHelper.getCustomerDataById(id).getGst(),"Price valid");
        assertTrue(confirmationPage.getFinalBilledPrice(),entityHelper.getCustomerDataById(id).getTotalPriceIncGST(),"Price valid");
        assertTrue(confirmationPage.getFirstName(),entityHelper.getCustomerDataById(id).getFirstName(),"Valid");
        assertTrue(confirmationPage.getBillingAddress(),entityHelper.getCustomerDataById(id).getBillingAddress(),"Valid");
    }

    @Given("I capture order number in Confirmation page with json {string}")
    public void captureOrderNumber(String id) throws InterruptedException {
        entityHelper.getCustomerDataById(id).setOrderNumber(confirmationPage.getOrderNo());
        entityHelper.saveBookingData();
        confirmationPage.clickMyItineraryButton();
    }


}
