Feature: Writing prescription to a patient through teleconsultation

  Scenario: Booking doctor appointment and doing consultation through video
    Given navigates to nh_url1 "https://customer.nanohealthplan.com/users/sign_in"
    Then enter email13 "sunilk@nh.com" password13 "Chakra@1"
    And clicking signin button from loginpage
    Then select the cdp nanohealthplan and role cdpadmin to delete the existing patient
    And click on brand logo and select the clinic manager role to register patient in nanohealthplan cdp
    Then register a new patient and book the doctor appointment for video appointment
    Then signout from the clinic manager role in nanohealth cdp
    And logins to the doctor role
    Then search patient and click on the consult button
    And click on the send link option from popup and enter mailid and click submit
    When submit is clicked link will sent to entered mailid or mobile
    And patient will join teleconsultation by clicking on the link
    When patient will join then both doctor and patient screens will display and doctor writes the prescription through teleconsultation
# Then entering the consultation type data
# And entering the accompainedby data in prescription
# Then entering the patient history in prescription
# And select the comorbidity and click enter to select and enter duration and notes
# Then search and add the comorbidity and select and enter the duration
# And remove one of the comorbidity
# Then click on symptoms and select by clicking enter button and enter duration
# And search and select the symptom and enter and select the duration
# Then click on the diagnosis and select one and choose type
# And select another and remove one of them
# And adding vitals in the prescription form
# Then click on the medicine field and select one medicine using enter button and add notes
# And click on the questionmark icon to create new brand in the prescription
# Then select the dosage route time frequency duration and type of newly added brand
# And select the existing brand using arrow keys and remove one of the brand
# Then enter the nextvisitdate and select the nextvisittype
# And select the labs through keys and search remove one of them after adding
# Then click on the request button
# And select the procedures and enter the comments
# Then select the painscale
# And click on attachment and upload any file pdf
# Then click on the medicalsummary and close the popup
# And click on the notes and add some notes and close the popup
# Then click on the fav prescription and close the popup
# And click on the last prescription and close the popup
# Then click on the labreports and close the popup
# And click on the save as draft button to save draft prescription
# Then click on the add prescription button again and click on save button
# And in preview prescription download pdf with and without header and footers
# Then share the prescription pdf with the patient email or mobile
# And click on the edit button to add one more medicine and save the prescription
# Then download and share the prescription after edit and save
# And from patient profile history sharing prescription and downloading the pdfs
# Then click on the load prescription then select the favourite prescription and click on it
# When favourite prescription is selected all the prescription data will be automatically filled up
# Then click on save button to save the prescription
# And download the pdfs and share the prescription through share prescription
