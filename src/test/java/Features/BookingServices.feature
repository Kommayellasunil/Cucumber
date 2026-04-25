Feature: Booking services for a registered patient
 
  Scenario: registering the another patient and booking services
    Given navigate_to_nanohealth_on_the_web "https://customer.nanohealthplan.com/users/sign_in"
    Then logging with the  emailid "Sunilk@nh.com" and  password "Chakra@1"
    And click on sign_in_button
    Then select_the_profile
    And deleting existing patient using search
    Then existing patient deleted
    And click on add_patient_icon for registration
    Then select title_of_patient
    When user enters the following details into the registration form
      | firstname    | Cucum             |
      | lastname     | Oppatient         |
      | age          |                35 |
      | phone        |        7789110017 |
      #| email        | cucumoptwoo@gmail.com|
      | addressline1 | ameerpet          |
      | addressline2 | ameerpet          |
      | landmark     | metro station     |
      | city         | test              |
      | district     | test              |
      | pincode      |            878787 |
    Then select the radio_buttons
    And click on  submit_button_to_register
    Then it will redirects to the patient_profile
    #ambulance
    When user click on ambulance from book appointment
    Then from popup select the pickup location
    And select the location and choose address
    Then from popup select the drop location
    And select the location and choose address for drop location
    Then select the date and time for appointment
    And click on continue button
    Then enter the price and click on submit button
    And select the paymentmethods1
    When user enter transactionamount as partial for paymentmethodone
    Then Receiptcomment1 will be visible click on it
    And enter the receiptcomments1 and click on ok
    Then click on the submit button  inthe proformainvoice1
    And click on the paybalance button
    Then billing invoice page will open select the payment methodtwo and enter partial amount
    And click on the submit button from the invoice_page
    Then click on the paybalance button again
    And select the paymentmethodthree and enter partial amount
    Then click on the submit button again from the invoice page
    And Click on the generate button in the top to generate invoice id
    And click on the paybalance button again to pay partial amount
    Then select paymentmethod as send link and enter details
    And click on the submit from the proforma invoice page
    And clicking on the appointmentid at righttop
    Then reducingscreensize click on the proformainvoice
    And clicking on the viewbutton and closingpopup for ambulancebooking
    And selecting Servicewise Datewise Itemwise Summary and downloading the invoice
    And download the Invoice_receipt_totaladvance_printpdf1
    Then click on shareinvoice1 button
    And clears existing mail and phone for ambulance appointment
    Then enter phone and click on submit button  for shareinvoice1
    When user click on patientsname from ambulance proformainvoicepage
    Then patientprofile page will be opened
    #homecareservices booking
    When user click on bookhomecareservice from book appointment
    Then services page will open
    And select the homecare services and remove one of the selected services
    Then click on checkout button from homecare service page
    And select the location and address
    Then select the start date and end date with timings
    And enter the age and click on continue
    Then changing time in the invoice page
    And clicking on submit button	
    Then it will open the proformainvoice page for homecareservice
    And changing the comments by clearing existing comment beside services name
    And edit the invoice date for home care services
    Then select pay later option from the payments
    Then click on the submit button inthe proformainvoice2
    And download the Invoice_receipt_totaladvance_printpdf2
    Then click on the invoice id to generate the invoice id
    Then click on shareinvoice2 button
    And clears existing mail and phone for homecareservices appointment
    Then enter mail and click on submit button for shareinvoice2
    When user click on patientsname from homecareservices proformainvoicepage
    Then patientprofile page will open
    #diagnostic booking
    When user click on bookdiagnostic from book appointment
    Then it will show the avaible labs and tests
    When select lab from the dropdown
    Then avaible tests from that lab will be reflected
    And select the diagnostic services and remove one of the selected services
    Then click on checkout button from diagnostic service page
    And select the type
    Then select the address for the selected lab
    And select the slot for diagnostic appointment
    Then enter referredby delivery charges
    And select the notify patient checkboxes for diagnostic booking
    Then click on submit from paymentpage for diagnostic booking
    Then it will open the proformainvoice page for diagnostic booking
    And give the hundered percent discount and apply
    Then click on the submit button inthe proformainvoice3
    And download the Invoice_receipt_totaladvance_printpdf3
    Then click on shareinvoice3 button
    And clears existing mail and phone for diagnostic appointment
    Then enter mail and click on submit button for shareinvoice3
    When user click on patientsname from diagnostic proformainvoicepage
    Then patientprofile  will be open
    #dietician booking
    When user click on bookdietitianappointment from book appointment
    Then list of avaible dietitians will be displayed
    And select the dietitan and click on book appointment
    Then select the type and slot for dietitan appointment
    And here we can change timings
    Then select the checkboxes for notifypatient for dietitanappointment
    And click on the submit from paymentpage for dietitanappointment
    Then it will open proformainvoice page for dietitanappointment
    And select the paymentmethods4
    When user enters the transactionamount then receiptcomment will visible
    Then click on receiptcomment and enter the comment
    Then click on the submit button inthe proformainvoice4
    And download the Invoice_receipt_totaladvance_printpdf4
    Then click on shareinvoice4 button
    And clears existing mail and phone for dietitianappointment
    Then enter mail and click on submit button for shareinvoice4
    When user click on patientsname from dietitian proformainvoicepage    
    #opprocedures booking
    When user click on bookopprocedures from book appointment
    Then list of procedures will be displayed for opprocedures
    And select the procedures and remove of them
    Then click on the checkout for op procedure booking
    And select the procedure start time and end time
    Then select the procedure room for op procedure appointment
    When user click on submit button
    Then from team popup select the therapist_leaddoctor_supportingdoctor_counsellor
    And click on continue button from team
    Then enter the nursing and additional charges
    And click on the submit button from opprocedure invoice page
    Then proformainvoice page will be opened for opprocedure
    And select the paymentmethods7
    When user enters_the transaction_amount for opprocedure then receipt_comment will visible
    Then click on receipt_comment and enter_comment for opprocedure appointment
    Then click on the submit button inthe proformainvoice7
    And download the Invoice_receipt_totaladvance_printpdf7
    Then click on shareinvoice7 button
    And clears existing mail and phone for opprocedure
    Then enter mail and click on submit button for shareinvoice7
    When user click on patientsname from opprocedure proformainvoicepage
    Then patientprofile  will opened after opprocedure appointment
    #doctor-refund booking
    When user click on bookdoctorappointment from book appointment
    Then list of avaible doctors list will be displayed
    And select the doctor and click on book appointment
    Then select the type for doctorappointment
    And select the dateandtime and slot for doctor appointment
    Then we can change the slottime here for doctorappointment
    And select the registrationfees_notifypatients checkboxes
    Then click on the submit button from payment popup
    And applying discount for five percentage and entering the comments
    Then paying the remaining balance and entering the comments
    Then click on receipt_comment and enter_comment for doctor appointment
    Then click on the submit button inthe proformainvoice8
    And download the Invoice_receipt_totaladvance_printpdf8
    When user click on the back button from the doctor appointment profoma invoice
    Then it will redirect to the doctor appointment page
    And click on the confirmed status for doctor in the appointments
    Then click on the first patients appointment id
    And click on the cancel button from the popup
    Then from cancel appointment popup enter the cancellation reason
    And click on the refund button from cancel appointment popup
    Then it will redirect to the proformainvoice for refund
    And select the paymentmethod for refund
    Then enter the  amount for refund
    When receipt comment is visible
    Then click on it and enter the receipt comment and click on ok
    And enter the refund reason and click on ok
    Then click on the submit button from the refund proformainvoice page
    And download the invoice_receiptIDs_totaladvance_printpdf from the refund proformainvoice page
    When user click on patientsname from refund proformainvoicepage
    Then patientprofile  will opened after refund proformainvoicepage
    #dialysis booking
    When patient profile is opened click on the book dialysis
    Then select the procedure date and start end time
    And click on the continue button from the dates popup
    Then select the lead doctor and click on the continue button
    And click on the submit button from invoice popup
    Then enter the amount and generate the invoice id for the invoice
    And download the invoice receipt and share invoice to the mail
    #program booking
    When user click on addprogram from book appointment
    Then it will display the programs
    And select the programs and remove one of the program
    Then click on the checkout for the program booking
    And select addreferredby and select the program start date
    Then click on the submit button from select invoice of addprogram booking
    And select the paymentmethods10
    When user enters_the transaction_amount for program then receipt_comment will visible
    Then click on receipt_comment and enter_comment for program appointment
    Then click on the submit button inthe proformainvoice10
    And download the Invoice_receipt_totaladvance_printpdf10
    Then click on shareinvoice10 button
    And clears existing mail and phone for program
    Then enter mail and click on submit button for shareinvoice10
    And create a dynamic op package
    And merge the invoices from the history
    
    
    
    
    
