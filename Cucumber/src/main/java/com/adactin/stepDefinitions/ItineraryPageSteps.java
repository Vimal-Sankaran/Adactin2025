package com.adactin.stepDefinitions;

import com.adactin.entitymanager.EntityHelper;
import com.adactin.pages.ItineraryPage;
import com.adactin.utitlities.BaseClass;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ItineraryPageSteps extends BaseClass {
    public WebDriver driver;

    public ItineraryPage itineraryPage;

    public EntityHelper entityHelper;

    public ItineraryPageSteps(){
        driver = setChromeBrowser();
        itineraryPage = new ItineraryPage(driver);
        entityHelper = new EntityHelper();
    }


    @Then("I validate details in Itinerary Page with json {string}")
    public void validateIt(String id){
        String orderNumber = entityHelper.getCustomerDataById(id).getOrderNumber();
        System.out.println(orderNumber);
        System.out.println(itineraryPage.getHotelName(orderNumber));
        assertTrue(itineraryPage.getHotelName(orderNumber),entityHelper.getCustomerDataById(id).getHotelName(),"Valid");
        assertTrue(itineraryPage.getLocation(orderNumber),entityHelper.getCustomerDataById(id).getLocation(),"Valid");
    }
}
