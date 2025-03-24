package lumaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
	private WebDriverWait wait;
    

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit wait
        PageFactory.initElements(driver, this);  // ✅ Initialize PageFactory
    }

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

    @FindBy(xpath = "//input[@class='radio']") 
    private WebElement shippingMethodRadio;

    @FindBy(xpath = "//button[@data-role='opc-continue']") 
    private WebElement continueToPaymentButton;

    @FindBy(xpath = "//button[@title='Place Order']") 
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h1[text()='Thank you for your purchase!']") 
    private WebElement orderSuccessMessage;

//Methods
    public void enterShippingDetails(String firstName, String lastName, String street, String city, String country, String state, String postcode, String phone) throws InterruptedException {
    	firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        streetAddressField.sendKeys(street);
        cityField.sendKeys(city);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", countryField);
        Thread.sleep(2000);  // Small delay to allow scrolling

        countryField.click();  // Now perform the click
        countryField.sendKeys(country);
        
   
//        wait.until(ExpectedConditions.elementToBeClickable(stateField)).click();
        stateField.sendKeys(state);
        stateField.click();
        
        postcodeField.sendKeys(postcode);
        phoneField.sendKeys(phone);
        
        Thread.sleep(2000);
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
