Feature: Test Scroll Functionality
  @ScrollPage @ScrollUpDownUsingArrow
  Scenario: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    When Home Page is visible successfully
    And  User scrolls down page to bottom
    And User should go to subscription Section in Home Page
    And User Clicks on arrow at bottom right side to move upward
    Then Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @ScrollPage @ScrollUpDownWithoutArrow
  Scenario: Verify Scroll Up and Scroll Down functionality without Arrow
    When Home Page is visible successfully
    And  User scrolls down page to bottom
    And User should go to subscription Section in Home Page
    And Scroll up page to top
    Then Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
