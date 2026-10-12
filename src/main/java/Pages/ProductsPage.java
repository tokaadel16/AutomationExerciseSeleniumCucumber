package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    WebElement productsLink;
    @FindBy(css = ".features_items .product-image-wrapper")
    List<WebElement> productsList;
    @FindBy(xpath = "//div[contains(@class,'product-information')]")
    WebElement product_details;
    @FindBy(name = "search")
    WebElement searchTxtField;
    @FindBy(id = "submit_search")
    WebElement searchBtn;
    @FindBy(xpath = "//section[2]/div/div/div[2]/div/h2")
    WebElement searchedProducts;
    @FindBy(xpath = "//section[2]/div/div/div[2]/div/div[5]/div/div[2]/ul/li/a")
    WebElement viewProductBtn;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[1]")
    WebElement addProductMessage;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    WebElement continueBtn;
    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addToCartBtn;
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
    WebElement womenCategoryPlus;
    @FindBy(linkText = "DRESS")
    WebElement dressCategory;
    @FindBy(xpath = "//section/div/div[2]/div[2]/div/h2")
    WebElement womenDressProductsMessage;
    @FindBy(xpath = "//div[@class='brands_products']//h2")
    WebElement brandCategory;
    @FindBy(xpath = "//section/div//div[3]/div[1]/ul/li/a")
    WebElement reviewSection;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "review")
    WebElement reviewField;
    @FindBy(id = "button-review")
    WebElement submitBtn;
    List<String> searchedProductsAddedToCart = new ArrayList<>();


    //Click on Products link
    public void clickOnProductsLink() {
        wait_element(base_page_driver, 20, productsLink);
        productsLink.click();
    }

    //Search Text Field is displayed
    public void verifySearchTextFieldIsDisplayed() {
        wait_element(base_page_driver, 15, searchTxtField);
        Assert.assertTrue(searchTxtField.isDisplayed());
    }

    //Click on view Product Btn
    public void clickOnViewProductBtn() {
        wait_element(base_page_driver, 20, viewProductBtn);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("arguments[0].scrollIntoView({block:'center'});", viewProductBtn);
        java.executeScript("arguments[0].click();", viewProductBtn);
    }

    //Click on Add to Cart Btn
    public void clickOnAddToCartBtn() {
        wait_element(base_page_driver, 20, addToCartBtn);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("arguments[0].click();", addToCartBtn);
    }

    //Add Product Message
    public void verifyAddProductMessage() {
        wait_element(base_page_driver, 20, addProductMessage);
        String actual_message = addProductMessage.getText();
        Assert.assertEquals("Your product has been added to cart.", actual_message);
        wait_element(base_page_driver, 10, continueBtn);
        continueBtn.click();
    }

    //Product List is displayed
    public boolean verifyProductsListDisplayed() {
        return !productsList.isEmpty();
    }

    //Product Details are displayed
    public boolean verifyProductDetailsDisplayed() {
        wait_element(base_page_driver, 15, product_details);
        return product_details.isDisplayed();
    }


    //Women SubCategories
    public void selectWomenSubcategory() {
        wait_element(base_page_driver, 15, womenCategoryPlus);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("arguments[0].click();", womenCategoryPlus);
    }

    //Dress Category is displayed
    public boolean verifyDressCategoryDisplayed() {
        wait_element(base_page_driver, 15, dressCategory);
        return dressCategory.isDisplayed();
    }

    //click on Dress linkText
    public void clickOnDressLinkText() {
        wait_element(base_page_driver, 15, dressCategory);
        JavascriptExecutor java = (JavascriptExecutor) base_page_driver;
        java.executeScript("arguments[0].click();", dressCategory);
    }

    //Women-Dress products Message
    public void verifyWomenDressProductsDisplayed() {
        wait_element(base_page_driver, 15, womenDressProductsMessage);
        String actualMessage = womenDressProductsMessage.getText();
        Assert.assertEquals("WOMEN -  Dress PRODUCTS", actualMessage);
    }

    //Verify Brand Products
    public void verifyBrandProductsOnLeftSide() {
        wait_element(base_page_driver, 15, brandCategory);
        String actualMessage = brandCategory.getText();
        Assert.assertEquals("BRANDS", actualMessage);
    }

    //Click on BrandName
    public void clickOnBrandName(String brandName) {
        String lowerCaseBrand = brandName.toLowerCase();
        String xpath = String.format("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]", lowerCaseBrand);
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        WebElement brand = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", brand);
    }

    //Verify BrandProducts Are Displayed
    public void verifyBrandProductsAreDisplayed(String expectedBrandName) {
        WebElement brandHeader = base_page_driver.findElement(By.xpath("//h2[@class='title text-center']"));
        wait_element(base_page_driver, 10, brandHeader);
        String actualMessage = brandHeader.getText();
        Assert.assertTrue("Brand Name is not Found" + actualMessage, actualMessage.toUpperCase().contains(expectedBrandName.toUpperCase()));
    }

    //Add Review on Products
    public void verifyReviewSectionIsVisible() {
        wait_element(base_page_driver, 15, reviewSection);
        String actualMessage = reviewSection.getText().trim();
        Assert.assertEquals("WRITE YOUR REVIEW", actualMessage);
    }

    //Entering name-review Section
    public void insertName(String name) {
        wait_element(base_page_driver, 10, nameField);
        nameField.clear();
        nameField.sendKeys(name);
    }

    //Entering email-review Section
    public void insertEmail(String email) {
        wait_element(base_page_driver, 10, emailField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Entering Review
    public void insertReview(String review) {
        wait_element(base_page_driver, 10, reviewField);
        reviewField.clear();
        reviewField.sendKeys(review);
    }

    //Click on Submit Btn
    public void clickOnSubmitBtn() {
        wait_element(base_page_driver, 10, submitBtn);
        submitBtn.click();
    }

    //Thank You For Your Review Message
    public void verifySuccessReviewMessage() {
        By reviewSuccessLocator = By.xpath("//div[contains(@class, 'alert-success')]//span[contains(text(), 'Thank you for your review.')]");
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSuccessLocator));
        String expectedMessage = successMessage.getText();
        Assert.assertEquals("Failed: Success message text does not match!", expectedMessage, "Thank you for your review.");
    }

    //Search Product Field
    public void insertSearchProductField(String searchTerm) {
        wait_element(base_page_driver, 10, searchTxtField);
        searchTxtField.clear();
        searchTxtField.sendKeys(searchTerm);
    }

    //click on Search Button
    public void clickOnSearchBtn() {
        wait_element(base_page_driver, 10, searchBtn);
        searchBtn.click();
    }

    //Searched Products Message
    public void verifySearchedProductsMessageDisplayed() {
        wait_element(base_page_driver, 10, searchedProducts);
        String searchedProductsActualMessage = searchedProducts.getText();
        Assert.assertEquals("SEARCHED PRODUCTS", searchedProductsActualMessage);
    }

    //Verify all the products related to search are visible
    public void verifyProductsRelatedToSearchAreVisible(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".features_items .product-image-wrapper")));
        boolean foundProduct = false;
        for (WebElement product : products) {
            WebElement productName = product.findElement(By.cssSelector(".productinfo p"));
            String actualProductName = productName.getText();
            if (actualProductName.toLowerCase().contains(searchTerm.toLowerCase())) {
                foundProduct = true;
                Assert.assertTrue("Product is not displayed: " + actualProductName, product.isDisplayed());
            }
        }
        Assert.assertTrue("No products related to search term found: " + searchTerm, foundProduct);
    }

    //Add Products Related To Search To Cart
    public void addSearchedProductsToCart(String searchTerm) {
        searchedProductsAddedToCart.clear();
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        int productIndex = 0;
        while (true) {
            List<WebElement> products = base_page_driver.findElements(By.cssSelector(".features_items .productinfo"));
            if (productIndex >= products.size()) {
                break;
            }
            WebElement product = products.get(productIndex);
            WebElement productNameElement = product.findElement(By.cssSelector("p"));
            String actualProductName = productNameElement.getText().trim();
            if (actualProductName.toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedProductsAddedToCart.add(actualProductName);
                ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].scrollIntoView({block:'center'});", product);
                Actions actions = new Actions(base_page_driver);
                actions.moveToElement(product).perform();
                WebElement addToCartButton = product.findElement(By.cssSelector("a.add-to-cart"));
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", addToCartButton);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
                wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
                continueBtn.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
            }
            productIndex++;
        }
    }

    //Verify Products are visible in Cart
    public void verifySearchedProductsAreDisplayedInCart() {
        Assert.assertFalse("No searched products were added to cart!", searchedProductsAddedToCart.isEmpty());
        List<WebElement> cartProducts = base_page_driver.findElements(By.cssSelector("td.cart_description a"));
        Assert.assertFalse("Cart is empty!", cartProducts.isEmpty());
        List<String> cartProductNames = new ArrayList<>();
        for (WebElement cartProduct : cartProducts) {
            String cartProductName = cartProduct.getText().replace("\u00A0", " ").replaceAll("\\s+", " ").trim();
            cartProductNames.add(cartProductName);
        }
        for (String searchedProduct : searchedProductsAddedToCart) {
            String normalizedSearchedProduct = searchedProduct.replace("\u00A0", " ").replaceAll("\\s+", " ").trim();
            boolean productFound = false;
            for (String cartProductName : cartProductNames) {
                if (normalizedSearchedProduct.toLowerCase().contains(cartProductName.toLowerCase())) {
                    productFound = true;
                    break;
                }
            }
            Assert.assertTrue("Product is not displayed in cart: " + searchedProduct, productFound);
        }
    }

    //Clear The Cart
    public void clearCart() {
        base_page_driver.get("https://automationexercise.com/view_cart");
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        List<WebElement> deleteButtons = base_page_driver.findElements(By.cssSelector("td.cart_delete a.cart_quantity_delete"));
        while (!deleteButtons.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(deleteButtons.get(0))).click();
            wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
            deleteButtons = base_page_driver.findElements(By.cssSelector("td.cart_delete a.cart_quantity_delete"));
        }
        base_page_driver.get("https://automationexercise.com/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
    }
}


