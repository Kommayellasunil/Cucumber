Feature: registering a patient and creating an order

  Background: 
    Given naviagate to nh portal "https://customer.nanohealthplan.com/users/sign_in"
    Then enter username "Sunilk@nh.com" and password "Chakra@1"
    And click on sign in
    Then select the role as pharmacist role
    Then pharmacist dashboard opens

  @inventory
  Scenario: Inventory received with invoice
    And click on the inventory and click on stockentry
    And click on inventory received with invoice
    Then enter the details for the inventory and save as draft
    And edit the inventory again add new brand and save
    Then download the pdf and download the reports
    Then Mouse hover on plus button to click on received without invoice
    Then fill up the details and click on save button
    And download the pdf and click on the purchase order button
    Then create purchase order for an brand
    Then click on the inventory return tab
    And select the created GR no and add brand to return
    Then click on save button to return the brand
    And download the return reports
    Then click on inventory and inventory details

  @transferdetails
  Scenario: Transfer details
    And click on the transfer details from inventory
    Then request the brand inventory from other pharmacy by filling details and save
    Then click on the transfer tab
    And transfer the brand to another pharmacy by filling the brand details
    Then click on the received tab
    And click on the cancelled tab to see the cancelled details

  @damageinventory
  Scenario: damaged inventory
    Then click on the inventory and click on damageinventoty
    And add the brand name and submit
