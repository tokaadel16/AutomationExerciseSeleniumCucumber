package Steps;

import Pages.BasePage;

import Pages.RegisterPage2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;




import java.util.Map;

public class RegisterFeatureSteps2 extends BasePage {
    RegisterPage2 rgPage2 = new RegisterPage2();

    //Successful Registration Flow
    @And("User enters valid registration details and clicks on Create Account Button")
    public void userEntersValidRegistrationDetailsAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("Account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        rgPage2.verifyAccountCreatedMessage();
        rgPage2.clickOnContinueBtn();
    }

    //Registration without entering password
    @And("User fills all required registration details except password field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptPasswordFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("Password required validation should be displayed")
    public void passwordRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyPasswordValidationMessage();
    }


    //Registration without entering First name
    @And("User fills all required registration details except First name field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptFirstNameFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();

    }

    @Then("First name required validation should be displayed")
    public void firstNameRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyFirstNameValidationMessage();
    }


    //Registration without entering Last name
    @And("User fills all required registration details except Last name field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptLastNameFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("Last name required validation should be displayed")
    public void lastNameRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyLastNameValidationMessage();
    }


    //Registration without entering Address
    @And("User fills all required registration details except Address field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptAddressFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("Address required validation should be displayed")
    public void addressRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyAddressValidationMessage();
    }

    //Registration without entering Country
    @And("User fills all required registration details except Country field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptCountryFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.clearCountryField();
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("Country required validation should be displayed")
    public void countryRequiredValidationShouldBeDisplayed() {
        String validationMessage = rgPage2.verifyCountryValidationMessage();
        Assert.assertTrue(validationMessage.contains("Please select an item in the list"));
    }

    //Registration without entering City
    @And("User fills all required registration details except City field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptCityFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("City required validation should be displayed")
    public void cityRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyCityValidationMessage();
    }

    //Registration without entering State
    @And("User fills all required registration details except State field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptStateFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("State required validation should be displayed")
    public void stateRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyStateValidationMessage();
    }

    //Registration without entering ZipCode
    @And("User fills all required registration details except zipcode field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptZipcodeFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertMobileNumber(details.get("mobileNumber"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("ZipCode required validation should be displayed")
    public void zipcodeRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyZipcodeValidationMessage();
    }

    //Registration without entering mobile_number
    @And("User fills all required registration details except mobileNumber field and clicks on Create Account Button")
    public void userFillsAllRequiredRegistrationDetailsExceptMobile_numberFieldAndClicksOnCreateAccountButton(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        rgPage2.selectTitle(details.get("title"));
        rgPage2.insertPassword(details.get("password"));
        rgPage2.selectDay(details.get("Day"));
        rgPage2.selectMonth(details.get("Month"));
        rgPage2.selectYear(details.get("Year"));
        rgPage2.clickOnCheckBox();
        rgPage2.insertFirstName(details.get("first_name"));
        rgPage2.insertLastName(details.get("last_name"));
        rgPage2.insertCompany(details.get("Company"));
        rgPage2.insertAddress(details.get("Address"));
        rgPage2.selectCountry(details.get("Country"));
        rgPage2.insertState(details.get("State"));
        rgPage2.insertCity(details.get("City"));
        rgPage2.insertZipCode(details.get("zipcode"));
        rgPage2.clickOnCreateAccountBtn();
    }

    @Then("mobileNumber required validation should be displayed")
    public void mobile_numberRequiredValidationShouldBeDisplayed() {
        rgPage2.verifyMobileNumberValidationMessage();
    }
}

