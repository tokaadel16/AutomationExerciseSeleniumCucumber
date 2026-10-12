Feature: Test Register Page1 Functionality

  @RegisterPage1 @SuccessfulRegistration
  Scenario:  To Register with valid Name and valid email address
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test18560@gmail.com" field and click on signup button rg
    Then User should move to second Registration Page


  @Register1 @EmailAlreadyExists
  Scenario:  To Register with email address already exists
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test123@gmail.com" field and click on signup button rg
    Then Error message should appear Email Address already exist!

  @Register1 @NameValidation
  Scenario:  To Register with empty name and valid email address
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "" field and "test5821@gmail.com" field and click on signup button rg
    Then Error Validation message should appear

  @Register1 @EmailValidation
  Scenario Outline: To Register with invalid emails
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "<username>" field and "<email>" field and click on signup button - email validation
    Then Error message should appear An email validation Error
    Examples:
      | username | email     |
      | Test     | Test123   |
      | test     | Test 123@ |






