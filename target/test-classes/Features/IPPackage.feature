Feature: registering a patient and booking ip package

  Background: 
    Given navigate to the nanohealth website url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter the emailormobile1 "Sunilk@nh.com" and password1 "Chakra@1"
    And click on the signin button to login ipbillingmanager
    Then select the ipbillingmanager profile

  @admit
  Scenario: registering a patient and filling up admission detail form to make ip patient
    And delete existing patient using search bar in cdpadmin role
    Then existing patient_deleted from the cdpadmin role
    And click on the add_patient_icon for registration
    Then selecting the  title_of_the_patient
    When user enters details into registration form
      | firstname    | Cucum                |
      | lastname     | ippackage            |
      | age          |                   35 |
      | phone        |           7712511112 |
      #| email        | cucumip@gmail.com |
      | addressline1 | ameerpet             |
      | addressline2 | ameerpet             |
      | landmark     | metro station        |
      | city         | hyderabad            |
      | district     | test district        |
      | pincode      |               838383 |
      #| aadharcard   |         123456789012 |
    Then selecting_the radio_button to register patient
    And click on submitbutton_to_register_patient
    Then click on the admission detail from the patient profile
    And fillup the form of admission detail in the ipbillingmanager role
    Then click on the submit button from the admission detail form
    When after submitting the form it will redirect to the patient profile page

  #@ippackage
  #Scenario: booking ippackage appointment for the patient
    Then search and open the patient profile from the ipbillingmanager
    And click on the add ip package icon from the book appointment section
    Then select the packages using plus button
    And remove one of the package using remove button
    Then click on the checkout button from the cart of ip packages
    And search and select the doctor name for referred by
    Then select the program start date for booking ip package
    When start date is selected it will select automatically end date
    Then click on the submit button from the popup
    And select the paymentmethods11 as cash
    When user enters_the transaction_amount for ippackage then receipt_comment will visible
    Then click on receipt_comment and enter_comment for ippackage appointment
    And click on the submit button inthe proformainvoice11
    Then download the Invoice_receipt_totaladvance_printpdf11
    And click on shareinvoice11 button
    Then clears existing mail and phone for ippackage
    And enter mail and click on submit button for shareinvoice11
