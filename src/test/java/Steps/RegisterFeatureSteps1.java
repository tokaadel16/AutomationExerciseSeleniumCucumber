package Steps;

import Pages.BasePage;
import Pages.HomePage;
import Pages.RegisterPage1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterFeatureSteps1 extends BasePage {
    HomePage hmpage = new HomePage();
    RegisterPage1 rgPage1 = new RegisterPage1();

    //Successful Signup page1
    @Given("User opens WebSite and go to Signup-Login Page")
    public void userOpensWebSiteAndGoToSignupLoginPage() {
        hmpage.clickOnSignupLoginLink();
    }


    @When("User should Fill {string} field and {string} field and click on signup button rg")
    public void userShouldFillFieldAndFieldAndClickOnSignupButtonRg(String username, String email) {
        rgPage1.insertName((username));
        rgPage1.insertEmail(email);
        rgPage1.clickOnSignupBtn();
    }


    @Then("User should move to second Registration Page")
    public void userShouldMoveToSecondRegistrationPage() {
        rgPage1.userShouldMoveToSecondRegistrationPage();
    }


    //Email already exists
    @Then("Error message should appear Email Address already exist!")
    public void errorMessageShouldAppearEmailAddressAlreadyExist() {
        rgPage1.verifyEmailAddressAlreadyExistsMessage();
    }


    //Email Validation Error
    @When("User should Fill {string} field and {string} field and click on signup button - email validation")
    public void userShouldFillUsernameFieldAndEmailFieldAndClickOnSignupButton(String username, String email) {
        rgPage1.insertName((username));
        rgPage1.insertEmail(email);
        rgPage1.clickOnSignupBtn();
    }

    @Then("Error message should appear An email validation Error")
    public void errorMessageShouldAppearAnEmailValidationErrorOREmailIsAlreadyExists() {
        rgPage1.verifyEmailValidationErrorMessage();
    }

    //Registration with Empty name and Valid email
    @Then("Error Validation message should appear")
    public void errorValidationMessageShouldAppear() {
        rgPage1.verifyNameValidationMessage();
    }
}
