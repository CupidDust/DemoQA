package Automation.DemoQA;

import org.openqa.selenium.WebDriver;        // Import for WebDriver
import org.openqa.selenium.edge.EdgeDriver; // Import for EdgeDriver

public class DriverInvoke {
	
	private static WebDriver driver;
	
	public static WebDriver initializeDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\Automation\\Drivers\\Edge Driver\\msedgedriver.exe");
        driver = new EdgeDriver();
        return driver;
    }
	
	public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
