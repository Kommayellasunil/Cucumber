Feature: Dashboard search from clinic manager role

  Scenario: Searching using dashboard buttons and filters
    Given navigate NH_URL "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email6 "doctor1@nh.com" password7 "Chakra@1"
    And sign_in_button is clicked
    Then doctor dashboard opens
    And searching with the calendar view
    Then seaching with the list view
    And searching with the ophosptial
    #Then searching with the iphospital
    And search with the mypatients
    Then search patient using filter button
	And search patient using top search bar