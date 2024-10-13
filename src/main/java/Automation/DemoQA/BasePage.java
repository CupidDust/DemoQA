package Automation.DemoQA;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasePage {
	protected SoftAssert softAssert;
	protected WebDriverWait wait;

	protected WebDriver driver; // Class-level WebDriver instance

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
	public void softAssertResults() {
		softAssert.assertAll();
	}

	/*
	 * 
	 */
	public WebElement visibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void main(String[] args) throws InterruptedException {
	}
}
