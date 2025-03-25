package lumaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By addressField = By.name("street[0]");
    private By cityField = By.name("city");
    private By countryDropdown = By.name("country_id");
    private By stateDropdown = By.name("region_id");
    private By zipCode = By.name("postcode");
    private By phoneNumber = By.name("telephone");
    private By shippingMethod = By.xpath("//input[@name='shipping_method']");
    private By continueButton = By.xpath("//button[contains(@class,'continue')]");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    private By orderSuccessMessage = By.xpath("//h1[contains(text(),'Thank you for your purchase')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Explicit Wait for Stability
    }

    public void enterShippingDetails(String fName, String lName, String address, String city, String country, String state, String zip, String phone) {
        WebElement fNameField = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        fNameField.clear();
        fNameField.sendKeys(fName);

        WebElement lNameField = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        lNameField.clear();
        lNameField.sendKeys(lName);

        WebElement addressFieldElement = wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressFieldElement.clear();
        addressFieldElement.sendKeys(address);

        WebElement cityFieldElement = wait.until(ExpectedConditions.elementToBeClickable(cityField));
        cityFieldElement.clear();
        cityFieldElement.sendKeys(city);

        WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        countryElement.sendKeys(country);

        WebElement stateElement = wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        stateElement.sendKeys(state);

        WebElement zipCodeElement = wait.until(ExpectedConditions.elementToBeClickable(zipCode));
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zip);

        WebElement phoneElement = wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void selectShippingAndContinue() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the shipping method options to be visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//input[@value='tablerate_bestway']"))).click();

        // Select the $0.00 "Table Rate - Best Way" shipping method
//        WebElement freeShippingOption = driver.findElement(By.cssSelector("input[name='shipping_method'][value='flatrate_flatrate']"));
//        if (!freeShippingOption.isSelected()) {
//            freeShippingOption.click();
//        }

        // Wait for the "Next" button to be clickable
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,150)");
    	
//    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='tablerate_bestway']")));
//    	WebElement shippingOption = driver.findElement(By.cssSelector("input[value='tablerate_bestway']"));
//    	shippingOption.click();

    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@value='tablerate_bestway']")).click();
    	Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
        
        // Click the "Next" button
//        nextButton.click();
       

    }

    public void placeOrder() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
         
    }

    public void isOrderSuccessful() {
//    	WebElement success = driver.findElement(By.linkText("Thank you for your purchase!"));
//    	success.getText();
    	System.out.println("Order Placed Successfully.");
    	
    }
}





















//package lumaPages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class CheckoutPage {
//    WebDriver driver;
//	private WebDriverWait wait;
//    
//
//    // Constructor
//    public CheckoutPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit wait
//        PageFactory.initElements(driver, this);  // ✅ Initialize PageFactory
//    }
//
//    @FindBy(name = "firstname") 
//    private WebElement firstNameField;
//
//    @FindBy(name = "lastname") 
//    private WebElement lastNameField;
//
//    @FindBy(name = "street[0]") 
//    private WebElement streetAddressField;
//
//    @FindBy(name = "city") 
//    private WebElement cityField;
//    
//    @FindBy(name = "country_id")
//    private WebElement countryField;
//    
//    @FindBy(name = "region_id")
//    private WebElement stateField;
//
//    @FindBy(name = "postcode") 
//    private WebElement postcodeField;
//
//    @FindBy(name = "telephone") 
//    private WebElement phoneField;
//
////    @FindBy(xpath = "//input[@class='radio']") 
////    private WebElement shippingMethodRadio;
//
//    @FindBy(xpath = "//button[@data-role='opc-continue']") 
//    private WebElement continueToPaymentButton;
//
//    @FindBy(xpath = "//button[@title='Place Order']") 
//    private WebElement placeOrderButton;
//
//    @FindBy(xpath = "//h1[text()='Thank you for your purchase!']") 
//    private WebElement orderSuccessMessage;
//
////Methods
//    public void enterShippingDetails(String firstName, String lastName, String street, String city, String country, String state, String postcode, String phone) throws InterruptedException {
//    	firstNameField.sendKeys(firstName);
//        lastNameField.sendKeys(lastName);
//        streetAddressField.sendKeys(street);
//        cityField.sendKeys(city);
//        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", countryField);
//        Thread.sleep(2000);  // Small delay to allow scrolling
//
//        countryField.click();  // Now perform the click
//        countryField.sendKeys(country);
//        
//   
////        wait.until(ExpectedConditions.elementToBeClickable(stateField)).click();
//        stateField.sendKeys(state);
//        stateField.click();
//        
//        postcodeField.sendKeys(postcode);
//        phoneField.sendKeys(phone);
//        
//        Thread.sleep(2000);
//    }
//
//    public void selectShippingAndContinue() {
////        shippingMethodRadio.click();
//        continueToPaymentButton.click();
//    }
//
//    public void placeOrder() {
//        placeOrderButton.click();
//    }
//
//    public boolean isOrderSuccessful() {
//        return orderSuccessMessage.isDisplayed();
//    }
//}
