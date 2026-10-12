package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(name = "email")
    WebElement email_address;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    WebElement loginBtn;
    @FindBy(linkText = "Logout")
    WebElement logOutBtn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    WebElement error_message;
    @FindBy(xpath = "//a[i[@class='fa fa-user']]")
    WebElement loggedInUser;
    @FindBy(linkText = "Delete Account")
    WebElement deleteAccountLinkTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountDeletedMessage;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueBtn;

    //Entering Email
    public void insertEmail(String email) {
        wait_element(base_page_driver, 10, email_address);
        email_address.clear();
        email_address.sendKeys(email);
    }

    //Entering Password
    public void insertPassword(String pass) {
        wait_element(base_page_driver, 10, password);
        password.clear();
        password.sendKeys(pass);
    }

    //Click on Login Btn
    public void clickOnLoginBtn() {
        wait_element(base_page_driver, 15, loginBtn);
        loginBtn.click();
    }

    //Click on Login Btn
    public void clickOnLogOutBtn() {
        wait_element(base_page_driver, 15, logOutBtn);
        logOutBtn.click();
    }

    //Your Email or Password is incorrect
    public void verifyErrorMessage() {
        wait_element(base_page_driver,10,error_message);
        Assert.assertTrue(error_message.isDisplayed());
    }

    public void verifyEmailValidationMessage(){
            wait_element(base_page_driver,15,email_address);
            JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
            String message = (String) java.executeScript("return arguments[0].validationMessage;",email_address);
            Assert.assertTrue(message.contains("@"));
    }

    //Verify That User is Logged in Successfully
    public void verifyUserLoggedInSuccessfully(String username) {
        wait_element(base_page_driver, 15, loggedInUser);
        String actualText = loggedInUser.getText();
        Assert.assertEquals("Logged in as " + username, actualText);
    }

    //Click on Delete Account LinkText
    public void clickOnDeleteAccountBtn(){
        wait_element(base_page_driver,15,deleteAccountLinkTxt);
        deleteAccountLinkTxt.click();
    }
    //Account Deleted Message
    public void verifyAccountDeletedMessage(){
        wait_element(base_page_driver,15,accountDeletedMessage);
        String actualMessage = accountDeletedMessage.getText();
        Assert.assertEquals("ACCOUNT DELETED!",actualMessage);
    }

    //Click on Continue Btn
    public void clickOnContinueBtn(){
        wait_element(base_page_driver,15,continueBtn);
        continueBtn.click();
    }

}
