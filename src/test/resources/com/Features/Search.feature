Feature: Search Functionality
@ExcelData
Scenario Outline: Verify one-way flight search using Excel
    Given I am on the flight search page
    When I enter From location "<path>" <sheetno>
    And I enter To location "<path>" <sheetno>
    And I enter departure date "<path>" <sheetno>
    And I select passengers "<path>" <sheetno>
    And I select class from dropdown "<path>" <sheetno>
    And I click on the search button 
    Then I should see the list of available flights

Examples:
    | path                                                                                     | sheetno |
    | C:\Users\chintal\Sprint\ixigo_flight\src\test\resources\ExcelData | 0 |