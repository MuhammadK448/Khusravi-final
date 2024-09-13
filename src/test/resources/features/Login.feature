@Login
Feature: Navigate to Login page

  Background: Login with valid and invalid credentials
    When User clicks on 'Login' link
    Then Verify 'Sign in to your Account' page is displayed


  Scenario: Validate user navigate to Customer Service Portal
    When User enters 'supervisor' on 'Username' field
    When User enters 'tek_supervisor' on 'Password' field
    When User clicks on 'Sign In' button
    Then Verify 'Customer Service Portal' page is displayed

  Scenario Outline: Validate login with invalid credentials2222
    When User enters <username> on <usernameInput> field
    When User enters <password> on <passwordInput> field
    When User clicks on <buttonText> button
    Then Verify error message <expectedMessage> is displayed
    Examples:
      | username     | usernameInput | password         | passwordInput | buttonText | expectedMessage             |
      | 'Wrongvisor' | 'Username'    | 'tek_supervisor' | 'Password'    | 'Sign In'  | 'User Wrongvisor not found' |
      | 'supervisor' | 'Username'    | 'Wrong_Pass'     | 'Password'    | 'Sign In'  | 'Password not matched'      |