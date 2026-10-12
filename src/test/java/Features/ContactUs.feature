Feature: Contact Us Functionality

  @ContactUsPage @ContactUsPageIsDisplayed
  Scenario: Verify Contact Us Page is displayed Successfully
    When Clicks on Contact us linkText
    Then Contact us Page should be displayed

  @ContactUsPage @ContactUsPagedDetails
  Scenario: Verify Contact Us details is submitted Successfully
    When Clicks on Contact us linkText
    And Users enters contact us details and clicks on submit btn
      | Name    | Ahmed                                                      |
      | Email   | Ahmed@gmail.com                                            |
      | Subject | Product complaint                                          |
      | Message | when I choose a product and add it to cart,it is not added |
      | fileName | test-document.pdf                                         |
    Then User's details have been submitted successfully.


