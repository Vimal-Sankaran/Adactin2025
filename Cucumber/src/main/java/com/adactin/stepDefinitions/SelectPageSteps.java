package com.adactin.stepDefinitions;

import com.adactin.entitymanager.EntityHelper;
import com.adactin.pages.SearchPage;
import com.adactin.pages.SelectPage;
import com.adactin.utitlities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class SelectPageSteps extends BaseClass {

    public WebDriver driver;

    public SelectPage selectPage;

    public EntityHelper entityHelper;

    public SelectPageSteps(){
        driver = setChromeBrowser();
        selectPage = new SelectPage(driver);
        entityHelper = new EntityHelper();
    }

    //    @Given("I select location option {string} in Search Page")
//    public void selectLocation(String location){
//        //selectPage.selectLocation(location);
//    }
    @Then("I validate hotel name {string} in Select Hotel page")
    public void validateHotelName(String hotelName){
        assertTrue(selectPage.getHotelName(),hotelName,"Hotelname validated");
    }
    @Then("I validate location {string} in Select Hotel page")
    public void validateLocation(String location){
        assertTrue(selectPage.getLocation(),location,"Location validated");
    }
    @Then("I validate rooms {string} in Select Hotel page")
    public void validateRooms(String rooms){
        assertTrue(selectPage.getRoom(),rooms,"Rooms validated");
    }
    @Then("I validate arrival date {string} in Select Hotel page")
    public void validateArrivalDate(String arrivalDate){
        assertTrue(selectPage.getArrivalDate(),arrivalDate,"Arrival date validated");
    }
    @Then("I validate departure date {string} in Select Hotel page")
    public void validateDepartureDate(String departureDate){
        assertTrue(selectPage.getDepartureDate(),departureDate,"Departure date validated");
    }
    //    @Then("I validate number of days {string} in Select Hotel page")
//    public void validateNumberOfDays(String numberOfDays){
//        assertTrue(selectPage.getNumberOfDays(),numberOfDays,"Departure date validated");
//    }
    @Then("I validate rooms type {string} in Select Hotel page")
    public void validateRoomsType(String roomsType){
        assertTrue(selectPage.getRoomType(),roomsType,"Rooms type validated");
    }
    @Given("I select hotel in Select Hotel page and click Continue")
    public void clickContinue() throws InterruptedException {
        selectPage.selectRadioButton();
        selectPage.clickContinueButton();
        Thread.sleep(3000);
    }

    @Given("I capture PricePerNight and total price excl Gst in Select Hotel Page in json {string}")
    public void capturePrice(String id){
        entityHelper.getCustomerDataById(id).setPricePerNight(selectPage.getPricePerNight());
        entityHelper.getCustomerDataById(id).setTotalPriceExcGST(selectPage.getTotalPrice());
        entityHelper.saveBookingData();
    }

    @Then("I validate all details in Select Hotel page with json {string}")
    public void validateAllDetails(String id){
        assertTrue(selectPage.getHotelName(),entityHelper.getCustomerDataById(id).getHotelName(),"Hotel name validated");
        assertTrue(selectPage.getLocation(),entityHelper.getCustomerDataById(id).getLocation(),"Location validated");
        assertTrue(selectPage.getRoom().substring(0,1),entityHelper.getCustomerDataById(id).getNoOfRooms().substring(0,1),"No of Rooms validated");
        assertTrue(selectPage.getArrivalDate(),entityHelper.getCustomerDataById(id).getCheckIn(),"Arrival date validated");
        assertTrue(selectPage.getDepartureDate(),entityHelper.getCustomerDataById(id).getCheckOut(),"Departure date validated");
        assertTrue(selectPage.getRoomType(),entityHelper.getCustomerDataById(id).getRoomType(),"Room type validated");
    }

    @Then("I validate hotel name and location in search Page with json {string}")
    public void validateHotel(String id){
        assertTrue(selectPage.getHotelName(),entityHelper.getCustomerDataById(id).getHotelName(),"Hotel name validated");
        assertTrue(selectPage.getLocation(),entityHelper.getCustomerDataById(id).getLocation(),"Location validated");

    }
}
