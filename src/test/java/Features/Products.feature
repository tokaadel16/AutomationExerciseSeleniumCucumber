Feature: Products Page Functionality

  @ProductsPage @SearchTextVisible
  Scenario: Make Sure that The Search Text Field is visible
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And Clicks on Products linkText
    Then Search Text Field should be visible

  @ProductsPage @ProductsListDisplayed
  Scenario: Make Sure that All Products list is displayed
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And  Clicks on Products linkText
    Then All Products list should be displayed successfully

  @ProductsPage @ProductsDetailsDisplayed
  Scenario: Make Sure that All Products Details are displayed
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And  Clicks on Products linkText
    And Clicks on view product LinkText
    Then All Products Details should be displayed successfully

  @ProductsPage @WomenCategoryExpansion
  Scenario: Verify Women Category Expansion
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And  Clicks on Products linkText
    And clicks on plus icon next to Women
    Then The Women subcategories should be displayed successfully

  @ProductsPage @Women-DressProductsExpansion
  Scenario: Verify Women-Dress Products Expansion
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And  Clicks on Products linkText
    And clicks on plus icon next to Women
    And click on Dress Category linkText
    Then Women-Dress Products should be displayed successfully

  @ProductsPage @AddNewProduct
  Scenario: Add New Product
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And Clicks on Products linkText
    And Clicks on view product LinkText and Clicks on Add to cart
    Then A New Product should be added

  @ProductsPage @BrandProducts
  Scenario: Verify Brand Products
    When  Clicks on Products linkText
    And Verify that Brands are visible on left side bar
    And Click on "POLO" brand name
    Then Verify that user is navigated to "POLO" brand page and brand products are displayed
    And Click on "MADAME" brand name
    Then Verify that user is navigated to "MADAME" brand page and brand products are displayed

  @ProductsPage @AddReviewOnProducts
  Scenario: Add Review on Product
    When  Clicks on Products linkText
    And   All Products list should be displayed successfully
    And Clicks on view product LinkText
    And Write Your Review is visible
    And User enters Name and Email and Review and Clicks on submit Button
      | Name   | Ahmed                     |
      | Email  | ahmed@g                   |
      | Review | Quality of product is bad |
    Then Thank you for your review should be displayed

  @ProductsPage @SearchProductField
  Scenario Outline: Test Search Product Field
    Given User opens WebSite and go to Signup-Login Page
    When User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And  Clicks on Products linkText
    And Users enters "<productName>" in Search Product Field
    Then Searched Products section should be displayed
    Examples:
      | productName |
      | Blue        |
      | top         |
      | shirt       |


  @ProductsPage @SearchProductFieldAndVerifyCartAfterLogin
  Scenario Outline: Test Search Product Field and Verify Cart After Login
    Given User opens WebSite and go to Signup-Login Page
    When  Clicks on Products linkText
    And All Products list should be displayed successfully
    And User clears The Cart
    And Users enters "<searchTerm>" in Search Product Field
    And Searched Products section should be displayed
    And Verify all the products related to "<searchTerm>" are visible
    And Add "<searchTerm>" products to cart
    And User clicks on Cart linkText
    And verify that products are visible in cart
    And  Click Register-Login button
    And User should fill email as "test8540@gmail.com" and password as "test123" and click on login button
    And User clicks on Cart linkText
    Then verify that products are visible in cart
    Examples:
      | searchTerm |
      | Blue       |
      | top        |
      | shirt      |