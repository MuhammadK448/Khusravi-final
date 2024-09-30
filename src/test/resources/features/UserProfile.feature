@UserProfile @Regression
Feature: User Profile Validation

  Background: User profile page validation
    When User clicks on 'Login' link
    Then Verify 'Sign in to your Account' page is displayed
    When User enters 'supervisor' on 'Username' field
    When User enters 'tek_supervisor' on 'Password' field
    When User clicks on 'Sign In' button
    Then Verify 'Customer Service Portal' page is displayed
    When User clicks on profile icon

    Scenario: Validate Profile Side Drawer information is correct
      Then Verify sidebar is displayed
      Then Validate user status is 'Active'
      Then Validate 'USER TYPE' value is 'CSR'
      Then Validate 'FULL NAME' value is 'Supervisor'
      Then Validate 'USERNAME' value is 'supervisor'
      Then Validate Authorities is 'admin'

  Scenario: Validate clicking on logout button navigates to login page
      When User clicks on 'Logout' button
      Then Verify 'TEK Insurance App' page is displayed