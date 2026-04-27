Feature: register a lead edit and save and engagement with the lead
Scenario: lead register
    Given navigating to the NH url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email "telecaller@nh.com" password "Chakra@1"
    And signin button clicked
    Then selecting the profile for telecaller
    And click on register lead icon for registration
    Then enter the details for the lead registration
    And click on the submit button to register lead
    And edit the lead and save the changes
    When lead is registered it will be shown in the dashboard
    Then click on the engagement button
    And add the engagement for the leadeng stage1 and save
	And add the engagement for the leadeng stage2 and save
	And add the engagement for the leadeng stage3 and save
	Then search the lead using dashboard date filter and buttons