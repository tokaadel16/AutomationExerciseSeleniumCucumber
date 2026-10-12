package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ContactUsPage extends BasePage{
    public ContactUsPage(){
        super();
        PageFactory.initElements(base_page_driver,this);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLinkTxt;
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
    WebElement getInTouchMessage;
    @FindBy(name = "name")
    WebElement nameField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "subject")
    WebElement subjectField;
    @FindBy(id = "message")
    WebElement messageField;
    @FindBy(name= "submit")
    WebElement submitBtn;
    @FindBy(name= "upload_file")
    WebElement uploadFile;
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    WebElement detailsSubmittedSuccessfully;


    //Go To Contact Us Page
    public void clickOnContactUsLinkTxt(){
        wait_element(base_page_driver,15,contactUsLinkTxt);
        contactUsLinkTxt.click();
    }
    public void verifyGetInTouchMessage(){
        wait_element(base_page_driver,15,getInTouchMessage);
        String actualMessage = getInTouchMessage.getText();
        Assert.assertEquals("GET IN TOUCH",actualMessage);
    }

    //Entering Name
    public void insertName(String name){
        wait_element(base_page_driver,5,nameField);
        nameField.clear();
        nameField.sendKeys(name);
    }

    //Entering Email
    public void insertEmail(String email){
        wait_element(base_page_driver,5,emailField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Entering Subject
    public void insertSubject(String subject){
        wait_element(base_page_driver,5,subjectField);
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    //Entering message
    public void insertMessage(String message){
        wait_element(base_page_driver,5,messageField);
        messageField.clear();
        messageField.sendKeys(message);
    }

    //Upload File
    public void uploadFile(String fileName){
        wait_element(base_page_driver,5,uploadFile);
        String filePath = new File("src/test/resources/" + fileName).getAbsolutePath();
        uploadFile.sendKeys(filePath);
    }

    //Click on Submit Btn
    public void clickOnSubmitBtn(){
        wait_element(base_page_driver,15,submitBtn);
        submitBtn.click();
    }

    //Accept Alert
    public void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        base_page_driver.switchTo().alert().accept();
    }

    //Details Submitted Successfully
    public void verifyDetailsSubmittedSuccessfullyMessage(){
        wait_element(base_page_driver,10,detailsSubmittedSuccessfully);
        String actualMessage = detailsSubmittedSuccessfully.getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",actualMessage);
    }
}
