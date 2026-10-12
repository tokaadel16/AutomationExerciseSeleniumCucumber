Feature: Test Cases Page Functionality

  @TestCasesPage
  Scenario: Verify Test Cases Page is displayed
    When Clicks on Test Cases linkText
    Then Test Cases should be visible