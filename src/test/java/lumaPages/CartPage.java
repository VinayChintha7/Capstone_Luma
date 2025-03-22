package lumaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy
    @FindBy(xpath = "//a[contains(@class,'showcart')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//h1[text()='Shopping Cart']")
    private WebElement cartPageHeader;

    // Methods to interact with elements
    public void clickCart() {
        cartIcon.click();
    }

    public boolean isCartPageDisplayed() {
        return cartPageHeader.isDisplayed();
    }
}
