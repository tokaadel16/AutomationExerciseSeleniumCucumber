Feature: Test Place Order Functionality

  @OrderPage @PlaceOrderWithRegistrationWithCheckOut
  Scenario: Verify Place Order and Register while Checkout
    When Home Page is visible successfully
    And Clicks on Products linkText
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart linkText
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Click Register-Login button
    And User should Fill "Test" field and "test18580@gmail.com" field and click on signup button rg
    And User enters valid registration details and clicks on Create Account Button-order place
      | title        | Mr.       |
      | password     | test123   |
      | Day          | 15        |
      | Month        | September |
      | Year         | 1999      |
      | first_name   | Ahmed     |
      | last_name    | Ali       |
      | Company      | ora       |
      | Address      | Degwa     |
      | Country      | India     |
      | State        | Qalyubia  |
      | City         | Benha     |
      | zipcode      | 1234      |
      | mobileNumber | 0555555   |

    And Account should be created successfully-orderPg
    And Logged in as "Test" should be displayed orderPg
    And User clicks on Cart btn
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details: Name on Card, Card Number, CVC, Expiration date
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    And Verify success message Your order has been placed successfully!
    Then Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button

  @OrderPage @PlaceOrderWithRegistrationBeforeCheckout
  Scenario: Verify Place Order and Register before Checkout
    When Home Page is visible successfully
    And Click Register-Login button
    And User should Fill "Test" field and "test18580@gmail.com" field and click on signup button rg
    And User enters valid registration details and clicks on Create Account Button-order place
      | title        | Mr.       |
      | password     | test123   |
      | Day          | 15        |
      | Month        | September |
      | Year         | 1999      |
      | first_name   | Ahmed     |
      | last_name    | Ali       |
      | Company      | ora       |
      | Address      | Degwa     |
      | Country      | India     |
      | State        | Qalyubia  |
      | City         | Benha     |
      | zipcode      | 1234      |
      | mobileNumber | 0555555   |

    And Account should be created successfully-orderPg
    And Logged in as "Test" should be displayed orderPg
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details: Name on Card, Card Number, CVC, Expiration date
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    And Verify success message Your order has been placed successfully!
    Then Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button

  @OrderPage @PlaceOrderWithLogin
  Scenario: Verify Place Order and  Login before Checkout
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details: Name on Card, Card Number, CVC, Expiration date
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    And Verify success message Your order has been placed successfully!
    Then Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button

  @OrderPage @AddressDetails
  Scenario: Verify address details in checkout page
    When Home Page is visible successfully
    And Click Register-Login button
    And User should Fill "Test" field and "test18580@gmail.com" field and click on signup button rg
    And User enters valid registration details and clicks on Create Account Button-order place
      | title        | Mr.       |
      | password     | test123   |
      | Day          | 15        |
      | Month        | September |
      | Year         | 1999      |
      | first_name   | Ahmed     |
      | last_name    | Ali       |
      | Company      | ora       |
      | Address      | Degwa     |
      | Country      | India     |
      | State        | Qalyubia  |
      | City         | Benha     |
      | zipcode      | 1234      |
      | mobileNumber | 0555555   |

    And Account should be created successfully-orderPg
    And Logged in as "Test" should be displayed orderPg
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify that the delivery address is same address filled at the time registration of account
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And Verify that the billing address is same address filled at the time registration of account
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    Then Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button

  @OrderPage @DownloadInvoice
  Scenario: Test Download Invoice after purchase order
    When Home Page is visible successfully
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart linkText
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Click Register-Login button
    And User should Fill "Test" field and "test18551@gmail.com" field and click on signup button rg
    And User enters valid registration details and clicks on Create Account Button-order place
      | title        | Mr.       |
      | password     | test123   |
      | Day          | 15        |
      | Month        | September |
      | Year         | 1999      |
      | first_name   | Ahmed     |
      | last_name    | Ali       |
      | Company      | ora       |
      | Address      | Degwa     |
      | Country      | India     |
      | State        | Qalyubia  |
      | City         | Benha     |
      | zipcode      | 1234      |
      | mobileNumber | 0555555   |

    And Account should be created successfully-orderPg
    And Logged in as "Test" should be displayed orderPg
    And User clicks on Cart btn
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details: Name on Card, Card Number, CVC, Expiration date
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    And Verify success message Your order has been placed successfully!
    And Click Download Invoice button and verify invoice is downloaded successfully.
    And Click on Continue Btn
    Then Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button

  @OrderPage @CardNameValidation
  Scenario: Verify Place Order and  Login before Checkout Without entering Card Name
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details except  Name on Card
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    Then Card Name Validation Message should appear

  @OrderPage @CardNumberValidation
  Scenario: Verify Place Order and  Login before Checkout Without entering Card Number
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details except Card Number
      | Card-Name   | Test User |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    Then Card Number Validation Message should appear

  @OrderPage @CardCvcValidation
  Scenario: Verify Place Order and  Login before Checkout Without entering Card CVC
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details except CVC
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | ExpiryMonth | 03        |
      | ExpiryYear  | 2028      |
    Then Card CVC Validation Message should appear


  @OrderPage @ExpiryMonthValidation
  Scenario: Verify Place Order and  Login before Checkout Without entering Card Expiration Month
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details except Expiration Month
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryYear  | 2028      |
    Then Card Expiration Month Validation Message should appear

  @OrderPage @ExpiryYearValidation
  Scenario: Verify Place Order and  Login before Checkout Without entering Card Expiration Year
    When Home Page is visible successfully
    And Click Register-Login button
    And User should fill email as "test8550@gmail.com" and password as "test123" and click on login button
    And Logged in as "Ahmed" should be displayed
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart btn
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify Address Details and Review Your Order
      | first_name   | Ahmed    |
      | last_name    | Ali      |
      | Company      | ora      |
      | Address      | Degwa    |
      | Country      | India    |
      | State        | Qalyubia |
      | City         | Benha    |
      | zipcode      | 1234     |
      | mobileNumber | 0555555  |
    And User enters "Please deliver during business hours." in comment text area and clicks Place Order
    And  Enter payment details except Expiration Year
      | Card-Name   | Test User |
      | Card-Number | 222225444 |
      | Cvc         | 215       |
      | ExpiryMonth | 03        |
    Then Card Expiration Year Validation Message should appear