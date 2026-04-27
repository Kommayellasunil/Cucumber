Feature: Lead register in insurance provider type

  Background: 
    Given naviagating to the web_NH_Portal "https://customer.nanohealthplan.com/users/sign_in"
    When login page was_opened
    Then entering the email_id "telecaller1@nh.com" password "Chakra@1"
    And click on_the_sign_in button
    When select the_cdp and profile popup opens
    Then select the_cdp and role_as telecaller

  @leadregister
  Scenario: 
	When telecaller dashboard opened
	Then click on the add new lead to register a new lead
	And fillup the details for the lead registration
	Then click on the submit to register the lead
	When new lead is registered lead will be shown on the dashboard
	Then edit and submit the edit lead form
	And click on the Insurance required for edit button
	Then fillup the form and submit the form
	When form is submitted, data will be populated in the Insurance required for section in popup
	Then click on the Insurer Selected edit button
	And fillup the form with insurer and submit the form
	When form is submitted, data will be populated in the insurer for section in popup
	Then click on the stage and select the stage and status also and enter the remarks
	And click on the submit button present at the bottom of the page
	Then click on the view remarks button to show the remarks