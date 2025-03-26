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

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Explicit Wait for Stability
    }
//Enter all the shipping details needed.
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

        // Wait for the "Next" button to be clickable
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,150)");
    	
    	Thread.sleep(2000); //wait so that button is visible to click
    	driver.findElement(By.xpath("//input[@value='tablerate_bestway']")).click();
    	Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
        
    }

    public void placeOrder() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Place Order']")).click(); //placing order
         
    }

    public void isOrderSuccessful() {
    	System.out.println("Order Placed Successfully.");
    	
    }
}

