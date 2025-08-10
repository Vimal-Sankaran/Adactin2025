@Test
Feature: Login

Scenario: Login Feature
  Given I have navigated to Login Page
  When I enter username "psvimalbe" in Login Page
  And I enter password "88RP9T" in Login Page
  And I click on login button in Login Page

  Scenario Outline: Login Feature1
    Given I have navigated to Login Page
    When I enter user details and complete login
    And I enter all details in search page with id "<id>"
    Then I validate all details in Select Hotel page with json "<id>"
    And I capture PricePerNight and total price excl Gst in Select Hotel Page in json "<id>"
    And I select hotel in Select Hotel page and click Continue
    Then I validate details in Booking page with json "<id>"
    And I capture GST details in Booking page with json "<id>"
    And I enter details with json "<id>" and continue booking
    Then I validate details in Confirmation Page with json "<id>"
    And I capture order number in Confirmation page with json "<id>"
    Then I validate details in Itinerary Page with json "<id>"
    Examples:
    |id|
    |SingleRoom|


