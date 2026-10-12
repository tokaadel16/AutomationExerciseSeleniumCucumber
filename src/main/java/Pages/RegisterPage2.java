package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage2 extends BasePage {
    public RegisterPage2() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement mrTitle;
    @FindBy(id = "id_gender2")
    WebElement mrsTitle;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(name = "days")
    WebElement day;
    @FindBy(name = "months")
    WebElement month;
    @FindBy(name = "years")
    WebElement year;
    @FindBy(name = "optin")
    WebElement optin_check_box;
    @FindBy(name = "first_name")
    WebElement firstname;
    @FindBy(name = "last_name")
    WebElement lastname;
    @FindBy(name = "company")
    WebElement company;
    @FindBy(name = "address1")
    WebElement address;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(name = "state")
    WebElement state;
    @FindBy(name = "city")
    WebElement city;
    @FindBy(name = "zipcode")
    WebElement zip_code;
    @FindBy(name = "mobile_number")
    WebElement mobile_number;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    WebElement create_account_btn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement account_created_message;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continue_btn;



    //Select Title
    public void selectTitle(String title) {
        if (title.equals("Mr.")) {
            wait_element(base_page_driver, 15, mrTitle);
            mrTitle.click();
        } else if (title.equals("Mrs.")) {
            wait_element(base_page_driver, 15, mrsTitle);
            mrsTitle.click();
        }
    }

    //Enter Password
    public void insertPassword(String password) {
        wait_element(base_page_driver, 10, pass);
        pass.clear();
        pass.sendKeys(password);
    }

    //Select Day
    public void selectDay(String Day) {
        wait_element(base_page_driver, 10, day);
        Select select_day = new Select(day);
        select_day.selectByVisibleText(Day);
    }

    //Select Month
    public void selectMonth(String Month) {
        wait_element(base_page_driver, 10, month);
        Select select_month = new Select(month);
        select_month.selectByVisibleText(Month);
    }

    //Select Year
    public void selectYear(String Year) {
        wait_element(base_page_driver, 10, year);
        Select select_year = new Select(year);
        select_year.selectByVisibleText(Year);
    }

    //click on checkbox
    public void clickOnCheckBox() {
        wait_element(base_page_driver, 10, optin_check_box);
        optin_check_box.click();
    }

    //Enter firstname
    public void insertFirstName(String first_name) {
        wait_element(base_page_driver, 10, firstname);
        firstname.clear();
        firstname.sendKeys(first_name);
    }

    //Enter lastname
    public void insertLastName(String last_name) {
        wait_element(base_page_driver, 10, lastname);
        lastname.clear();
        lastname.sendKeys(last_name);
    }

    //Enter Company
    public void insertCompany(String Company) {
        wait_element(base_page_driver, 10, company);
        company.clear();
        company.sendKeys(Company);
    }

    //Enter Address
    public void insertAddress(String Address) {
        wait_element(base_page_driver, 10, address);
        address.clear();
        address.sendKeys(Address);
    }

    //Select Country
    public void selectCountry(String Country) {
        wait_element(base_page_driver, 15, country);
        Select select_country = new Select(country);
        select_country.selectByVisibleText(Country);
    }

    //Enter State
    public void insertState(String State) {
        wait_element(base_page_driver, 10, state);
        state.clear();
        state.sendKeys(State);
    }

    //Enter City
    public void insertCity(String City) {
        wait_element(base_page_driver, 10, city);
        city.clear();
        city.sendKeys(City);
    }

    //Enter ZipCode
    public void insertZipCode(String zipcode) {
        wait_element(base_page_driver, 10, zip_code);
        zip_code.clear();
        zip_code.sendKeys(zipcode);
    }

    //Enter mobileNumber
    public void insertMobileNumber(String mobileNumber) {
        wait_element(base_page_driver, 10, mobile_number);
        mobile_number.clear();
        mobile_number.sendKeys(mobileNumber);
    }

    //Click_on_Create_Account_Button
    public void clickOnCreateAccountBtn() {
        wait_element(base_page_driver, 10, create_account_btn);
        create_account_btn.click();
    }

    //Account Created Message
    public void verifyAccountCreatedMessage() {
        wait_element(base_page_driver, 15, account_created_message);
        String actual_message = account_created_message.getText();
        Assert.assertEquals("ACCOUNT CREATED!", actual_message);
    }

    //Click_on_Continue_Button
    public void clickOnContinueBtn() {
        wait_element(base_page_driver, 10, continue_btn);
        continue_btn.click();
    }

    //Password Validation Message
    public void verifyPasswordValidationMessage() {
        String message = getValidationMessage(pass);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //Firstname Validation Message
    public void verifyFirstNameValidationMessage() {
        String message = getValidationMessage(firstname);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //Lastname Validation Message
    public void verifyLastNameValidationMessage() {
        String message = getValidationMessage(lastname);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //Address Validation Message
    public void verifyAddressValidationMessage() {
        String message = getValidationMessage(address);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //State Validation Message
    public void verifyStateValidationMessage() {
        String message = getValidationMessage(state);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //City Validation Message
    public void verifyCityValidationMessage() {
        String message = getValidationMessage(city);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }


    //ZipCode Validation Message
    public void verifyZipcodeValidationMessage() {
        String message = getValidationMessage(zip_code);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //MobileNumber Validation Message
    public void verifyMobileNumberValidationMessage() {
        String message = getValidationMessage(mobile_number);
        Assert.assertTrue(message.contains("Please fill out this field"));
    }

    //Clear Country Field
    public void clearCountryField(){
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("return arguments[0].value='';",country);
    }

    //Country Validation Message
    public String verifyCountryValidationMessage(){
        return getValidationMessage(country);
    }
}

