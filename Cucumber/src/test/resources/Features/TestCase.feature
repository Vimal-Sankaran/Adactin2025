
Feature: Test cases

  @TC01
  Scenario: To verify valid login details
    Given I have navigated to Login Page
    When I enter username "psvimalbe" in Login Page
    And I enter password "88RP9T" in Login Page
    And I click on login button in Login Page
    Then I validate navigation to search page
@TC02
  Scenario: To verify whether the check-out date field accepts a later date than check-in date.
    Given I have navigated to Login Page
    When I enter user details and complete login
    And I enter all details in search page with id "CheckInError"
    Then I validate Check in date error in search page displayed as "Check-In Date shall be before than Check-Out Date"
@TC03
  Scenario: To check if error is displayed for date field is in the past
    Given I have navigated to Login Page
    When I enter user details and complete login
    And I enter all details in search page with id "DateError"
    Then I validate Check in date error in search page displayed as "Check-In Date should be either Today or Later Date"