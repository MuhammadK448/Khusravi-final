@Accounts @Regression
Feature: Accounts Feature

  Background: Plan data table info validation
    When User clicks on 'Login' link
    Then Verify 'Sign in to your Account' page is displayed
    When User enters 'supervisor' on 'Username' field
    When User enters 'tek_supervisor' on 'Password' field
    When User clicks on 'Sign In' button
    Then Verify 'Customer Service Portal' page is displayed
    When User clicks on 'Accounts' link
    Then Verify "Primary Accounts" page is displayed

  Scenario: Verify 5 rows per page is the default
    Then Validate 5 row of data is present

  Scenario Outline:
    When User selects <recordsToDisplay> from show records per page dropdown
    Then Validate <selected> number of records displayed
    Examples:
      | recordsToDisplay | selected |
      | '10'             | 10     |
      | '25'             | 25     |
      | '50'             | 50     |