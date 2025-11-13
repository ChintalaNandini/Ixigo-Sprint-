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
  
  #4thScenario
  #Scenario: Navigate and click through Ixigo pages
   # Given the user is on Ixigo home page
    #When the user clicks on trains
  #  And user clicks on Check Seat Availability
   # And user enters data of From <sheetNo> <rowNum> <colNum> 
    #And user enters data of To <sheetNo> <rowNum> <colNum> 
    #And user clicks on Check Availability
   # Then verify Trains Availability Page
    
#Examples:
 #| sheetNo | rowNum | colNum |
# | 0 | 1 | 0 |
 #| 0 | 2 | 1 |
 
@3rdScenario
Scenario: Navigate and click through Ixigo pages
    Given the user is on Ixigo home page
    When the user clicks on trains
    Then user clicks on order food on train
    Then it should display on order food page
    And user click on input field 
    And user click on Enter you digit PNR number <sheetNo> <rowNum>
    And click on search
    And verify popup
    Then click on okay
Examples:
| sheetNo | rowNum |
| 1 | 0 |
#| 1 | 1 |
#| 1 | 2 |


 