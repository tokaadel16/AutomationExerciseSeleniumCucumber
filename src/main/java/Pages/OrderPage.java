package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class OrderPage extends BasePage {
    public OrderPage() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }


    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountCreatedMessage;
    @FindBy(linkText = "Cart")
    WebElement cartLinkTxt;
    @FindBy(css = ".check_out")
    WebElement checkOutBtn;
    @FindBy(linkText = "Signup / Login")
    WebElement loginSignupLink;
    @FindBy(id = "address_delivery")
    WebElement addressDelivery;
    @FindBy(id = "address_invoice")
    WebElement billingAddress;
    @FindBy(name = "message")
    WebElement commentOnOrder;
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    WebElement placeOrderBtn;
    @FindBy(name = "name_on_card")
    WebElement cardNameField;
    @FindBy(name = "card_number")
    WebElement cardNumberField;
    @FindBy(name = "cvc")
    WebElement cvcField;
    @FindBy(name = "expiry_month")
    WebElement expiryMonthField;
    @FindBy(name = "expiry_year")
    WebElement expiryYearField;
    @FindBy(id = "submit")
    WebElement payConfirmBtn;
    @FindBy(xpath = "//p[contains(text(),'Your order has been confirmed!') or contains(text(),'Your order has been placed successfully!')]")
    WebElement successMessage;
    @FindBy(linkText = "Delete Account")
    WebElement deleteAccountLinkTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountDeletedMessage;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a")
    WebElement downloadInvoiceBtn;


    //Account Created Message
    public void verifyAccountCreatedMessage() {
        wait_element(base_page_driver, 15, accountCreatedMessage);
        String actualMessage = accountCreatedMessage.getText();
        Assert.assertEquals("ACCOUNT CREATED!", actualMessage);
    }

    //Click_on_Continue_Button
    public void clickOnContinueBtn() {
        wait_element(base_page_driver, 10, continueBtn);
        continueBtn.click();
    }

    //Verify That User is Logged in Successfully
    public void verify_user_logged_in_successfully(String username) {
        if (base_page_driver.getCurrentUrl().contains("#google_vignette")) {
            base_page_driver.navigate().refresh();
        }
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(15));
        By loggedInUserLocator = By.xpath("//li[a[contains(., 'Logged in as')]]");
        try {
            WebElement loggedInUserElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserLocator));
            String actualText = loggedInUserElement.getText().trim();
            Assert.assertTrue("Expected username not found in header! Actual: " + actualText,
                    actualText.contains(username));
        } catch (TimeoutException e) {
            base_page_driver.navigate().refresh();
            WebElement loggedInUserElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserLocator));
            Assert.assertTrue(loggedInUserElement.getText().contains(username));
        }
    }
      /*  public void verifyInvoiceDownloadedSuccessfully() {
            String userHome = System.getProperty("user.home");
            File downloadFolder = new File(userHome + "/Downloads");

            File[] files = downloadFolder.listFiles();

            if (files != null) {
                for (File file : files) {
                    System.out.println("Downloaded file: " + file.getName());
                }
            }

            Assert.assertTrue(
                    "Invoice was not downloaded successfully",
                    files != null && files.length > 0
            );
        }*/

    //Click On Cart Btn
    public void clickOnCartBtn() {
        wait_element(base_page_driver, 10, cartLinkTxt);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", cartLinkTxt);
    }

    //Click On Proceed Check Out Btn
    public void clickProceedToCheckOut() {
        wait_element(base_page_driver, 10, checkOutBtn);
        checkOutBtn.click();
    }

    //Click On Signup/Login
    public void clickOonSignupLoginLink() {
        wait_element(base_page_driver, 10, loginSignupLink);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", loginSignupLink);
    }

    //Get Delivery Address
    public String getDeliveryAddress() {
        wait_element(base_page_driver,10,addressDelivery);
        return addressDelivery.getText();
    }

    //Get Billing Address
    public String getBillingAddress() {
        wait_element(base_page_driver,10,billingAddress);
        return billingAddress.getText();
    }

    //Add Comment On Order
    public void addCommentOnOrder(String comment) {
        wait_element(base_page_driver, 10, commentOnOrder);
        commentOnOrder.sendKeys(comment);
    }

    //Click On Place Order Btn
    public void clickPlaceOrderBtn() {
        wait_element(base_page_driver, 10, placeOrderBtn);
        placeOrderBtn.click();
    }

    //Enter Card Name
    public void insertCardName(String cardName) {
        wait_element(base_page_driver, 10, cardNameField);
        cardNameField.clear();
        cardNameField.sendKeys(cardName);
    }

    //Enter Card Number
    public void insertCardNumber(String cardNumber) {
        wait_element(base_page_driver, 10, cardNumberField);
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }

    //Enter cvc Number
    public void insertCvc(String cvc) {
        wait_element(base_page_driver, 10, cvcField);
        cvcField.clear();
        cvcField.sendKeys(cvc);
    }

    //Enter Expiry Month
    public void insertExpiryMonth(String expiryMonth) {
        wait_element(base_page_driver, 10, expiryMonthField);
        expiryMonthField.clear();
        expiryMonthField.sendKeys(expiryMonth);
    }

    //Enter Expiry Year
    public void insertExpiryYear(String expiryYear) {
        wait_element(base_page_driver, 10, expiryYearField);
        expiryYearField.clear();
        expiryYearField.sendKeys(expiryYear);
    }

    //Click On Pay and Confirm Btn
    public void clickOnPayConfirmBtn() {
        wait_element(base_page_driver, 10, payConfirmBtn);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", payConfirmBtn);
    }

    //Order Has been Placed successfully
    public String verifyGetSuccessMessageText() {
        wait_element(base_page_driver,10,successMessage);
        return successMessage.getText();
    }

    //Click on Download Invoice Btn
    public void clickOnDownloadInvoiceBtn() {
        wait_element(base_page_driver, 10, downloadInvoiceBtn);
        downloadInvoiceBtn.click();
    }

    //Invoice Downloaded Successfully
    public void verifyInvoiceDownloadedSuccessfully() {
        String userHome = System.getProperty("user.home");
        File invoiceFile = new File(userHome + "/Downloads/invoice.txt");
        Assert.assertTrue("Invoice was not downloaded successfully", invoiceFile.exists());
    }

    //Click On Delete Account Btn
    public void clickOnDeleteAccountLinkTxt() {
        wait_element(base_page_driver, 10, deleteAccountLinkTxt);
        deleteAccountLinkTxt.click();
    }

    //Account Deleted Message
    public void verifyAccountDeletedMessageIsDisplayed() {
        wait_element(base_page_driver, 10, accountDeletedMessage);
        String actualMessage = accountDeletedMessage.getText();
        Assert.assertEquals("ACCOUNT DELETED!", actualMessage);
    }


    //Verify Place Order and  Login before Checkout Without entering Card Name
    public String verifyGetValidationMessageOfCardName(){
       return getValidationMessage(cardNameField);
    }

    //Verify Place Order and  Login before Checkout Without entering Card Number
    public String verifyGetValidationMessageOfCardNumber(){
        return getValidationMessage(cardNumberField);
    }

    //Verify Place Order and  Login before Checkout Without entering Card CVC
    public String verifyGetValidationMessageOfCardCvc(){
        return getValidationMessage(cvcField);
    }

    //Verify Place Order and  Login before Checkout Without entering Card Expiration Month
    public String verifyGetValidationMessageOfCardExpirationMonth(){
        return getValidationMessage(expiryMonthField);
    }

    //Verify Place Order and  Login before Checkout Without entering Card Expiration Year
    public String verifyGetValidationMessageOfCardExpirationYear(){
        return getValidationMessage(expiryYearField);
    }
}



