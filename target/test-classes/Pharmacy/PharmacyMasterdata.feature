Feature: creating brandmaster medicinetype maunfacturer and distributor

  Scenario: creating brandmaster medicinetype maunfacturer and distributor
    Given navigate to the NH_url1 "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email2 "Sunilk@nh.com" password2 "Chakra@1"
    And signin btn is clicked
    Then selecting the profile as pharmacist after selecting the cdp
    #brandmaster
    When pharmacist dashboard is opened then click on the masterdata
    Then click on the brandmaster
    And enter the details after brandmaster creation popup opens
    Then click on the submit button after filling up the details
    And edit and save the changes for the brandmaster
    #medicinetype
    Then click on the masterdata and select the medicinetype
    And fillup the details and upload the medicinetype img and save
    Then edit and save the changes for the medicinetype
    #manufacturer
    Then click on the masterdata and select the manufacturer
    And fillup the details and save the manufacturer
    Then edit and save the changes for the manufacturer
    #distributor
    Then click on the masterdata and select the distributor
    And fillup the details and upload the header footers for distributor and save
    Then edit and save the changes for the distributor
    #currentstock
    And mouse hover on to the currentstock
