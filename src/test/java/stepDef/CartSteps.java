package stepDef;

import lumaPages.CartPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import lumaBase.BaseClass;

public class CartSteps extends BaseClass {
    CartPage cartCheckoutPage;

    @Given("User has added a product to the cart")
    public void user_has_added_a_product_to_the_cart() {
        System.out.println("Product has already been added to the cart.");
    }

    @When("User clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        cartCheckoutPage = new CartPage(driver); // Use existing WebDriver instance
        cartCheckoutPage.clickCart();
    }

    @Then("Cart page should be displayed")
    public void cart_page_should_be_displayed() {
        Assert.assertTrue(cartCheckoutPage.isCartPageDisplayed(), "Cart page is not displayed!");
    }
}
