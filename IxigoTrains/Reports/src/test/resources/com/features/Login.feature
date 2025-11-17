Feature: Ixigo Navigation Flow
@1stScenario
  Scenario: Navigate and click through Ixigo pages
    Given the user is on Ixigo home page
    When the user clicks on trains
    Then user clicks on order food on train
    Then it should display on order food page
     
@2ndScenario  
Scenario: Navigate and click through Ixigo pages
  Given the user is on Ixigo home page
  When the user clicks on trains
  Then user clicks on Train platform Locator
  Then verify the Train platform Page
 
@3rdScenario
Scenario: Navigate and click through Ixigo pages
    Given the user is on Ixigo home page
    When the user clicks on trains
    Then user clicks on order food on train
    Then it should display on order food page
    And user click on input field 
    And user click on Enter you digit PNR number <sheetNo> <rowNum>
    And click on search
    Then verify Available Stations
Examples:
| sheetNo | rowNum |
| 0 | 0 |
| 0 | 1 |
| 0 | 2 |

@4thScenario
  Scenario: Navigate and click through Ixigo pages
  Given the user is on Ixigo home page
  When the user clicks on trains
  And user clicks on Check Seat Availability
  When User enters Source name from sheet <sheet> and row <row> and sourceCol <sourceCol>
  And User enters Destination name from sheet <sheet> and row <row> and destinationCol <destinationCol> 
  And user clicks on Check Availability
  Then verify Trains Availability Page
    
Examples:
| sheet | row | sourceCol | destinationCol |
|   0   |  0  |     0     |      1         |


@5thScenario  
Scenario: Navigate and click through Ixigo pages
  Given the user is on Ixigo home page
  When the user clicks on offers
  And user clicks on TrainOffers
  Then verify offers availability 





 