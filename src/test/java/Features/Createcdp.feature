Feature: Superadmin

  Background: Create new cdp and edit and update the cdpstatus
    Given naviagating to NHWebportal "https://customer.nanohealthplan.com/users/sign_in"
    When login page was opened
    Then enter email15 "Sunilk@nh.com" password15 "Chakra@1"
    And click on the sign in button tologin
    When select cdp popup opens
    Then select the cdp and role as superadmin
    When superadmin dashboard opens
    Then click on the plus button to create new cdp
    And enter the cdp details and save to create new cdp
    When cdp is created it will be in the created status
    Then click on the home button and it will open dashboard
    When dashboard opens search created cdp using filters and click on the edit button
    Then in edit cdp popup add details of enabled roles and services and upload headerfooterlogo
    And click on the save button to save the changes of new cdp
    Then update the status of cdp created to active

  @cdpsubscription
  Scenario: Adding Subscription plan for CDP
    When cdp is created take the subscription using subscription plan button
    Then enter and select the details for the subscription plan
    And click on save button for the subscription plan
    And click on the invoice button beside of edit button
    When invoice will be created in draft status
    Then click on the print invoice button and click on the save button to save
    And share the subscription invoice through email
    Then edit the subscription invoice and save changes
    Then click on the cdpinvoices button
    Then click on the plus button to setup the cdp
    And select the setup and fillthe details and submit the details
    Then click on the home button and click on cdp name to create hospital
    And click on the hospital button
    Then enter all the necessary details for creation of hospital
    When hospital is created it will ask for doctor creation
    Then enter the necessary details for doctor creation 
    And click on home button and click on admins button to create cdpadmin
    Then create cdpadmin user from admins button
    And change the status of cdp active to  cdpflagged and verify by user login
    Then change the status of cdp cdpflagged to paused and verify by user login
    Then change the status of cdp paused to cancelled and verify by user login
    Then change the status of cancelled to adminpaused and verify by user login
    Then change the status of adminpaused to active and verify by user login
	