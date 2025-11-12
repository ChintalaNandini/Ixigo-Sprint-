Feature: Validate Ixigo Offers Page Navigation

Scenario: Validate navigation from Ixigo Home page to Offers page
  Given User launches Ixigo website
  Then User navigates to Offers page
  Then Validate Offers page is opened successfully
  Then Print and validate title of the webpage
  
  
  
  Scenario: Verify navigation to Track Ticket page and UI elements
    When the user clicks on the Track Ticket option
    Then the Track Ticket page should be displayed
    And the page title should be Enter Ticket Details
    And the user should see input fields for Booking ID and Mobile Number
    And a Track Details button should be visible
    And the Frequently Asked Questions section should be displayed
    
    


 Scenario Outline: Verify user can navigate to Bus Offers and perform search
    Given the user launches the webbrowser
    When the user navigates to the Bus Offers page
    And then navigates to the Buses search page
    And enters "<FromStation>" as From Station and "<ToStation>" as To Station
    And keeps the travel date as default
    And clicks on Search
    Then the search results page should be displayed successfully

Examples:
      | FromStation | ToStation   |
      | Bangalore   | Hyderabad   |
      | Delhi       | Jaipur      |
  