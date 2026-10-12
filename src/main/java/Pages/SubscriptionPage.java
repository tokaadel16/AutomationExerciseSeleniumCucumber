package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage extends BasePage{
    public SubscriptionPage(){
        super();
        PageFactory.initElements(base_page_driver,this);
    }
    @FindBy(id = "susbscribe_email")
    WebElement subscribedEmailAddress;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    WebElement subscriptionTxt;
    @FindBy(id = "subscribe")
    WebElement subscribeBtn;
    @FindBy(id = "success-subscribe")
    WebElement successSubscriptionMessage;
    @FindBy(linkText = "Cart")
    WebElement cartLinkTxt;


    //Go To Subscription Section in Home Page
    public void subscriptionTxtSection() {
        wait_element(base_page_driver, 15, subscriptionTxt);
        String subsTxt = subscriptionTxt.getText();
        Assert.assertEquals("SUBSCRIPTION", subsTxt);
    }

    //Subscribe Successfully
    public void subscribeEmailAddress(String subscribedEmail) {
        wait_element(base_page_driver, 15, subscribedEmailAddress);
        subscribedEmailAddress.sendKeys(subscribedEmail);
    }

    public void clickOnSubscribeBtn() {
        wait_element(base_page_driver, 15, subscribeBtn);
        subscribeBtn.click();
    }

    public void verifyUserSubscribedSuccessfullyMessage() {
        wait_element(base_page_driver, 10, successSubscriptionMessage);
        String message = successSubscriptionMessage.getText();
        Assert.assertEquals("You have been successfully subscribed!", message);
    }

    //Subscription with invalid email
    public void verifyEmailValidationErrorMessage() {
        wait_element(base_page_driver, 15, subscribedEmailAddress);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        String message = (String) java.executeScript("return arguments[0].validationMessage;", subscribedEmailAddress);
        Assert.assertTrue(message.contains("@"));
    }

    //Subscription with empty email
    public void verifySubscribeWithEmptyEmail() {
        wait_element(base_page_driver, 15, subscribedEmailAddress);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        String message = (String) java.executeScript("return arguments[0].validationMessage;", subscribedEmailAddress);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //Go To Subscription Section in Cart Page
    public void clickOnCartLinkTxt() {
        wait_element(base_page_driver, 15, cartLinkTxt);
        cartLinkTxt.click();
    }
}
