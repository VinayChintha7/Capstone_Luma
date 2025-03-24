package lumaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class SearchAndAddToCartPage {
    private WebDriver driver;
    private WebDriverWait wait;  // ✅ Add WebDriverWait

    // Locators
    private By menMenu = By.xpath("//span[text()='Men']");
    private By topsMenu = By.id("ui-id-17");
    private By jacketsMenu = By.linkText("Jackets");
    private By jupiterJacket = By.xpath("//a[contains(text(),'Jupiter All-Weather Trainer ')]");
    private By sizeM = By.xpath("//div[@aria-label='XL']");
    private By colorBlue = By.xpath("//div[@option-label='Blue']");
    private By addToCart = By.xpath("//button[@title='Add to Cart']");

    // Constructor
    public SearchAndAddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Add Explicit Wait
    }

    // Navigate to Jackets Section
    public void navigateToJackets() {
        Actions actions = new Actions(driver);

        WebElement men = wait.until(ExpectedConditions.visibilityOfElementLocated(menMenu)); // Wait for Men Menu
        actions.moveToElement(men).perform();

        WebElement tops = wait.until(ExpectedConditions.visibilityOfElementLocated(topsMenu)); // Wait for Tops
        actions.moveToElement(tops).perform();

        WebElement jackets = wait.until(ExpectedConditions.elementToBeClickable(jacketsMenu)); // Wait for Jackets
        actions.moveToElement(jackets).click().perform();
    }

    // Select and Add Jacket to Cart
    public void addJupiterJacketToCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(jupiterJacket)).click(); // ✅ Wait for Product
        wait.until(ExpectedConditions.elementToBeClickable(sizeM)).click(); // ✅ Wait for Size
        wait.until(ExpectedConditions.elementToBeClickable(colorBlue)).click(); // ✅ Wait for Color
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click(); // ✅ Wait for Add to Cart
        
        Thread.sleep(2000);;
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(@class,'action showcart')]"));
        cartIcon.click();
        Thread.sleep(2000);
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
        proceedToCheckoutButton.click();
        Thread.sleep(2000);
    }
}
