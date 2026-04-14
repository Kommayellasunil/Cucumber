Feature: register a patient and assign care team and book homecareattendent appointment

  Scenario: book homecareattendent appointment and assign carer
    Given navigates to the NH url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email4 "Sunilkhc@nh.com" password4 "Chakra@1"
    And signinbutton was clicked
    And delete the existing elder from the cdpadmin role and click on the brand logo to change role
    Then selecting the profile for manager role
    And click on register elder icon for register new elder
    Then enter the details for the elder registration
    And click on the submit button to register elder
    When elder is registered then patient profile will be opened
    Then assing care team from the patient profile through care team icon
    And book the home care attendant appointment to the registered elder
	Then change the daily rate amount in the popup and select paylatet
	Then pay the amount generate the invoice and share donwload the inovice
	And open patient profile and assign the carer to the elder tasks
	Then click on the checkin button and update the checkin reason
	And click on the carerpay from billing and search and approve the status
	Then en switching role to nursing officer and search and download the sheet
	And switch role to finance and change status to pay from approve