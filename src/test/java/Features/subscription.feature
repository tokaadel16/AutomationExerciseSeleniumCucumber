Feature: Test Subscription Functionality
  @SubscriptionSectionInHomePage
  Scenario: Verify Subscription Section in Home Page
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    Then User should go to subscription Section in Home Page

  @SuccessfulSubscriptionInHomePage
  Scenario Outline: To Subscribe Successfully in Home Page
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User enters "<subscribed_email>" and clicks on its Button
    Then User should have been subscribed Successfully
    Examples:
      | subscribed_email |
      | test5@gmail.com  |
      | test9@gmail.com  |

  @SubscriptionSectionInHomePage @EmailValidation
  Scenario Outline: To Subscribe in Home Page with invalid email
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User enters "<invalid_email>" and clicks on its Button2
    Then An Email validation message should be displayed
    Examples:
      | invalid_email |
      | test5         |
      | test9@        |
      | test          |


  @SubscriptionSectionInHomePage @EmptyEmail
  Scenario: To Subscribe in Home Page with empty email
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User leaves subscription email empty and clicks subscribe
    Then An empty email validation error should be displayed

  @SubscriptionSectionInCartPage
  Scenario: Verify Subscription Section in Cart Page
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User clicks on Cart linkTxt
    Then User should go to subscription section in Cart Page

  @SuccessfulSubscriptionInCartPage
  Scenario Outline: To Subscribe Successfully in Cart Page
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User clicks on Cart linkTxt
    And User enters "<subscribed_email>" and clicks on its Button
    Then User should have been subscribed Successfully
    Examples:
      | subscribed_email |
      | test5@gmail.com  |
      | test9@gmail.com  |


  @SubscriptionSectionInCartPage @EmailValidation
  Scenario Outline: To Subscribe in Cart Page with invalid email
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User clicks on Cart linkTxt
    And User enters "<invalid_email>" and clicks on its Button2
    Then An Email validation message should be displayed
    Examples:
      | invalid_email |
      | test5         |
      | test9@        |
      | test          |

  @SubscriptionSectionInCartPage @EmptyEmail
  Scenario: To Subscribe in Cart Page with empty email
    When Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User clicks on Cart linkTxt
    And User leaves subscription email empty and clicks subscribe
    Then An empty email validation error should be displayed