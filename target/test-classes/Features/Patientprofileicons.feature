Feature: Patient profile icons

  Scenario Outline: Patient profile icons
    Given navigate to the nanohealth web application portal "https://customer.nanohealthplan.com/users/sign_in"
    Then login with the details
      | email    | Sunilk@nh.com |
      | password | Chakra@1      |
    And clicking on the signin button
    Then select the profile with facility type
    And deleting the existing patient using search bar
    Then patient deleted successfully
    And click on the add patient icon for new registration of patient
    Then select title of the patient
    When user enter the following details into the registration form
      | firstname    | Demo       |
      | lastname     | Icons      |
      | age          |         25 |
      | phone        | 8811718907 |
      #| email        | demoyey@gmail.com |
      | addressline1 | Hyderabad  |
      | addressline2 | Hyderabad  |
      | landmark     | Ameerpet   |
      | city         | test       |
    Then selecting radio_buttons for new registration
    And click on the submit to register patient
    Then it will redirect to patient profile
    When patient profile is opened
    #edit profile
    Then click on the pencil icon to the edit details
    And select the programme name from dropdown
    Then click on the submit button to save changes
    #adding new address
    Then click on the Home icon from the left side beside patient profile image
    And click on the add new address
    Then enter the following details under new address1
      | Address line1 | Hyderabad     |
      | Address line2 | Hyderabad     |
      | Area          | Area test     |
      | Landmark      | Banjara Hills |
      | District      | Khairatabad   |
    And selecting city from the dropdown for new address
    Then entering the pincode
    When user click on the save button for new address
    Then it will redirect to the addresses page popup
    Then updating the pincode for the new address
    And clicking on the save button for new address in edit address page
    And deleting the already existing address
    Then closing the addresses popup
    #adding new contact
    And click on the contact icon beside of home icon
    Then contact popup will open
    And click on the add new contact
    Then enter the following details under new contact1
      | Contact type | Personal |
    And select the country code for new contact from dropdown
    Then enter the following details under new contact2
      | Mobile number |                76543345678 |
      | Email         | demoiconscontact@gmail.com |
    And click on the save button for new contact
    And updating the contact by clicking edit
    Then saving it
    Then closing the contact popup
    #downloading identification qr code
    And click on the add identification icon
    Then clicking on the qr code
    And adding one identification aadhar no
    And closing the identification popup
    Then adding another mr number identification
    And deleting one identification of the patient
    #files
    Then click on the files icon
    And entering the label name
    Then clicking on the upload icon
    And sending the file
    Then click on the submit button from files popup
    When file uploaded
    Then clicking on the uploaded pdf
    And closing the file popup
    #add referral
    Then clicking on the add referral icon
    And selecting the referral type as TV
    Then clicking on the submit in referral popup
    When referral is added
    Then mouse hovering to the add referral
    #program
    And mouse hovering to the program icon
    #sharing credentials
    Then click on the share credentials icon
    #And click on the yes button in the share credentials popup
    #insurance
    Then clicking on the insurance button
    And click on the plus button in insurance popup
    When new insurance popup opens
    And select the insurance radio button from the new insurer popup
    Then enter the following in the insurance popup
      | ID Number |    102 |
      | Policy no | 123456 |
    And select the policy start and end dates
    Then clicking on the save button from insurance popup
    And clicking on the edit and updating the policy no
    Then saving the insurance with new policy no
    And adding new insurance
    Then deleting the newly added insurance
    And closing the insurance popup
    #corporate
    And click on the corporate button to create a new corporate
    Then save the corporate with employee details
    And edit and save the corporate details
    #transfer
    #Then click on the transfer icon and transfer the patient to another hospital
    #reviews
    Then click on the reviews icon
    And clicking on the plus button in the review popup
    Then giving the ratings and entering the comments
    And clicking on the submit from the add review popup
    Then adding another review and submitting
    And editing the comments and deleting one review
    Then closing the review popup
    #assigncareteam
    And clicking on the careteam icon
    Then clicking on the plus button in the careteam popup
    And selecting provider type and name
    Then assigning another and deleting it
    Then clicking on the submit button
    
    #allergies
    And click on the Add Allergies from the patient profile
    Then add allergies popup will be opened click on the add button to add
    And select the allergie type and enter the text for allergie
    Then click on add button again to add new allergie
    And select the type of allergie and enter the allergie text
    Then click on the submit button to save the allergies
    And mouse hover on the Add Allergies to show the added allergies and click on any one allergie
    Then allergies will be opened remove one allergie and submit again
    And mouse hover on the add allergies again to show the updated
    #bookingappointments
    Then book doctor,dietitian,lab appointments for the patient
    When appointments where booked click on notes and add
    #mergepatient
    Then copy the patient id for merge
    And register a new patient and click on the merge patient button and paste the copied patient id
    Then after merging old patient data records will be applied to the new patient
    #patient engagement
    And clicking on the patient engagement icon
    When patient engagemnet popup opens
    Then select the engagement method from the dropdown
    And select the date for engagement as today
    Then select the time for engagement
    And enter the sms text in the sms field
    Then click on the send icon beside of the sms field
    When send icon is clicked it will sent sms successfully
    Then select the status from the dropdown
    And enter the engagement description
    Then click on the submit button in the engagement popup
    When history updated
    Then close the engagement popup
    #uploads
    #doctor visit upload
    And mouse hover to upload reports and click on the upload doctor visit
    When doctor visit popup opens from the upload reports
    Then enter the doctors first_last name
    And select the hospital name for doctor visit upload
    Then uploading the visit report pdf for doctor visit upload
    And selecting diagnosis for doctor visit
    And entering the notes for doctor visit
    Then clicking on the submit button to save doctor visit upload
    #dietician visit upload
    And mouse hover to upload reports and click on the upload dietician visit
    When dietician visit popup opens from the upload reports
    Then select the visit date for dietician upload visit
    And enter the dietician first_last name
    Then select the hospital name
    And uploading the visit report pdf
    Then clicking on the submit button to save dietician visit upload
    #lab report upload
    And mouse hover to upload reports and click on the upload diagnostic visit
    When diagnostic visit popup opens from the upload reports
    Then select the visit date for diagnostic upload visit
    And enter the lab name for diagnostic upload visit
    Then upload the diagnostic report pdf
    And clicking on the submit button to save diagnostic visit upload
    #discharge summary
    And mouse hover to upload reports and click on the upload discharge summary
    When discharge summary  popup opens from the upload reports
    Then select the visit date for discharge summary
    And clicking on the submit button to save discharge summary
    #forms
    Then mouse hover to the forms icons under uploads section
    And mouse hover again on to the form names
    Then click on the form name
    And clicking on the pdf to download the form
    Then downloaded pdf will open in another tab
    When navigating back to the parent window
    And enter the details into the selected form
    Then click on the submit to save the form details
    When form is submitted it will save into the history of the patient
    #histroy-discharge summary
    Then click on the discharge summary
    And click on print pdf for discharge summary
    Then ds pdf will open on new tab get back to the parent window
    And click on another pdf for discharge summary
    Then clicking on the dischare summary to close row
    When row closed for dischare summary
    #dietician visit
    Then click on the dietician visit
    And click on print with header and footer for dietician visit
    Then pdf will open on new tab get back to the parent window for dietician visit
    And click on print pdf for dietician visit
    Then share invoice to gmail clearing mobile number for for dietician visit
    When invoice shared again clicking on dietician visit to close
    #diagnostic report
    Then clicking on the diagnostic report
    And click on print pdf for diagnostic report
    Then diagnostic report pdf will open on new tab get back to the parent window
    And click on another pdf for diagnostic report
    Then clicking on the diagnostic report to close row
    When row closed for diagnostic report
    #prescription
    Then click on the prescription
    And click on print with header and footer for prescription
    Then pdf will open on new tab get back to the parent window for prescription
    And click on print pdf for prescription
    Then share invoice to gmail clearing mobile number for for prescription
    When invoice shared again clicking on prescription to close

    Examples: 
      | cmemail           | cmpassword |
      | sunilk@nh.com | Chakra@1  |
