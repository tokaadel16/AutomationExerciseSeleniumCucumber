package Steps;

import Pages.ContactUsPage;
import Pages.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class ContactUsFeatureSteps extends BasePage {
    ContactUsPage contactPage = new ContactUsPage();

    //Go To Contact Us Page
    @When("Clicks on Contact us linkText")
    public void clickOnContactUsLinkTxt(){
        contactPage.clickOnContactUsLinkTxt();
    }

    @Then("Contact us Page should be displayed")
    public void contactUsPageShouldBeDisplayed() {
        contactPage.verifyGetInTouchMessage();
    }

    //Verify Contact Us details is submitted Successfully
    @And("Users enters contact us details and clicks on submit btn")
    public void usersEntersContactUsDetailsAndClicksOnSubmitBtn(DataTable data) {
        Map<String,String> details = data.asMap(String.class, String.class);
        contactPage.insertName(details.get("Name"));
        contactPage.insertEmail(details.get("Email"));
        contactPage.insertSubject(details.get("Subject"));
        contactPage.uploadFile(details.get("fileName"));
        contactPage.insertMessage(details.get("Message"));
        contactPage.clickOnSubmitBtn();
        contactPage.acceptAlert();
    }

    @Then("User's details have been submitted successfully.")
    public void userSDetailsHaveBeenSubmittedSuccessfully() {
        contactPage.verifyDetailsSubmittedSuccessfullyMessage();
    }
}
