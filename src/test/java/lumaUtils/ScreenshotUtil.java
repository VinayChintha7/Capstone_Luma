package lumaUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Ensure driver is not null
            if (driver == null) {
                System.out.println("WebDriver instance is NULL! Cannot take screenshot.");
                return;
            }

            // Ensure screenshots folder exists
            File screenshotsDir = new File("screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdir();
            }

            // Capture screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Create timestamped filename
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filepath = "screenshots/" + screenshotName + "_" + timestamp + ".png";

            // Save the screenshot
            FileUtils.copyFile(src, new File(filepath));

            // Debugging
            System.out.println("Screenshot saved successfully at: " + filepath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot!");
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("WebDriver does not support screenshots! Check the browser setup.");
            e.printStackTrace();
        }
    }
    public static void takeScreenshot1(WebDriver driver, String filename) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + filename);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("📸 Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

////Take the screenshot logic
//	public static void screenshot() throws IOException
//	{
//		//Take the screenshot as proof
//		File src=null;
//		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(src, new File("./screenshots/"+"page-"+System.currentTimeMillis()+".png"));
//	}