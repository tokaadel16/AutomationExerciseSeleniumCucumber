package Pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class RegisterPage1 extends BasePage{
    public RegisterPage1() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(name = "name")
    WebElement user_name;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement email_address;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signup_btn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    WebElement enter_account_information_message;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    WebElement email_already_exists_message;

    //insert username
    public void insertName(String username) {
        wait_element(base_page_driver, 15, user_name);
        user_name.clear();
        user_name.sendKeys(username);
    }

    //insert email
    public void insertEmail(String email) {
        wait_element(base_page_driver, 15, email_address);
        email_address.clear();
        email_address.sendKeys(email);
    }

    //click on signup_btn
    public void clickOnSignupBtn() {
        wait_element(base_page_driver, 15, signup_btn);
        signup_btn.click();
    }

    //Move to next Registration Page
    public void userShouldMoveToSecondRegistrationPage() {
        wait_element(base_page_driver, 15, enter_account_information_message);
        String actual_message = enter_account_information_message.getText();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", actual_message);
    }

    //email_validation_error_message
    public void verifyEmailValidationErrorMessage() {
        wait_element(base_page_driver,15,email_address);
        String message = getValidationMessage(email_address);
        Assert.assertTrue(message.contains("@"));
    }

    //Email already exists
    public void verifyEmailAddressAlreadyExistsMessage() {
        wait_element(base_page_driver,15,email_already_exists_message);
        String actualMessage = email_already_exists_message.getText();
        Assert.assertEquals("Email Address already exist!", actualMessage);
    }

    //Name Validation Message
    public void verifyNameValidationMessage(){
            String validationMessage = getValidationMessage(user_name);
            Assert.assertTrue(validationMessage.contains("Please fill out this field"));
        }
    }
