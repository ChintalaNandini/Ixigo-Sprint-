Feature: Platform Locator

Scenario: Verify that entering a valid train number displays the platform number.

	Given The user is on the Platform Locator page of the Ixigo website.
	When The user enters a "validTrainNumber" in the search input field.
	And clicks Search
	Then The platform number for the entered train should be displayed

Scenario: Book Now button should be visible and clickable for each available train

    Given the user is on the Train Home page
    When the user clicks on Search by Station
    And the user enters a valid "stationName"
    And the user clicks on Search
    Then the system should display a list of available trains
    And click on Book Now button
    Then user is navigated to Booking page
    