Feature: Validate Ixigo Offers Page Navigation

  @1st
  Scenario: Validate navigation from Ixigo Home page to Offers page
    Given User launches Ixigo website
    When User navigates to Offers page
    And Validate Offers page is opened successfully
    Then Print and validate title of the webpage

  @2nd
  Scenario: Verify navigation to Track Ticket page and UI elements
    Given User launches  the Ixigo website
    When User navigates to Offers page
    And the user clicks on the Track Ticket option
    And the Track Ticket page should be displayed
    And the page title should be Enter Ticket Details
    And the user should see input fields for Booking ID and Mobile Number
    And a Track Details button should be visible
    Then the Frequently Asked Questions section should be displayed

  @3rd
  Scenario: Search buses from offers page
    Given User launches the Ixigo Website
    When user navigates to the offers page
    And user enters from station FromStation
    And user enters to station ToStation
    And user clicks on search
    Then search results should be displayed

  @4th
  Scenario Outline: Verify bus search with valid source and destination using excel data
    Given User is on Ixigo website and navigates to Offers page
    When User enters From station name from sheet <sheet> and row <row> and fromCol <fromCol>
    And User enters To station name from sheet <sheet> and row <row> and toCol <toCol>
    And User clicks on search for buses data
    Then User verifies bus details page is displayed

    Examples:
      | sheet | row | fromCol | toCol |
      | 0     | 1   | 0       | 1     |
      | 0     | 2   | 0       | 1     |

  @5th
  Scenario Outline: User searches for buses and applies bus type filter
    Given User is on Ixigo homepage and User navigates to Offers page
    When User enters From station name from sheet <sheet> and row <row> and fromCol <fromCol>
    And User enters To station name from sheet <sheet> and row <row> and toCol <toCol>
    And User clicks on Search button then Bus listing page should display available buses
    Then User selects BusType filter and bus list gets updated

    Examples:
      | sheet | row | fromCol | toCol |
      | 1     | 0   | 0       | 1     |
      | 1     | 1   | 0       | 1     |
