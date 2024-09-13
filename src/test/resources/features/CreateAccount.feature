@CreateAccount
Feature: Create new Account

  # Steps that are common between scenarios of specific feature
  # Background steps will execute at teh beginning of each scenario (and after the @Before hooks)
  Background: Setup create account scenarios
    When User clicks on 'Create Primary Account' link
    Then Verify 'Create Primary Account Holder' page is displayed

    @Scenario1
    Scenario: Navigate to Create Primary Account Holder page
      Then Validate form title is 'Create Primary Account Holder'

  @Scenario2
  Scenario: Create a primary account with all the required fields
    When User enters 'random email' value on 'Email Address' field
    When User enters 'Muhammad' on 'First Name' field
    When User enters 'Khusravi' on 'Last Name' field
    When User enters 'Employed' on 'Employment Status' field
    When User selects 'Mr.' from 'Title' dropdown
    When User selects 'Male' from 'Gender' dropdown
    When User selects 'Married' from 'Marital Status' dropdown
    When User enters DOB on date of birth field
    When User clicks on 'Create Account' button
    Then Validate email is matching 'random email'

  @Scenario3
  Scenario: Create account with existing email address and validate error message as expected
    When User enters '9rnlxkd4jn@hotmail.com' value on 'Email Address' field
    When User enters 'Muhammad' on 'First Name' field
    When User enters 'Khusravi' on 'Last Name' field
    When User enters 'Employed' on 'Employment Status' field
    When User selects 'Mr.' from 'Title' dropdown
    When User selects 'Male' from 'Gender' dropdown
    When User selects 'Married' from 'Marital Status' dropdown
    When User enters DOB on date of birth field
    When User clicks on 'Create Account' button
    Then Verify error message 'Account with email 9rnlxkd4jn@hotmail.com is exist' is displayed

  @Scenario4
  Scenario: Validate error message for less than 18 year of age for creating account
    When User enters 'random email' value on 'Email Address' field
    When User enters 'Garcia' on 'First Name' field
    When User enters 'Gonzalez' on 'Last Name' field
    When User enters 'Unemployed' on 'Employment Status' field
    When User selects 'Mr.' from 'Title' dropdown
    When User selects 'Male' from 'Gender' dropdown
    When User selects 'Single' from 'Marital Status' dropdown
    When User enters '10-10-2010' on 'Date Of Birth' field
    When User clicks on 'Create Account' button
    Then Verify error message 'you must be 18 years or older to create account' is displayed

  @Scenario5
  Scenario: Validate Full Name display at Profile Section by clicking on profile Icon After creating a valid account
    When User enters 'random email' value on 'Email Address' field
    When User enters 'Muhammad' on 'First Name' field
    When User enters 'Khusravi' on 'Last Name' field
    When User enters 'Employed' on 'Employment Status' field
    When User selects 'Mr.' from 'Title' dropdown
    When User selects 'Male' from 'Gender' dropdown
    When User selects 'Married' from 'Marital Status' dropdown
    When User enters DOB on date of birth field
    When User clicks on 'Create Account' button
    Then Validate email is matching 'random email'
    When User enters 'random username' value on 'Username' field
    When User enters 'MKPass@123' on 'Password' field
    When User enters 'MKPass@123' on 'Confirm Password' field
    When User clicks on 'Submit' button
    Then Verify 'Sign in to your Account' page is displayed
    When User enters newly created 'random username' value on 'Username' field
    When User enters 'MKPass@123' on 'Password' field
    When User clicks on 'Sign In' button
    Then Verify 'Primary Account Portal' page is displayed
    When User clicks on profile icon
    Then Verify 'Muhammad Khusravi' is displayed