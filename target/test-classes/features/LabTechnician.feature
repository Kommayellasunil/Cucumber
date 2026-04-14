Feature: Lab technician flow

  Scenario: Lab technician flow
    Given navigate_to_nanohealth_on_google_chrome "https://customer.nanohealthplan.com/users/sign_in"
    Then login with clinicmanger detail emailcm "Sunilk@nh.com" and passwordcm "Chakra@1"
    And clicking on the sign_in button to login
    Then selecting_the_cdp_admin_profile
    And deleting exists patient using search
    Then existing patient deleted successfully
    And click on the add_patient_icon for patient registration
    Then selecting title_of_patient
    When user enter the following into the registration form
      | firstname    | Demo             |
      | lastname     | Labtechnician    |
      | age          |               40 |
      | phone        |       8790298141 |
      #| email        | Demolccd6@gmail.com|
      | addressline1 | Ameerpet         |
      | addressline2 | Ameerpet         |
      | landmark     | Metro station    |
      | city         | test             |
      | district     | test             |
      | pincode      |            878787|
      #| aadharcard   |     123456789012 |
    Then selecting the radio_buttons
    And click on submit_button_to_register_patient
    Then it will redirect to patient_profile
    When user click on Book_Diagnostic_Appointment from Book Appointment section
    Then avaiable labs and tests will be displayed
    And selecting the thyrocare lab from lab name dropdown
    When list of tests are displayed from thyrocare lab
    Then selecting the test for diagnosticbooking
    And clicking on the checkout from cartsummary
    Then Types will be displayed select the type
    And select the location address
    Then select the datetime and slot time
    Then selecting referredby by searching and entering delivery charges
    And enabling the checkboxes from notify patient
    Then click on the submit button from invoicepage
    When proformainvoice page will be opened for diagnostic booking
    Then select the paymentmethod radio button
    When user enter the transaction amount then receipt comment will be visible
    Then click on receipt comment and enter the comment
    Then click on the submit button inthe proforma invoice for diagnosticbooking
    #And clicking on the datewise and servicewise buttons in the diagnosticbooking proformainvoicepage
    #And click on share_invoice_button
    #When clears existing mailandphone for diagnosticbooking
    #Then enter mail and click on submit button to share diagnosticproformainvoice
    #When diagnosticproformainvoice is shared successfully
    Then click on the brand logo
    And click on the labtechnician role
    Then labtechnician role dashboard will be opened
    And Click on the appointmentid under confirmed in Labtechnician dashboard
    Then click on the collected and status will be collected
    And click on the dashboard for labtechnician role
    When dashboard is opened click on the collected status
    Then click on the appointmentid under collected in Labtechnician dashboard
    And click on the delivered button and status will be delivered
    Then click on the dashboard for labtechnician
    When dashboard is opened click on the delivered status
    Then click on the appointmentid under delivered in Labtechnician dashboard
    When click on the plus button for add diagnostic test
    Then Add Diagnostic Tests popup will be opened
    And select the tests from dropdown
    Then deleting the recently added test and saving
    And upload the reports by clicking on the Upload Reports
    Then labreport will be uploaded successfully
    And click on the pdf then it will opened in new window
    And click on the Edit digitisation order page
    When clicking on the dropdown and selecting the lab
    Then entering the data into the technology_readings_units
    And entering the comments for each individual test
    Then entering the comments
    And click on the update button
    Then selecting the test checkboxes and deselecting one of them
    When checkboxes are selected then only selected tests results will be printed in the pdfs
    Then clicking on the preview button
    And downloading the pdfs with_without header_footers
    Then clicking on the forward button
    When Lab Report forwarded
    #Then clicking on the lab test masters
    #And click on the tests and searching ECG
    Then clicking on the brand logo1
    And selecting the pathologist role from the roles
    When pathologist dashboard is opened
    Then clicking on the digitalized status from the dashborad
    And clicking on the appointmentid of the patient
    When digitisation page opens
    Then click on the edit button from the pathologist role
    And clear and update the comments from the pathologist role
    Then downloading the pdf
    When click on the preview button
    Then downloading pdfs with and without header footer
    And click on the approve button
    When Lab Report approved
    Then clicking on the Nanohealth brand logo
    And select the clinic manager profile NH_IP+OP
    When dashboard is open mouse hover to the appointments
    Then click on the diagnostic lab orders list
    And click on the Approved status
    When list of approved patients list will be displayed and click on the aptid
    Then from popup copyaddress_downloadinvoice_view
    And downloading the labreports with and without header footer
    Then click on the complete status
    When status is changed to completed
    Then click on the completed status from the header
    And click on the appointment id of the completed status of the lab
    When apt id is clikced popup  will open
    Then click on the inovice and download the pdfs with and without header_footer
    And Close the popup after downloading pdfs with and without header_footer
    And clicking on the brand logo
    Then clicking on the labtechnician role
    Then dashboard will be opened for labtechnician
    And Managereports searching
