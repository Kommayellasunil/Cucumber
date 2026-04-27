Feature: registering patients

  Background: 
    Given navigate to nanohealth url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter the emailormobile "Sunilk@nh.com" and password "Chakra@1"
    And click signin button
    Then select the profile for clinic manager

  @addingfamilymember
  Scenario: Registering a patient and adding family member
    And delete existing patient using search bar
    Then existing patient_deleted
    And click on add_patienticon for registration
    Then selecting the  title_of_patient
    When user enters following details into registration form to register
      | firstname    | Demo              |
      | lastname     | Mrfam             |
      | age          |                35 |
      | phone        |        7781110013 |
      #| email        | demofameqr@gmail.com |
      | addressline1 | ameerpet          |
      | addressline2 | ameerpet          |
      | landmark     | metro station     |
      | city         | test              |
      | district     | test              |
      | pincode      |            878787 |
      #| aadharcard   |      123456789012 |
    Then selecting_the radio_button
    And click on submitbutton_to_register
    Then it redirects to the patient_profile
    And deleting the existing family member
    When user click on add family member
    Then entering the following details in the add family member
      | firstname  | family |
      | secondname | member |
    #| age          |                         68 |
    #| mobilenumber |                 8008117650 |
    #| emailid      | |
    And selecting the relation by clicking on the dropdown
    Then selecting the checkbox for address
    When clicking on the submit button in the add family member popup
    Then family member is added and redirected to the patient profile
    And clicking on the edit relationship pencil icon
    Then edit relatioship popup will be opened
    When edit the relation from dropdown
    Then submit button will be visible click on it
    And it will again redirect to the patient profile

  @existingphonefamilymember
  Scenario: adding family member using existing phone number
    And deleting the existing same number family member
    And click on the add patient icon to register a new patient
    Then select the title of the patient to register new patient
    When registration form is opened to register a new patient then enter the following details
      | firstname    | Automation        |
      | lastname     | Existmember       |
      | age          |                55 |
      | phone        |        7667676769 |
      #| email        | automemberq@gmail.com |
      | addressline1 | ameerpet          |
      | addressline2 | ameerpet          |
      | landmark     | metro station     |
      | landmark2    | hyderabad         |
      | district     | test district     |
      | district     | test              |
      | pincode      |            123456 |
      | aadharcard   |      123456789012 |
    Then select the required radio buttons to register
    And click submit button_to_register the patient of whom entered details in registration form
    Then deleting the existing family member using search
    And clicking on the add patient to add family member using existing phone number
    Then enter the already existing number in mobile number filed
    When existing number entered popup will be shown
    And from the popup select the family member radio button
    Then add family member popup will be shown
    And enter the family member first and last names
    Then select the sex of the family member
    And click on the DOB and select the age
    Then select relation from the dropdown
    And select the home checkbox for family member
    Then click on the submit button to add family member
    When family member is added then it will shown under the family member section
    Then click on the added family member name

  @existingphoneself
  Scenario: opening patient profile by clicking on self for existing mobile number
    And click on the add patient icon in the top of the page
    Then enter the existing phone number to select the self
    When existing phone number entered then popup opens
    Then select the self radio button from the popup
    And it will open the patient profile for that existing mobile number
    
  @existingregid
  Scenario: existing patient registration id validation in the registration form
  Then search a existing patient and copy the patient id
  And open registration page from the clinic manager role
  Then paste the reg id in the registration id field
  And check the validation for existing patient reg id
  Then searching with invoice number and click on the invoice id
