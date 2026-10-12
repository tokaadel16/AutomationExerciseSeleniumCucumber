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
import java.util.List;


public class CartPage extends BasePage {
    public CartPage() {
        super();
        PageFactory.initElements(base_page_driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    WebElement continueBtn;
    @FindBy(xpath = "//tbody/tr")
    List<WebElement> checkCartProducts;
    @FindBy(id = "quantity")
    WebElement productQuantity;
    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    WebElement viewProduct;
    @FindBy(xpath = "//div[@class=\"product-information\"]/span/button")
    WebElement addToCartBtn;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    WebElement viewCart;
    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    WebElement actualProductQuantity;
    @FindBy(linkText = "Cart")
    WebElement cartLinkTxt;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement removeBtn;
    @FindBy(xpath = "//section[2]/div/div/div[2]/div[2]/h2")
    WebElement recommendedItemsSection;



    //Click on Add To Cart in Products Page
    public void clickOnAddToCartLinkTxt(String productName) {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(15));
        By productCardLocator = By.xpath("//div[contains(@class,'single-products')]" + "[.//p[normalize-space()='" + productName + "']]");
        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].scrollIntoView({block:'center'});", productCard);
        Actions actions = new Actions(base_page_driver);
        actions.moveToElement(productCard).perform();
        By addToCartLocator = By.xpath("//div[contains(@class,'single-products')]" + "[.//p[normalize-space()='" + productName + "']]" + "//a[contains(@class,'add-to-cart')]");
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        //((JavascriptExecutor) base_page_driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartButton);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", addToCartButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
    }

    //Click on Add To continue Btn
    public void clickOnContinueBtn() {
        wait_element(base_page_driver, 15, continueBtn);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", continueBtn);
    }

    // Click on View Cart LinkTxt in Products Page
    public void clickOnViewCartLinkTxt() {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(15));
        By viewCartLocator = By.xpath("//div[@id='cartModal']/div/div/div[2]/p[2]/a");
        WebElement viewCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(viewCartLocator));
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", viewCartButton);
    }

    //Check Products are added
    public void verifyCartProductCount(int expectedCount) {
        List<WebElement> cartProducts = checkCartProducts;
        Assert.assertEquals("Number of Products in Cart is not identical", expectedCount, cartProducts.size());
    }

    //Set product quantity to 4
    public void setProductQuantity(int quantity) {
        wait_element(base_page_driver, 10, productQuantity);
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(quantity));
    }

    //Click on view Product
    public void clickOnViewProduct() {
        wait_element(base_page_driver, 10, viewProduct);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", viewProduct);
    }

    //Click on Add To Cart Btn
    public void clickOnAddToCartBtn() {
        wait_element(base_page_driver, 15, addToCartBtn);
        addToCartBtn.click();
    }

    //Click on view cart
    public void clickOnViewCart() {
        wait_element(base_page_driver, 10, viewCart);
        viewCart.click();
    }

    //Verify Product Quantity
    public void verifyProductQuantity(int expectedQuantity) {
        wait_element(base_page_driver,10,actualProductQuantity);
        int actualQuantity = Integer.parseInt(actualProductQuantity.getText().trim());
        Assert.assertEquals("Product Quantity is not identical", expectedQuantity, actualQuantity);
    }

    //Remove product From Cart
    public void clickOnCartLinkTxt() {
        wait_element(base_page_driver, 10, cartLinkTxt);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", cartLinkTxt);
    }

    //Verify CartPage Is Displayed
    public void verifyCartPageIsDisplayed() {
        String currentUrl = base_page_driver.getCurrentUrl();
        Assert.assertTrue("Cart Page is not displayed", currentUrl.contains("/view_cart"));
    }

    //Click On XButton To ProductName
    public void clickOnXButtonToProductName(String productName) {
        String dynamicRemoveBtn = String.format("//tr[contains(., '%s')]//a[@class='cart_quantity_delete']", productName);
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicRemoveBtn)));
        removeButton.click();
    }


    //Verify Products Are Removed
    public void verifyProductsAreRemoved() {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(15));
        By emptyCartLocator = By.xpath("//*[@id='empty_cart']");
        WebElement emptyCartDiv = wait.until(ExpectedConditions.presenceOfElementLocated(emptyCartLocator));
        JavascriptExecutor js = (JavascriptExecutor) base_page_driver;
        String actualMessage = (String) js.executeScript("return arguments[0].innerText;", emptyCartDiv);
        actualMessage = actualMessage != null ? actualMessage.trim() : "";
        Assert.assertTrue("The Cart Empty Message is incorrect", actualMessage.contains("Cart is empty!"));
    }

    /*Verify One Product Is Removed
      public void verifyProductIsRemoved() {
            // 1. جلب عدد المنتجات قبل الحذف
            List<WebElement> productsBefore = base_page_driver.findElements(By.xpath("//tbody/tr"));
            int initialCount = productsBefore.size();

            // 3. انتظار تغيير العدد (أو استخدام Thread.sleep بسيط لو الصفحة بتعمل AJAX)
            WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody/tr"), initialCount));

            // 4. جلب العدد بعد الحذف والمقارنة
            List<WebElement> productsAfter = base_page_driver.findElements(By.xpath("//tbody/tr"));
            int expectedCount = initialCount - 1;
            int actualCount = productsAfter.size();
            Assert.assertEquals("Number of Products is The Same", expectedCount, actualCount);
        }*/


    //Add To Cart From Recommended Items
    public void verifyRecommendedItemsSection() {
        wait_element(base_page_driver, 10, recommendedItemsSection);
        String actualMessage = recommendedItemsSection.getText().trim();
        Assert.assertEquals("RECOMMENDED ITEMS", actualMessage);
    }

    //Click On Add To Cart Recommended Items
    public void clickOnAddToCartRecommendedItems(String productName) {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        By addToCartLocator = By.xpath("//div[@id='recommended-item-carousel']//p[text()='" + productName + "']/following-sibling::a[contains(@class,'add-to-cart')]");
        WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartLocator));
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartButton);
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", addToCartButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
    }

    //Click On ViewCart Recommended Items
    public void clickOnViewCartRecommendedItems() {
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        By viewCartLocator = By.xpath("//div[@id='cartModal']//a[contains(normalize-space(.),'View Cart')]");
        WebElement viewCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(viewCartLocator));
        ((JavascriptExecutor) base_page_driver).executeScript("arguments[0].click();", viewCartButton);
    }

    // Verify that product is displayed in cart page
    public void productIsDisplayedInCart(String expectedProductName) {
        By productLocator = By.xpath("//td[contains(@class,'cart_description')]//a[text()='" + expectedProductName + "']");
        WebDriverWait wait = new WebDriverWait(base_page_driver, Duration.ofSeconds(5));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
        Assert.assertTrue("Failed: Product is not displayed in cart!", product.isDisplayed());
    }
}
