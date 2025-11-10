Feature: Login Functionality

  Scenario: Validate login with country code and mobile number.
    Given Login functionality should be available
    When I enter the country code and mobile number on the login page
    And I click on Continue
    And I enter the correct OTP
    Then I should be logged in successfully
