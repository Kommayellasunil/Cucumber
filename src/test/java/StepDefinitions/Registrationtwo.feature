Feature: registering another patient
@registration 
Scenario Outline: registering the another patient

Given navigate to nanohealth web portal
Then login with_the <email> and <password>
And clicking on sign_in_button
Then selecting the profile
And clicking on the add_patient_icon for new registration
Then selecting the title_of_patient
When user enters the following details
|firstname   |test|
|lastname    |sunil|
|age         |30 |
|phone       |7788990011|
|email       |jays@gmail.com|
|addressline1|test|
|addressline2|test|
|landmark    |test|
|landmark2   |testlandmark|
|district    |test|
|pincode     |123456|
|aadharcard  |123456789012|

Then selecting radio_buttons
And clicking on the submit_to_register
Then it will redirect to the patient_profile

Examples:
|email            |password	|
|sunilcm@gmail.com|Demo@1234|