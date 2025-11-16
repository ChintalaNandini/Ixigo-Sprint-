Feature: Hotels Page Functionality
  @SearchNav
  Scenario: Validate Hotels page and search button
    Given I am on the Ixigo homepage
    When I click on the Hotels tab
    And I click on the Search button without entering any details
    And I click on the Google Map
    Then I should remain on the Hotels page or see a Googlemap
    
    
  @HotelTab 
  Scenario: Validate Top Hotels functionality
    Given I am on the Ixigo homepage
    When I click on the Hotels tab
    And I click on the hotel
    Then I should navigate to the next page
    
  @Offers
  Scenario: Validate OffersPage functionality
    Given I am on the Hotels Page
    When I click on the offers
    And click on the Search Hotels
    And click on the Hotelpage search
    Then I should the get the list of hotels
    

  @SearchInput
  Scenario: User searches for hotels by destination
    Given the user is on the Ixigo homepage
    When the user clicks on the hotels tab
    And the user enters a <sheet><row> destination in the search field
    And the user clicks on the search button
    Then the user should see a list of available hotels displayed 
    Examples:
    | sheet | row |
    |  0    |  0  |
    |  0    |  1  |
    
    
  
  @MNV
  Scenario: Validating hotel overview and login functionalities 
    Given User is on the Hotels homepage 
    When User clicks on the selected hotel
    And User try to reserve one room
    And User enters the <sheet><row> mobile number to login
    And User clicks on continue button
    Then the login through mobile number is verified
    
    Examples:
    | sheet | row |
    |  1    |  0  |
    |  1    |  1  |
    