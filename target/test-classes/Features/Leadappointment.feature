Feature: register a lead with appointment date and converting to patient
Scenario: register a lead with appointment date and converting to patient
    Given navigating to the NHurl "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email3 "Sunilk@nh1.com" password3 "Chakra@1"
    And signin button was clicked
    And select cdpadmin role to delete existing patient and select crmleader to register new lead
    Then select the profile for crmleader
    And click on register lead icon for registration from crmleader
    Then enter the details for the lead registration from crmleader
    And click on the submit button to register lead from crmleader
    When lead is registered it will be shown in the dashboard under my appointments
    Then click on the engagement button from myappointments
    And add the engagement for the leadeng stage1 and save from crmleader
		Then switch role to clinic manager role from crmleader
		And convert the lead into patient by registering and book apt
		Then switch back to crmleader role