package lumaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCartPage {
	private WebDriver driver;
    private WebDriverWait wait;

	public EditCartPage(WebDriver driver) {
		 this.driver = driver;
	     this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Add Explicit Wait
	}
	
	public void editCount() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='logo']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(3000);
		
		WebElement count = driver.findElement(By.xpath("//input[@class='item-qty cart-item-qty']"));
		count.click();
		Thread.sleep(1000);
		count.clear();
		count.sendKeys("1");
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//button[@class='update-cart-item']")).click();
		
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		Thread.sleep(2000);
	}
}
