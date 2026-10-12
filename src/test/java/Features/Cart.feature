Feature: Test Cart Functionality

  @CartPage @AddProductsToCart
  Scenario: Verify Products are added to Cart Successfully
    When Clicks on Products linkText
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    Then Clicks on view cart and Check both products are added


  @CartPage @ProductQuantity
  Scenario: Verify Product Quantity in Cart
    When Clicks on Products linkText
    And Clicks on view product
    And User sets product quantity to 4
    And Clicks on Add to cart
    Then Product Quantity should be 4

  @CartPage @RemoveProducts
  Scenario: Verify Products Removal from Cart
    When Clicks on Products linkText
    And Users Adds product "Blue Top" to cart and clicks on Continue btn
    And Users Adds product "Men Tshirt" to cart
    And User clicks on Cart linkText
    And Verify that cart page is displayed
    And Clicks on x button corresponding to "Blue Top" product
    And Clicks on x button corresponding to "Men Tshirt" product
    Then Products should be removed from cart

  @CartPage @AddProductsFromRecommendedItems
  Scenario: Verify Add To Cart From Recommended Items
    When User scrolls to Bottom of Page and Recommended Items are visible
    And Users adds product "Stylish Dress" to cart
    And Clicks on view cart
    Then Verify that "Stylish Dress" is displayed in cart page
