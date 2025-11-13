Feature: Validate Ixigo Offers Page Navigation
@1st
Scenario: Validate navigation from Ixigo Home page to Offers page
  Given User launches Ixigo website
  When User navigates to Offers page
  Then Validate Offers page is opened successfully
  Then Print and validate title of the webpage
  
  
  @2nd
Scenario: Verify navigation to Track Ticket page and UI elements
    Given User launches  the Ixigo website
    When User navigates to Offers page
    Then the user clicks on the Track Ticket option
    Then the Track Ticket page should be displayed
    And the page title should be Enter Ticket Details
    And the user should see input fields for Booking ID and Mobile Number
    And a Track Details button should be visible
    And the Frequently Asked Questions section should be displayed

@3rd    
Scenario: Search buses from offers page 
  Given User launches the Ixigo Website
  And user navigates to the offers page
  When user enters from station FromStation
  And user enters to station ToStation
  And user clicks on search
  Then search results should be displayed    


