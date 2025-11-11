Feature: Search Functionality

@ExcelData
Scenario Outline: Test train search with Excel data
	Given I am on the train search page  
    When I enter the valid Excel source "<path>" <sheetno> 
    And I enter the valid Excel destination "<path>" <sheetno>
    And I enter the valid Excel date "<path>" <sheetno> 
    And I click on Search  
    Then I should see a list of available trains based on the given data

Examples:
| path                                                                      | sheetno |
| C:\Users\koteru\Sprint\Ixigo\src\test\resources\ExcelData\SeachValid.xlsx |    0    |
 