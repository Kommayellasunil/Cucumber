Feature: Create and Test Recommendation Flow

Background: 
    Given navigate to the NH_Web_portal "https://customer.nanohealthplan.com/users/sign_in"
    When login page opened
    Then enters the email "Sunilk@nh.com" password "Chakra@1"
    And click on signin button to login
    Then selects the cdp name and role name
    When role is selected it will opens the recommendation manager dashboard
        
  Scenario: Create recommendation with form, logic engine and test it
    Then user opens the recommendation creation screen
    When user creates a new recommendation
    And user adds a source form Cucum formbuilder
    And user deletes the added source node
    And user adds the source form again Cucum formbuilder
    And user adds target node Doctor Consultation
    And user configures logic with height condition
    And user updates logic code
    And user submits recommendation with name Cucum recommendation
    And user edits recommendation to add true condition target
    Then user tests recommendation with height value
    And user tests recommendation with height value
