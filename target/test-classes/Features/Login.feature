Feature: Login into the NanoHealth
@login
  Scenario: Logging with the valid credentials
    Given User navigates to the NanoHealth web application "https://customer.nanohealthplan.com/users/sign_in"
    When User enters the email address "Sunilk@nh.com"
    And User enters the password "Chakra@1"
    And User clicks on the sign in button
    Then user select the role
    And user successfully loggined with the role
