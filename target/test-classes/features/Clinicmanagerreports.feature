Feature: Reports module from clinic manager role

  Background: 
    Given open test NH url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter  test mailid "Sunilk@nh.com" and pswd "Chakra@1"
    And clicked on signin button to login then
    Then clinic manager role was clicked

  Scenario: reports
    #corporate
    Then change role to cdpadmin and delete existing patients
    And click on the reports and select corporates
    Then click on plus button to create new corporate
    And search and click on the corporate name to add employees to corporate
    Then add familymember for the employee in the corporate
    And convert employee to patient by filling registration form
    #formsreport
    And click on the reports and select formsreport
    Then search the form and click on the download button
    #pharmacy
    And click on the pharmacy and select the dialyreport
    Then search and download the dialyreports
    And click on the pharmacy and select the patientwisereport
    Then search and download the patientwisereports
    And click on the pharmacy and select the monthlyreport
    Then search and download the monthlyreport
    And click on the pharmacy and select the brandwisereport
    Then search and download the brandwisereport
    #recommendations
    And click on the reports and select the recommendations
    Then assign care team to the patient and 
    And add next engagement for the patient
    #patients
    Then click on the reports and select the patients
    And click on the group button and delete the existing group
    Then create a new group and add some of the patients to the created group
    And send info to the patients using send info button from groups
    #referrals
    Then click on the reports and select referrals
    And search with patient name or dates and download the data
    #consultations
    Then click on the reports and select consultations
    Then search with patient name or dates and download consultations data
    #programutilization
    Then click on the programutilization button and search with name and dates fileds
    #carts
    And click on reports and select carts and search with dates
    
