package Steps;

import Pages.BasePage;
import Pages.SubscriptionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;



public class SubscribeFeatureSteps extends BasePage {
    SubscriptionPage subsPage = new SubscriptionPage();

    //Test Case 10: Verify Subscription in home page
    //Go to Subscription Section in Home Page
    @Then("User should go to subscription Section in Home Page")
    public void userShouldGoToSubscriptionSectionInHomePage() {
        subsPage.subscriptionTxtSection();
    }

    //User Subscribes Successfully
    @And("User enters {string} and clicks on its Button")
    public void userEntersAndClicksOnItsButton(String subscribedEmail) {
        scroll_down();
        subsPage.subscribeEmailAddress(subscribedEmail);
        subsPage.clickOnSubscribeBtn();

    }

    @Then("User should have been subscribed Successfully")
    public void userShouldHaveBeenSubscribedSuccessfully() {
        subsPage.verifyUserSubscribedSuccessfullyMessage();
    }

    //Subscription with invalid email
    @And("User enters {string} and clicks on its Button2")
    public void userEntersAndClicksOnItsButton2(String invalidEmail) {
        scroll_down();
        subsPage.subscribeEmailAddress(invalidEmail);
        subsPage.clickOnSubscribeBtn();
    }

    @Then("An Email validation message should be displayed")
    public void anEmailValidationMessageShouldBeDisplayed() {
        subsPage.verifyEmailValidationErrorMessage();
    }

    //Subscription with empty email
    @And("User leaves subscription email empty and clicks subscribe")
    public void userLeavesSubscriptionEmailEmptyAndClicksSubscribe() {
        scroll_down();
        subsPage.clickOnSubscribeBtn();
    }

    @Then("An empty email validation error should be displayed")
    public void anEmptyEmailValidationErrorShouldBeDisplayed() {
        subsPage.verifySubscribeWithEmptyEmail();
    }

    //Test Case 11: Verify Subscription in Cart page
    //Go to Subscription Section in Cart Page
    @And("User clicks on Cart linkTxt")
    public void userClicksOnCartLinkTxt() {
        subsPage.clickOnCartLinkTxt();
    }

    @Then("User should go to subscription section in Cart Page")
    public void userShouldGoToSubscriptionSectionInCartPage() {
        subsPage.subscriptionTxtSection();
    }
}
