Feature: Test The Login Functionality

  @SuccessfulLogin
  Scenario: To login with valid email address and valid password
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test18561@gmail.com" and password as "test123" and click on login button
    Then User click on logout button

  @Login @LoggedIn
  Scenario: Verify that User is logged in successfully
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test18561@gmail.com" and password as "test123" and click on login button
    Then Logged in as "Test" should be displayed

  @Login @AccountDeleted
  Scenario: Verify that Account Deleted successfully
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test18561@gmail.com" and password as "test123" and click on login button
    And User clicks on Delete Account LinkText
    Then Account Deleted Message should be displayed successfully

  @Login @invalidCredentials
  Scenario Outline: To login with invalid credentials
    Given User opens WebSite and go to Signup-Login Page
    When User should fill "<email_address>" and "<password>" and click on login button
    Then Error message should appear Your Email or Password is incorrect
    Examples:
      | email_address       | password |
      | Eleen@gmail.com     | Eleen123 |
      | eleen5000@gmail.com | eleen123 |
      | Eleen5000@gmail.com | eleen123 |

  @Login @EmailValidation
  Scenario: To login with invalid email address and valid password
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "eleen" and password as "Eleen123" and click on login button
    Then An email validation Error should appear