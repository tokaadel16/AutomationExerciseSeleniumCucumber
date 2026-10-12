package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class TestCasesPage extends BasePage{
    public TestCasesPage(){
        super();
        PageFactory.initElements(base_page_driver,this);
    }

    @FindBy(linkText = "Test Cases")
    WebElement testCasesLinkTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div/h2/b")
    WebElement testCasesMessage;


    //Click on Test Cases LinkTxt
    public void clickOnTestCasesLinkTxt(){
        wait_element(base_page_driver,15,testCasesLinkTxt);
        testCasesLinkTxt.click();
    }
    public void verifyTestCasePageDisplayed(){
        wait_element(base_page_driver,15,testCasesMessage);
        String actualMessage = testCasesMessage.getText();
        Assert.assertEquals("TEST CASES",actualMessage);
    }
}
