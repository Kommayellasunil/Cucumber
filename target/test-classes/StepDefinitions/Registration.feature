Feature: Register a patient

  Scenario: Registering a patient
    Given User navigates to the NanoHealth web
    When User enters the email id "Sunilcm@gmail.com"
    And User enters the pswd "Demo@1234"
    And User click on the sign in 
    Then user will selects_the role
    And user successfully logged in with the role
    When user click on the add patient icon
    Then registration form will opens
    When user select the title automatically it will select the gender radio button
    And user enters the first name "Test"
    And user enters the last name "Sunil"
    And user enters the age year "30"
    Then user enters the phone number "8777787777" and gmail "testsunilmail@gmail.com"
    And user enters the address line one "Test" , address line two "Test2" , Landmark "Testlandmark"
    And user selects the state and country
    Then user clicks on the add button for referred by
    And user selects the self option
    Then user clicks on the Choose files for profile picture and uploads picture
    And user clicks on the Choose files for Id card and uploads picture
    When user clicks on the submit button
    Then it will take the user to the patient profile page
