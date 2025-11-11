Feature: Hotels Page Functionality

  Scenario: Validate Hotels page and search button
    Given I am on the Ixigo homepage
    When I click on the Hotels tab
    And I click on the Search button without entering any details
    Then I should remain on the Hotels page or see an appropriate validation message
    
    
  Scenario: Validate search functionality with Destination, Check-in, Check-out, Rooms & Guests
    Given the search functionality is available on the homepage
    When I enter a valid destination
    And I select check-in and check-out dates
    And I select the number of rooms and guests
    And I click on the search button
    Then I should see a list of available hotels matching the criterias