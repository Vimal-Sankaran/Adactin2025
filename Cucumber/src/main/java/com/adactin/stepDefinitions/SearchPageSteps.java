package com.adactin.stepDefinitions;

import com.adactin.entitymanager.EntityHelper;
import com.adactin.pages.SearchPage;
import com.adactin.utitlities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class SearchPageSteps extends BaseClass {

    public WebDriver driver;

    public SearchPage searchPage;

    public EntityHelper entityHelper;

    public SearchPageSteps(){
        driver = setChromeBrowser();
        searchPage = new SearchPage(driver);
        entityHelper = new EntityHelper();
    }

    @Given("I select location option {string} in Search Page")
    public void selectLocation(String location){
       searchPage.selectLocation(location);
    }

    @Given("I enter all details in search page with id {string}")
    public void completeSearch(String id) {
       searchPage.selectLocation(entityHelper.getCustomerDataById(id).getLocation());
       searchPage.selectHotelName(entityHelper.getCustomerDataById(id).getHotelName());
       searchPage.selectRoomType(entityHelper.getCustomerDataById(id).getRoomType());
       searchPage.selectNoOfRooms(entityHelper.getCustomerDataById(id).getNoOfRooms());
       searchPage.setCheckInDate(entityHelper.getCustomerDataById(id).getCheckIn());
       searchPage.setCheckOutDate(entityHelper.getCustomerDataById(id).getCheckOut());
       searchPage.selectAdults(entityHelper.getCustomerDataById(id).getAdultsPerRoom());
       searchPage.selectChild(entityHelper.getCustomerDataById(id).getChildrenPerRoom());
       searchPage.clickSearch();
    }

    @Then("I validate navigation to search page")
    public void validateSearchPageNavigation() {
        assertTrue("Adactin.com - Search Hotel",searchPage.getSearchPageTitle(),"Page title validated");
    }

    @Then("I validate Check in date error in search page displayed as {string}")
    public void validateCheckInError(String errorMsg) {
        assertTrue(errorMsg,searchPage.getCheckInError(),"CheckIn error validated");
    }
}
