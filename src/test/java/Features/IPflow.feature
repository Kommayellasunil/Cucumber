Feature: registering a patient in ipd hospital and loading advance amount

  @admit
  Scenario: Register a patient in ipd hospital
    Given naviagating to URL of NH_application "https://customer.nanohealthplan.com/users/sign_in"
    When NH url login page opens
    Then enter the email9 "sunilk@nh.com" password9 "Chakra@1"
    And click on the sign in button to login
    Then select the role as cdpadmin to delete exist patient
    And click on brand logo to change profile role to ipdclinicmanager
    Then click on the add patient icon from the ipdclinicmanager role
    Then select title_of_the_ip_patient
    When user enters the following details into registration form from the ipdhospital
    And click on the submit_button_to_register from the ipdhospital
    Then it will open the patient profile with admit now button
    And click on the advance button present in the right side
    Then enter the amount for advance payment
    And select the payment method radio button after entering advance amount
    Then click on the save button to save the advance amount
    When save is clicked it will show the loaded amount in the advance field button
    Then return some amount using return advance
    And deleting the already existing family member from cdpadmin role
    And click on the brandlogo and select the ipdclinicmanager role
    Then search and open the patient that want to admit from ipdhospital
    Then click on the admitnow button under the bookappointments section
    And select the insurance radio button and add insurance
    And click on add family member icon from primary attendant field
    Then add family member popup opens enter the details
    Then select the relation from the dropdown from the add family member
    Then click on the submit button add the family member
    And select the department from dropdown
    Then select the single from roomtype dropdown
    And select the lead doctor from dropdown
    Then select the familymember from dropdown
    And select admission type radio button
    Then select the ipdhospital from the dropdown on clicking admission site
    And click on the submit button from admitform
    When admit now form is submitted the status of patient will be changed to ip
    Then ip number will be generated then click on it to download the pdfs like consent form
    And edit the admit form and submit again
    Then click on the zero invoice amount id button
    And click on the add service and add one of the service and submit
    Then click on the bookipprocedures and book the appointment
    And assign the room and bed for the ippatient
    Then extend the bed date for the ippatients
    And book the doctor diagnostic appointments for the ippatient

  @ds
  Scenario: writing dischargesummary to an ippatient
    Given navigates to this urls "https://customer.nanohealthplan.com/users/sign_in"
    And login into doctor role with credentails
    Then doctor dashboard opens then select the ipd hospital
    And search the ippatient and click on dischargesummary button
    Then enter the provisional diagnosis at time of admission
    And select the diagnosis and add
    Then search the diagnosis in ds and add
    And enter the patient history in dischargesummary
    Then select the symptoms for ippatient in dischargesummary
    And enter hospitalcourse medication during hospital and condition on discharge
    Then enter the vitals for ippatient in dischargesummary
    And select the medicine1 for ippatient in dischargesummary
    Then add the lab and request
    And add the procedures in ds
    Then enter the nextvisitdate in the ds and enter the comments
    When editable picture is clicked it will open picture to add text
    Then add the text in the editable image and save
    And clicking on the medicalsummary and closing from ds
    And clicking on the notes and adding notes and closing from ds
    And clicking on the favourite dischargesummary and closing from ds
    And clicking on the last prescription and sharing admitform to a mailid and perfomring click action on all buttons
    And clicking on the labreports and closing from ds
    When save as draft is clicked it will redirects to patientprofile
    Then click on discharge summmary button again to save it
    When save button is clicked it will open preview ds from that page download pdfs and share ds to a mailid
    Then edit and save the dischargesummary
    And then download and share the pdfs from dischargesummary preview page
    Then click on close button and it will redirects to patientprofile page
    And load dischargesummary from history and add favourite dischargesummary
    Then save and download the pdfs and share it to mail
    Then signout and login to nanohealthipd to discharge patient
    When ipdhospital is opened search for patient and release bed
    Then discharge the patient from the hospital
