package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(linkText = "Signup / Login")
    WebElement loginLink;
    @FindBy(xpath = "//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2")
    WebElement homePageMessage;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    WebElement subscriptionTxt;
    @FindBy(id = "scrollUp")
    WebElement scrollUpBtn;


    public void clickOnSignupLoginLink() {
        wait_element(base_page_driver, 10, loginLink);
        loginLink.click();
    }
    //Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    public void homePageIsVisible(){
        wait_element(base_page_driver,10,homePageMessage);
        String actualMessage = homePageMessage.getText();
        Assert.assertEquals("Full-Fledged practice website for Automation Engineers",actualMessage);
    }

    public void scrollDownPageToBottom(){
        wait_element(base_page_driver,10,subscriptionTxt);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("arguments[0].scrollIntoView(true);",subscriptionTxt);
    }

    public void clickOnScrollUpBtn() {
        wait_element(base_page_driver, 10, scrollUpBtn);
        scrollUpBtn.click();
    }

    public void verifyHeaderTextIsVisible(String expectedText) {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        By headerTextLocator = By.xpath("//h2[contains(normalize-space(), '" + expectedText + "')]");
        WebElement headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(headerTextLocator));
        Assert.assertTrue("Failed: Page did not scroll up properly!", headerText.isDisplayed());
    }

    //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    public void scrollUpPageToTop(){
        ((JavascriptExecutor)base_page_driver).executeScript("window.scrollTo(0,0);");
    }
}

