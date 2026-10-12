package Steps;

import Pages.OrderPage;
import Pages.BasePage;
import Pages.RegisterPage2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.util.Map;

public class OrderFeatureSteps extends BasePage {
    OrderPage orderPage = new OrderPage();
    RegisterPage2 rgPage2 = new RegisterPage2();



    @And("Logged in as {string} should be displayed orderPg")
    public void loggedInAsShouldBeDisplayedOrderPg(String userName) {
        orderPage.verify_user_logged_in_successfully(userName);
    }

    @And("User enters valid registration details and clicks on Create Account Button-order place")
    public void userEntersValidRegistrationDetailsAndClicksOnCreateAccountButtonOrderPlace(DataTable data) {
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

    @And("Account should be created successfully-orderPg")
    public void accountShouldBeCreatedSuccessfully() {
        orderPage.verifyAccountCreatedMessage();
        orderPage.clickOnContinueBtn();
    }


    @And("User clicks on Cart btn")
    public void userClicksOnCartBtn() {
        orderPage.clickOnCartBtn();
    }

    @And("Click Proceed To Checkout")
    public void clickProceedToCheckout() {
        orderPage.clickProceedToCheckOut();
    }

    @And("Click Register-Login button")
    public void clickRegisterLoginButton() {
        orderPage.clickOonSignupLoginLink();
    }

    @And("Verify Address Details and Review Your Order")
    public void verifyAddressDetailsAndReviewYourOrder(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        String actualAddress = orderPage.getDeliveryAddress();
        Assert.assertTrue(actualAddress.contains(details.get("first_name")));
        Assert.assertTrue(actualAddress.contains(details.get("last_name")));
        Assert.assertTrue(actualAddress.contains(details.get("Company")));
        Assert.assertTrue(actualAddress.contains(details.get("Address")));
        Assert.assertTrue(actualAddress.contains(details.get("Country")));
        Assert.assertTrue(actualAddress.contains(details.get("State")));
        Assert.assertTrue(actualAddress.contains(details.get("City")));
        Assert.assertTrue(actualAddress.contains(details.get("zipcode")));
        Assert.assertTrue(actualAddress.contains(details.get("mobileNumber")));
    }

    @And("User enters {string} in comment text area and clicks Place Order")
    public void userEntersDescriptionInCommentTextAreaAndClicksPlaceOrder(String comment) {
        orderPage.addCommentOnOrder(comment);
        orderPage.clickPlaceOrderBtn();
    }

    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardName(details.get("Card-Name"));
        orderPage.insertCardNumber(details.get("Card-Number"));
        orderPage.insertCvc(details.get("Cvc"));
        orderPage.insertExpiryMonth(details.get("ExpiryMonth"));
        orderPage.insertExpiryYear(details.get("ExpiryYear"));
        orderPage.clickOnPayConfirmBtn();
    }

    @And("Verify success message Your order has been placed successfully!")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfully() {
        Assert.assertEquals("Congratulations! Your order has been confirmed!", orderPage.verifyGetSuccessMessageText());
    }

    @Then("Click Delete Account button and Verify ACCOUNT DELETED! and click Continue button")
    public void clickDeleteAccountButtonAndVerifyACCOUNTDELETEDAndClickContinueButton() {
         //orderPage.clickOnDeleteAccountLinkTxt();
        //orderPage.verifyAccountDeletedMessageIsDisplayed();
        //orderPage.clickOnContinueBtn();
    }

    //Invoice Download
    @And("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() {
        orderPage.clickOnDownloadInvoiceBtn();
        orderPage.verifyInvoiceDownloadedSuccessfully();
    }

    @And("Click on Continue Btn")
    public void clickOnContinueBtn() {
        orderPage.clickOnContinueBtn();
    }

    //Verify Delivery Address
    @And("Verify that the delivery address is same address filled at the time registration of account")
    public void verifyThatTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        String actualAddress = orderPage.getDeliveryAddress();
        Assert.assertTrue(actualAddress.contains(details.get("first_name")));
        Assert.assertTrue(actualAddress.contains(details.get("last_name")));
        Assert.assertTrue(actualAddress.contains(details.get("Company")));
        Assert.assertTrue(actualAddress.contains(details.get("Address")));
        Assert.assertTrue(actualAddress.contains(details.get("Country")));
        Assert.assertTrue(actualAddress.contains(details.get("State")));
        Assert.assertTrue(actualAddress.contains(details.get("City")));
        Assert.assertTrue(actualAddress.contains(details.get("zipcode")));
        Assert.assertTrue(actualAddress.contains(details.get("mobileNumber")));
    }

    //Verify Billing Address
    @And("Verify that the billing address is same address filled at the time registration of account")
    public void verifyThatTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        String actualAddress = orderPage.getBillingAddress();
        Assert.assertTrue(actualAddress.contains(details.get("first_name")));
        Assert.assertTrue(actualAddress.contains(details.get("last_name")));
        Assert.assertTrue(actualAddress.contains(details.get("Company")));
        Assert.assertTrue(actualAddress.contains(details.get("Address")));
        Assert.assertTrue(actualAddress.contains(details.get("Country")));
        Assert.assertTrue(actualAddress.contains(details.get("State")));
        Assert.assertTrue(actualAddress.contains(details.get("City")));
        Assert.assertTrue(actualAddress.contains(details.get("zipcode")));
        Assert.assertTrue(actualAddress.contains(details.get("mobileNumber")));
    }

    //Verify Place Order and  Login before Checkout Without entering Card Name
    @And("Enter payment details except  Name on Card")
    public void enterPaymentDetailsExceptNameOnCard(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardNumber(details.get("Card-Number"));
        orderPage.insertCvc(details.get("Cvc"));
        orderPage.insertExpiryMonth(details.get("ExpiryMonth"));
        orderPage.insertExpiryYear(details.get("ExpiryYear"));
        orderPage.clickOnPayConfirmBtn();
    }

    @Then("Card Name Validation Message should appear")
    public void cardNameValidationMessageShouldAppear() {
        String actualMessage = orderPage.verifyGetValidationMessageOfCardName();
        Assert.assertTrue(actualMessage.toLowerCase().contains("please fill out this field"));
    }

    //Verify Place Order and  Login before Checkout Without entering Card Number
    @And("Enter payment details except Card Number")
    public void enterPaymentDetailsExceptCardNumber(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardName(details.get("Card-Name"));
        orderPage.insertCvc(details.get("Cvc"));
        orderPage.insertExpiryMonth(details.get("ExpiryMonth"));
        orderPage.insertExpiryYear(details.get("ExpiryYear"));
        orderPage.clickOnPayConfirmBtn();
    }

    @Then("Card Number Validation Message should appear")
    public void cardNumberValidationMessageShouldAppear() {
        String actualMessage = orderPage.verifyGetValidationMessageOfCardNumber();
        actualMessage = (actualMessage != null) ? actualMessage.trim() : "";
        Assert.assertTrue("Expected HTML5 validation message not displayed! Actual was: " + actualMessage, actualMessage.toLowerCase().contains("please fill out this field"));
    }

    //Verify Place Order and  Login before Checkout Without entering Card CVC
    @And("Enter payment details except CVC")
    public void enterPaymentDetailsExceptCVC(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardName(details.get("Card-Name"));
        orderPage.insertCardNumber(details.get("Card-Number"));
        orderPage.insertExpiryMonth(details.get("ExpiryMonth"));
        orderPage.insertExpiryYear(details.get("ExpiryYear"));
        orderPage.clickOnPayConfirmBtn();
    }

    @Then("Card CVC Validation Message should appear")
    public void cardCVCValidationMessageShouldAppear() {
        String actualMessage = orderPage.verifyGetValidationMessageOfCardCvc();
        actualMessage = actualMessage != null ? actualMessage.trim() : "";
        Assert.assertTrue("Expected HTML5 validation message not displayed! Actual was: " + actualMessage, actualMessage.toLowerCase().contains("please fill out this field"));
    }

    //Verify Place Order and  Login before Checkout Without entering Card Expiration Month
    @And("Enter payment details except Expiration Month")
    public void enterPaymentDetailsExceptExpirationMonth(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardName(details.get("Card-Name"));
        orderPage.insertCardNumber(details.get("Card-Number"));
        orderPage.insertCvc(details.get("Cvc"));
        orderPage.insertExpiryYear(details.get("ExpiryYear"));
        orderPage.clickOnPayConfirmBtn();
    }

    @Then("Card Expiration Month Validation Message should appear")
    public void cardExpirationMonthValidationMessageShouldAppear() {
        String actualMessage = orderPage.verifyGetValidationMessageOfCardExpirationMonth();
        actualMessage = actualMessage != null ? actualMessage.trim() : "";
        Assert.assertTrue("Expected HTML5 validation message not displayed! Actual was: " + actualMessage, actualMessage.toLowerCase().contains("please fill out this field"));
    }

    //Verify Place Order and  Login before Checkout Without entering Card Expiration Year
    @And("Enter payment details except Expiration Year")
    public void enterPaymentDetailsExceptExpirationYear(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        orderPage.insertCardName(details.get("Card-Name"));
        orderPage.insertCardNumber(details.get("Card-Number"));
        orderPage.insertCvc(details.get("Cvc"));
        orderPage.insertExpiryMonth(details.get("ExpiryMonth"));
        orderPage.clickOnPayConfirmBtn();
    }

    @Then("Card Expiration Year Validation Message should appear")
    public void cardExpirationYearValidationMessageShouldAppear() {
        String actualMessage = orderPage.verifyGetValidationMessageOfCardExpirationYear();
        actualMessage = actualMessage != null ? actualMessage.trim() : "";
        Assert.assertTrue("Expected HTML5 validation message not displayed! Actual was: " + actualMessage, actualMessage.toLowerCase().contains("please fill out this field"));
    }
}
