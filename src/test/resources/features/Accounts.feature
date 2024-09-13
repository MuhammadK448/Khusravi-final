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
      #Then Validate 5 row per page is the default
      Then Validate 5 row of data is present

      Scenario: Verify number of rows per page is based on selected show per page dropdown
        When User selects <rowCount> from <showPerPage> dropdown