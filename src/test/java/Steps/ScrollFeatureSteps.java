package Steps;

import Pages.BasePage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScrollFeatureSteps extends BasePage{
    HomePage hmPage = new HomePage();

    //Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    @When("Home Page is visible successfully")
    public void homePageIsVisibleSuccessfully(){
        hmPage.homePageIsVisible();
    }

    @And("User scrolls down page to bottom")
    public void userScrollsDownPageToBottom() {
        hmPage.scrollDownPageToBottom();
    }

    @And("User Clicks on arrow at bottom right side to move upward")
    public void userClicksOnArrowAtBottomRightSideToMoveUpward() {
        hmPage.clickOnScrollUpBtn();
    }

    @Then("Verify that page is scrolled up and {string} text is visible on screen")
    public void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen(String expectedText) {
        hmPage.verifyHeaderTextIsVisible(expectedText);
    }

    //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    @And("Scroll up page to top")
    public void scrollUpPageToTop() {
        hmPage.scrollUpPageToTop();
    }
}
