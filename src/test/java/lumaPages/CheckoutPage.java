package lumaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // ✅ Initialize PageFactory
    }

//     Locators using @FindBy
    @FindBy(css = ".action.showcart") 
    private WebElement cartIcon;
    
//    By cartIcon = By.xpath("//a[contains(@class,'action showcart')]");


    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']") 
    private WebElement proceedToCheckoutButton;
    
//    WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));

    @FindBy(name = "firstname") 
    private WebElement firstNameField;

    @FindBy(name = "lastname") 
    private WebElement lastNameField;

    @FindBy(name = "street[0]") 
    private WebElement streetAddressField;

    @FindBy(name = "city") 
    private WebElement cityField;
    
    @FindBy(name = "country_id")
    private WebElement countryField;
    
    @FindBy(name = "region_id")
    private WebElement stateField;

    @FindBy(name = "postcode") 
    private WebElement postcodeField;

    @FindBy(name = "telephone") 
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='ko_unique_2']") 
    private WebElement shippingMethodRadio;

    @FindBy(xpath = "//button[@data-role='opc-continue']") 
    private WebElement continueToPaymentButton;

    @FindBy(xpath = "//button[@title='Place Order']") 
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h1[text()='Thank you for your purchase!']") 
    private WebElement orderSuccessMessage;

    // Methods
    public void proceedToCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }


    public void enterShippingDetails(String firstName, String lastName, String street, String city, String country, String state, String postcode, String phone) {
    	firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        streetAddressField.sendKeys(street);
        cityField.sendKeys(city);
        countryField.sendKeys(country);
        countryField.click();
        stateField.sendKeys(state);
        stateField.click();
        postcodeField.sendKeys(postcode);
        phoneField.sendKeys(phone);
    }

    public void selectShippingAndContinue() {
        shippingMethodRadio.click();
        continueToPaymentButton.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public boolean isOrderSuccessful() {
        return orderSuccessMessage.isDisplayed();
    }
}
