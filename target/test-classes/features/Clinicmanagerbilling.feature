Feature: Billing

  Background: 
    Given open nh url "https://customer.nanohealthplan.com/users/sign_in"
    Then enter emailid "Sunilk@nh.com" and password "Chakra@1"
    And sign in button clicked
    Then select the cdp and clinic manager role

  @billing
  Scenario: Search and download the billing reports from clinic manager role
    And clicking on the billing and select the patientwisereport1
    Then search and download the reports for patientwisereport1
    And clicking on the billing and select the doctorwisereport1
    Then search and download the reports for doctorwisereport1
    And clicking on the billing and select the dueamountreport1
    Then search and download the reports for dueamountreport1
    And clicking on the billing and select the ipreport
    Then search and download the reports for ipreport
    And clicking on the billing and select the opreport
    Then search and download the reports for opreport
    And clicking on the billing and select the deleteinvoicereport
    Then search and download the reports for deleteinvoicereport
    And clicking on the billing and select the gstreport1
    Then search and download the reports for gstreport1
    And clicking on the billing and select the discountreport
    Then search and download the reports for discountreport
    And clicking on the billing and select the labpayout
    Then search and download the reports for labpayout
    And clicking on the billing and select the insurancereport
    Then search and download the reports for insurancereport
    And clicking on the billing and select the refundreport
    Then search and download the reports for refundreport
    And clicking on the billing and select the promocodetracking
    Then search and download the reports for promocodetracking
  
