Feature: Creating favourite prescription from doctor role
	@favps
  Scenario: Creating favourite prescription from doctor role
    Given navigate to nanohealth login url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email11 "doctor1@nh.com" password11 "Chakra@1"
    And click on the signin button to login into doctor role
    When signin button is clicked then doctor dashboard opens
    Then click on the myaccount and click on configurations button
    And from configurations click on the prescription
    Then delete the existing favourite prescription and click on the plus button to add new one
    And create the favourite prescription and save it
    Then edit the favourite prescription and save it again
    
    @favds
    Scenario: Creating favourite dischargesummary from doctor role
    Given nav to nanohealth login url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter the email12 "doctor1@nh.com" password12 "Chakra@1"
    And click on the signin button to login into the doctor role
    When sign in button was clicked and then doctor dashboard opens
    Then click on the myaccount button and click on configurations button
    And from configurations section click on the dischargesummary button
    Then delete the existing favourite dischargesummary and click on the plus button to add new one
    And create the favourite dischargesummary and save it
    Then edit the favourite dischargesummary and save it again