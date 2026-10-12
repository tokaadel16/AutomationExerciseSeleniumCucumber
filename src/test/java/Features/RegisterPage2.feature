Feature: Test RegisterPage2 Functionality

  @RegisterPage2 @SuccessfulRegistration
  Scenario: To Register with valid Registration details
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test18561@gmail.com" field and click on signup button rg
    And User enters valid registration details and clicks on Create Account Button
      | title         | Mrs.          |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |

    Then Account should be created successfully


  @RegisterPage2 @PasswordValidation
  Scenario: To Register without entering Password
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test18562@gmail.com" field and click on signup button rg
    And User fills all required registration details except password field and clicks on Create Account Button
      | title         | Mr.           |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then Password required validation should be displayed


  @RegisterPage2 @FirstNameValidation
  Scenario: To Register without entering First name
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test18563@gmail.com" field and click on signup button rg
    And User fills all required registration details except First name field and clicks on Create Account Button
      | title         | Mr.           |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then First name required validation should be displayed

  @RegisterPage2 @LastNameValidation
  Scenario: To Register without entering Last name
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test18564@gmail.com" field and click on signup button rg
    And User fills all required registration details except Last name field and clicks on Create Account Button
      | title         | Mrs.          |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then Last name required validation should be displayed

  @RegisterPage2 @AddressValidation
  Scenario: To Register without entering Address
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8565@gmail.com" field and click on signup button rg
    And User fills all required registration details except Address field and clicks on Create Account Button
      | title         | Mr.           |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then Address required validation should be displayed

  @RegisterPage2 @CountryValidation
  Scenario: To Register without entering Country
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8566@gmail.com" field and click on signup button rg
    And User fills all required registration details except Country field and clicks on Create Account Button
      | title         | Mrs.       |
      | password      | test123    |
      | Day           | 15         |
      | Month         | September  |
      | Year          | 1999       |
      | first_name    | Test       |
      | last_name     | automation |
      | Company       | AURA       |
      | Address       | Benha      |
      | State         | Islam Abad |
      | City          | Delhi      |
      | zipcode       | 1234       |
      | mobileNumber | 0555555     |
    Then Country required validation should be displayed

  @RegisterPage2 @StateValidation
  Scenario: To Register without entering State
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8567@gmail.com" field and click on signup button rg
    And User fills all required registration details except State field and clicks on Create Account Button
      | title         | Mr.           |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | City          | Delhi         |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then State required validation should be displayed

  @RegisterPage2 @CityValidation
  Scenario: To Register without entering City
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8668@gmail.com" field and click on signup button rg
    And User fills all required registration details except City field and clicks on Create Account Button
      | title         | Mr.           |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | zipcode       | 1234          |
      | mobileNumber | 0555555        |
    Then City required validation should be displayed


  @RegisterPage2 @ZipCodeValidation
  Scenario: To Register without entering zipcode
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8669@gmail.com" field and click on signup button rg
    And User fills all required registration details except zipcode field and clicks on Create Account Button
      | title         | Mr.           |
      | password      | test123       |
      | Day           | 15            |
      | Month         | September     |
      | Year          | 1999          |
      | first_name    | Test          |
      | last_name     | automation    |
      | Company       | AURA          |
      | Address       | Benha         |
      | Country       | United States |
      | State         | Islam Abad    |
      | City          | Delhi         |
      | mobileNumber | 0555555        |
    Then ZipCode required validation should be displayed

  @RegisterPage2 @MobileNumberValidation
  Scenario: To Register without entering mobileNumber
    Given User opens WebSite and go to Signup-Login Page
    When User should Fill "Test" field and "test8670@gmail.com" field and click on signup button rg
    And User fills all required registration details except mobileNumber field and clicks on Create Account Button
      | title      | Mr.           |
      | password   | test123       |
      | Day        | 15            |
      | Month      | September     |
      | Year       | 1999          |
      | first_name | Test          |
      | last_name  | automation    |
      | Company    | AURA          |
      | Address    | Benha         |
      | Country    | United States |
      | State      | Islam Abad    |
      | City       | Delhi         |
      | zipcode    | 1234          |
    Then mobileNumber required validation should be displayed
