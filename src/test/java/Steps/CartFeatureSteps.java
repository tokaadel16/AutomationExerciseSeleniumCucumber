package Steps;

import Pages.CartPage;
import Pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartFeatureSteps extends BasePage {
    CartPage carPage = new CartPage();

    //Add products in Cart
    @And("Users Adds product {string} to cart and clicks on Continue btn")
    public void usersAddsProductToCartAndClicksOnContinueBtn(String productName) {
        carPage.clickOnAddToCartLinkTxt(productName);
        carPage.clickOnContinueBtn();
    }

    @And("Users Adds product {string} to cart")
    public void usersAddsProductToCart(String productName) {
        carPage.clickOnAddToCartLinkTxt(productName);
    }

    @Then("Clicks on view cart and Check both products are added")
    public void clicksOnViewCartAndCheckBothProductsAreAdded() {
        carPage.clickOnViewCartLinkTxt();
        carPage.verifyCartProductCount(2);
    }

    //Verify Product Quantity in cart
    @And("Clicks on view product")
    public void clicksOnViewProduct() {
        carPage.clickOnViewProduct();
    }

    @And("User sets product quantity to {int}")
    public void userSetsProductQuantityTo(int quantity) {
        carPage.setProductQuantity(quantity);
    }

    @And("Clicks on Add to cart")
    public void clicksOnAddToCart() {
        carPage.clickOnAddToCartBtn();
        carPage.clickOnViewCart();
    }

    @Then("Product Quantity should be {int}")
    public void productQuantityShouldBe(int expectedQuantity) {
        carPage.verifyProductQuantity(expectedQuantity);
    }

    //Remove products from Cart
    @And("User clicks on Cart linkText")
    public void userClicksOnCartLinkText() {
        carPage.clickOnCartLinkTxt();
    }

    @And("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        carPage.verifyCartPageIsDisplayed();
    }

    @And("Clicks on x button corresponding to {string} product")
    public void clicksOnXButtonCorrespondingToAParticularProduct(String productName) {
        carPage.clickOnXButtonToProductName(productName);
    }

    @Then("Products should be removed from cart")
    public void productShouldBeRemovedFromCart() {
        carPage.verifyProductsAreRemoved();
    }

    //Add To Cart from Recommended Items
    @When("User scrolls to Bottom of Page and Recommended Items are visible")
    public void userScrollsToBottomOfPageAndRecommendedItemsAreVisible() {
        carPage.verifyRecommendedItemsSection();
    }

    @And("Users adds product {string} to cart")
    public void usersAddsProduct(String productName) {
        carPage.clickOnAddToCartRecommendedItems(productName);
    }

    @And("Clicks on view cart")
    public void clicksOnViewCart() {
        carPage.clickOnViewCartRecommendedItems();
    }

    @Then("Verify that {string} is displayed in cart page")
    public void verifyThatIsDisplayedInCartPage(String expectedProductName) {
        carPage.productIsDisplayedInCart(expectedProductName);
    }
}
