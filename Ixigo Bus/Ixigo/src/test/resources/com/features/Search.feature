Feature: Login Functionality
Scenario: User lanuches the browser and open the Ixigo app
 
 
Given User is on the Ixigo homepage
When User clicks on the Login icon
And User enters the phone no
And User waits for OTP and clicks continue
Then User should be logged in successfully
