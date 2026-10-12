package Steps;



import Pages.LoginPage;
import Pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginFeatureSteps extends BasePage {
    LoginPage loginpage = new LoginPage();

    //Successful Login Flow
    @When("User should fill email as {string} and password as {string} and click on login button")
    public void User_should_fill_email_and_password_and_click_on_login_button(String email, String pass) {
        loginpage.insertEmail(email);
        loginpage.insertPassword(pass);
        loginpage.clickOnLoginBtn();
    }

    @Then("User click on logout button")
    public void User_click_on_logout_button() {
        loginpage.clickOnLogOutBtn();
    }

    //Verify That User logged in
    @Then("Logged in as {string} should be displayed")
    public void loggedInAsShouldBeDisplayed(String username) {
        loginpage.verifyUserLoggedInSuccessfully(username);
    }

    //Account is Deleted Successfully
    @And("User clicks on Delete Account LinkText")
    public void userClicksOnDeleteAccountLinkText() {
        loginpage.clickOnDeleteAccountBtn();
        loginpage.clickOnContinueBtn();
    }

    @Then("Account Deleted Message should be displayed successfully")
    public void accountDeletedMessageShouldBeDisplayedSuccessfully() {
        loginpage.verifyAccountDeletedMessage();
    }

    //Login with invalid credentials
    @When("User should fill {string} and {string} and click on login button")
    public void User_should_fill_email_address_and_password_and_click_on_login_button(String email, String pass) {
        loginpage.insertEmail(email);
        loginpage.insertPassword(pass);
        loginpage.clickOnLoginBtn();
    }

    @Then("Error message should appear Your Email or Password is incorrect")
    public void Error_message_should_appear_Your_Email_or_Password_is_incorrect() {
        loginpage.verifyErrorMessage();
    }


    //Email validation Message
    @Then("An email validation Error should appear")
    public void anEmailValidationErrorShouldAppear() {
        loginpage.verifyEmailValidationMessage();
    }
}
