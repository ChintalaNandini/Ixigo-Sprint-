Feature: Hotels Page Functionality

  Scenario: Validate Hotels page and search button
    Given I am on the Ixigo homepage
    When I click on the Hotels tab
    And I click on the Search button without entering any details
    Then I should remain on the Hotels page or see an appropriate validation message
    
    
  Scenario: Validate Top Hotels functionality
    Given I am on the Ixigo homepage
    When I click on the Hotels tab
    And I click on the hotel
    Then I should navigate to the next page
    
  Scenario: Validate OffersPage functionality
    Given I am on the Hotels Page
    When I click on the offers
    And click on the Search Hotels
    And click on the Hotelpage search
    Then I should the get the list of hotels
    
 # @tw
  #Scenario Outline: Validate hotel filtering functionality
  #Given I am on the Hotels page1
  #Wh#en I click the Search Hotels button
 #And# I apply the checkbox filter with <sheet> and <row>
 # Then I should see a list of filtered hotels

 # Examples:
 # | sheet | row |
 # | 0     | 0   |
  #| 0     | 1   |

   

  
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
    
  
   
  