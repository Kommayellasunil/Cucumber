Feature: Booking lab+home diagnostic appointment to a patient

  Scenario: Registering patient and booking lab+home
    Given navigate to the nanohealth url by opening chromebrowser "https://customer.nanohealthplan.com/users/sign_in"
    Then enter the emailormobile3 "Sunilk@nh.com" and password3 "Chakra@1"
    And click on the sign in button to select profile
    Then select the profile of clinic manager from the roles
    And deleting the exists patient using search bar from clinic manager role
    When existing patient got deleted
    And click on add patient icon to register a new patient
    Then select the title of patient to mrs
    When user enters following details into registration form to register a new patient
      | firstname    | Cucum             |
      | lastname     | Labhome           |
      | age          |                30 |
      | phone        |        6717767678 |
      #| email        | cucumlqwobb@gmail.com |
      | addressline1 | ameerpet          |
      | addressline2 | ameerpet          |
      | landmark     | metro station     |
      | city         | test              |
      | district     | test              |
      | pincode      |            878787 |
      #| aadharcard   |      123456789012 |
    Then enter the necessary details to register a new patient
    And enter the height weight details so that bmi will calculate automatically
    And click on submit button to register a new patient
    Then it will redirects to the new registered patient profile
    And click on the Book Diagnostic Appointment from the Book Appointment
    Then selecting the lab from the dropdown
    When thyrocare lab is selected tests that are avaible in thyrocare lab will reflect
    Then mouse hovering and selecting the test from type of pathology
    And mouse hovering again and selecting the test from type of radiology
    Then clicking on the checkout button from lab_home add to cart popup
    And select the appointment type as lab_home from the type popup
    When patient address is one then it will redirect to the selection of lab address
    And if patient has two or more home address it will redirect to the home address seletion
    Then selecting the lab address for booking lab_home appointment
    And select the date and time slot for the pathology tests
    Then select the date and time slot for the radiology tests
    And select the perfomring doctor using search
    Then select the referred by and enter delivery charges
    And enable the notify patient checkboxes from the invoice popup
    Then click on the submit button from the invoice popup
    And click on the appointments present in the above of the page
    When appointments is clicked alert will be open
    And click on the appointment id of Home
    Then close the popup opened right side of the page1
    And click on the appointments present in the above again
    Then click on the appointment id of Lab Visit
    And close the popup opened right side of the page1
    Then close the alert opened in the top of the page
    When user select the radio button from the payment methods
    Then cursor will move to the transaction amount field
    When user enter the cash as per tests prices
    Then receipt comment icon will be enabled and click on it
    And enter the receipt comment and click on ok button to submit comment
    When user click on the submit button from proforma invoice page
    Then it redirect to the invoice page
    And download the invoice by clicking on the print icon
    And download the receipt by clicking on the receipt id
    And download the pdf by clicking on the total advance pdf icon
    And download the invoice by clicking on the print icon in the page bottom
    When user click on the share invoice to share the invoice
    And clearing the already given mail and mobile number to enter new mail
    Then enter the email id to whom we are sharing the invoice
    And click on submit button to share invoice
    Then switch the role to radiologytechnician to fillup the form
    And fill the form and submit and forward it to radiologist role
    Then switch the role to radiologist to approve
    And from radiologist role click on approve button
