package Steps;

import Pages.ProductsPage;
import Pages.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;


public class ProductFeatureSteps extends BasePage {
    ProductsPage prodPage = new ProductsPage();

    //Click on Products link text
    @When("Clicks on Products linkText")
    public void clicksOnProductsLinkText() {
        prodPage.clickOnProductsLink();
    }

    @Then("Search Text Field should be visible")
    public void Search_Text_Field_should_be_visible() {
        prodPage.verifySearchTextFieldIsDisplayed();
    }

    //All Product List should be displayed
    @Then("All Products list should be displayed successfully")
    public void allProductsListShouldBeDisplayedSuccessfully() {
        Assert.assertTrue("Products list is not displayed", prodPage.verifyProductsListDisplayed());
    }

    //All Product Details should be displayed
    @And("Clicks on view product LinkText")
    public void clicksOnViewProductLinkText() {
        prodPage.clickOnViewProductBtn();
    }

    @Then("All Products Details should be displayed successfully")
    public void allProductsDetailsShouldBeDisplayedSuccessfully() {
        Assert.assertTrue("Product details are not displayed", prodPage.verifyProductDetailsDisplayed());
    }


    @Then("Searched Products section should be displayed")
    public void searchedProductsSectionShouldBeDisplayed() {
        prodPage.verifySearchedProductsMessageDisplayed();
    }

    //Add new Product
    @When("Clicks on view product LinkText and Clicks on Add to cart")
    public void clicksOnViewProductLinkTextAndClicksOnAddToCart() {
        scroll_down();
        prodPage.clickOnViewProductBtn();
        prodPage.clickOnAddToCartBtn();
    }

    @Then("A New Product should be added")
    public void A_New_Product_should_be_added() {
        prodPage.verifyAddProductMessage();
    }


    //Women SubCategories
    @And("clicks on plus icon next to Women")
    public void clicksOnPlusIconNextToWomen() {
        scroll_down();
        prodPage.selectWomenSubcategory();
    }

    @Then("The Women subcategories should be displayed successfully")
    public void theWomenSubcategoriesShouldBeDisplayedSuccessfully() {
        Assert.assertTrue("Women Category is not displayed", prodPage.verifyDressCategoryDisplayed());
    }

    //Women-Dress Products
    @And("click on Dress Category linkText")
    public void clickOnDressCategoryLinkText() {
        prodPage.clickOnDressLinkText();
    }

    @Then("Women-Dress Products should be displayed successfully")
    public void womenDressProductsShouldBeDisplayedSuccessfully() {
        prodPage.verifyWomenDressProductsDisplayed();
    }

    //Verify Brand Products
    @And("Verify that Brands are visible on left side bar")
    public void verifyThatBrandsAreVisibleOnLeftSideBar() {
        scroll_down();
        prodPage.verifyBrandProductsOnLeftSide();
    }

    @And("Click on {string} brand name")
    public void clickOnBrandName(String brandName) {
        prodPage.clickOnBrandName(brandName);
    }

    @Then("Verify that user is navigated to {string} brand page and brand products are displayed")
    public void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed(String expectedBrandName) {
        prodPage.verifyBrandProductsAreDisplayed(expectedBrandName);
    }

    //Add Review on Products
    @And("Write Your Review is visible")
    public void writeYourReviewIsVisible() {
        prodPage.verifyReviewSectionIsVisible();
    }

    @And("User enters Name and Email and Review and Clicks on submit Button")
    public void userEntersNameAndEmailAndReview(DataTable data) {
        Map<String, String> details = data.asMap(String.class, String.class);
        scroll_down();
        prodPage.insertName(details.get("Name"));
        prodPage.insertEmail(details.get("Email"));
        prodPage.insertReview(details.get("Review"));
        prodPage.clickOnSubmitBtn();
    }

    @Then("Thank you for your review should be displayed")
    public void thankYouForYourReviewShouldBeDisplayed() {
        prodPage.verifySuccessReviewMessage();
    }

    //Search Products Field
    @And("Users enters {string} in Search Product Field")
    public void usersEntersInSearchProductField(String searchTerm) {
        scroll_down();
        prodPage.insertSearchProductField(searchTerm);
        prodPage.clickOnSearchBtn();
    }

    //Verify all the products related to search are visible
    @And("Verify all the products related to {string} are visible")
    public void verifyAllTheProductsRelatedToAreVisible(String searchTerm) {
        prodPage.verifyProductsRelatedToSearchAreVisible(searchTerm);
    }

    //Add Products Related To Search To Cart
    @And("Add {string} products to cart")
    public void addProductsToCart(String searchTerm) {
        prodPage.addSearchedProductsToCart(searchTerm);
    }

    //Verify Searched Products are visible in cart
    @And("verify that products are visible in cart")
    public void verifyThatProductsAreVisibleInCart() {
        prodPage.verifySearchedProductsAreDisplayedInCart();
    }

    //User Clears The Cart
    @And("User clears The Cart")
    public void userClearsTheCart() {
        prodPage.clearCart();
    }
}

