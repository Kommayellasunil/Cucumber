Feature: Reports search and downloading the reports

  Background: 
    Given naviagate to portal "https://customer.nanohealthplan.com/users/sign_in"
    Then enter username5 "Sunilk@nh.com" and password6 "Chakra@1"
    And click on the button sign in
    Then select the role as the pharmacist role

  @Reports
  Scenario: Receipts search and downloading the reports
    And pharmacist dashboard opens click on the reports and select the receipt button
    When receipt button is selected dashboard opens
    Then search with from and to dates
    And click on the received at counter and close
    Then tclick on the received at counter and download the report
    Then click on the internal transfer and close
    Then click on the delivered and download the report
    And click on the redeem and download the report
    Then click on the reports and select the expiry report button
    And search a brand with expiry dates selection and download the report
    Then click on the reports and select the pharmacy price contracts
    And add a brand and select the dates and save
    Then click on the reports and select the brand consumptions
    And enter any brand and select the dates and search the brand consumption

  @Billing
  Scenario: Billing reports search and downloading the reports
    And clicking on the billing and select the dialyreport
    Then search and download the reports for dialyreport
    And clicking on the billing and select the patientwisereport
    Then search and download the reports for patientwisereport
    And clicking on the billing and select the monthlyreport
    Then search and download the reports for monthlyreport
    And clicking on the billing and select the gstreport
    Then search and download the reports for gstreport
    And clicking on the billing and select the brandwisereport
    Then search and download the reports for brandwisereport
    And clicking on the billing and select the distributorwisereport
    Then search and download the reports for distributorwisereport
    And clicking on the billing and select the annualgstreport
    Then search and download the reports for annualgstreport
    And clicking on the billing and select the dueamountreport
    Then search and download the reports for dueamountreport
    And clicking on the billing and select the profitreport
    Then search and download the reports for profitreport
    And clicking on the billing and select the reorderplan
    Then search and download the reports for reorderplan
