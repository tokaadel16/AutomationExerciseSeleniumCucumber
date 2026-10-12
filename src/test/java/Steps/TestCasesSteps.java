package Steps;

import Pages.TestCasesPage;
import Pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestCasesSteps extends BasePage {
    TestCasesPage tCasePage = new TestCasesPage();

    //Test Case 7: Verify Test Cases Page
    @When("Clicks on Test Cases linkText")
    public void clickOnTestCasesLinkTxt() {
        tCasePage.clickOnTestCasesLinkTxt();
    }

    @Then("Test Cases should be visible")
    public void testCasesShouldBeVisible() {
        tCasePage.verifyTestCasePageDisplayed();
    }
}
