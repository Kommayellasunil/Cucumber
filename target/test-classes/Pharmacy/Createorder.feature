Feature: registering a patient and creating an order

  Background: 
    Given open nh portal "https://customer.nanohealthplan.com/users/sign_in"
    Then entering the username "Sunilk@nh.com" and password "Chakra@1"
    And clicking sign in button

  @createorder
  Scenario: registering a patient and creating an order
    Then selecting the profile for cdpadmin to delete the old patient
    And delete the patient and switch to the pharmacist role from cdpadmin role
    Then selecting the profile for pharmacist
    And click on register new patient from above page
    Then enter the details for the patient registration
    And click on the submit button to register the patient
    When patient is registered then create order page will be opened
    Then enter the brandname and enter the qty for the brandmaster
    Then click on the estimatebill button at the bottom of the page
    When estimatebill is clicked then order status will be new
    Then click on the manage orders new status tab and click on the orderid for the order created
    And download the estimate bill pdf and click on the delivered button
    When delivered button is clicked it will open the proformainvoice page
    And enter the amount and generate the invoice id and download the invoices pdfs
    And share the invoice to the patients emailid through share invoice
    Then create a new order with new invoice and merge both invoices from the all orders

  @returnmedicine
  Scenario: creating order for an patient and returning the ordered medicine
    When existing patient got deleted from the cdpadmin role then
    And register an new patient and order medicine and pay the bill amount
    Then return the medicine using return quantity from edit
