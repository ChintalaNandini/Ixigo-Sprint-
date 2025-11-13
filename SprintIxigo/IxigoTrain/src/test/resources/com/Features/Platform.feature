Feature: Train Functionality

@First
Scenario: Verify that entering a valid train number displays the platform number.
 
	Given The user is on the Platform Locator page of the Ixigo website.
	When The user enters a validTrainNumber in the search input field.
	And clicks Search
	Then The platform number for the entered train should be displayed
	
 
@Second
Scenario: Book Now button should be visible and clickable for each available train
 
    Given the user is on the Train Home page
    When the user clicks on Search by Station
    And the user enters a valid stationName
    And the user clicks on Search
    Then the system should display a list of available trains
    And click on Book Now button
    Then user is navigated to Booking page
    
    
    
@Third
Scenario: Verify download prompt appears after clicking check status
  Given User is on Ixigo website and clicks on Trains tab
  When User clicks on Running Status
  And User enters train number or name 
  And User clicks on check status button
  Then Download prompt should appear allowing user to save train data
  
  
  
@Fourth
Scenario Outline: Verify train search with valid source and destination
Given User is on Ixigo website and clicks on Trains tab
When User enters Source name from sheet <sheet> and row <row> and sourceCol <sourceCol>
And User enters Destination name from sheet <sheet> and row <row> and destinationCol <destinationCol>
And User clicks on Search for train data
Then user is navigated to train data displayed page

Examples:
| sheet | row | sourceCol | destinationCol |
|   0   |  0  |     0     |       1        |









