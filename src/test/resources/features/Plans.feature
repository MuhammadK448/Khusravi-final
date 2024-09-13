@Plans
Feature: Plan data table

  Background: Plan data table info validation
    When User clicks on 'Login' link
    Then Verify 'Sign in to your Account' page is displayed
    When User enters 'supervisor' on 'Username' field
    When User enters 'tek_supervisor' on 'Password' field
    When User clicks on 'Sign In' button
    Then Verify 'Customer Service Portal' page is displayed
    When User clicks on 'Plans' link
    Then Verify "Plans Price" page is displayed

    Scenario: Validate 4 row of data is present in plan page
      Then Validate 4 row of data is present

      Scenario: Validate data table created and expiry dates
        Then Verify Create Date is todays date
        Then Verify Expiry Date is the next day