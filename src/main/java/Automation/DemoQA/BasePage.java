package Automation.DemoQA;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasePage {
	protected static SoftAssert softAssert;
	protected WebDriverWait wait;
	protected String elementsText;

	protected WebDriver driver; // Class-level WebDriver instance
	static String projectPath = System.getProperty("user.dir");
	// Constructor to initialize WebDriver
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.softAssert = new SoftAssert(); // Initialize SoftAssert
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/*
	 * Method to scroll to an element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/*
	 * softAssertResults
	 */
	public static void softAssertResults() {
		softAssert.assertAll();
	}

	/*
	 * 
	 */
	public WebElement visibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Properties configProperties() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\Automation\\DemoQA\\config.properties");
		properties.load(fis);
		fis.close();
		return properties;
	}
	
	public static String loadFromProperties(String key) throws IOException
	{
		Properties properties = configProperties();
		return properties.getProperty(key);
	}
	
	public static void main(String[] args) throws InterruptedException {
	}
}
