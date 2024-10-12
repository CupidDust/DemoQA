package Automation.DemoQA;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasePage {
	String CurrentElementsPageURL;
	SoftAssert softAssert;
	String Current_Instruction_Text;
	String CurrentFooterText;

	WebDriver driver; // Class-level WebDriver instance

	// Constructor to initialize WebDriver
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.softAssert = new SoftAssert(); // Initialize SoftAssert
	}

	public void LogoCheck() {
		driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
	}

	public void Validate_Instruction_Text() {
		Current_Instruction_Text = driver.findElement(By.xpath("//div[contains(text(), 'to start practice.')]"))
				.getText();
		softAssert.assertEquals(Current_Instruction_Text, "Please select an item from left to start practice.");
		softAssert.assertAll();
	}

	public void FooterCheck() {
		CurrentFooterText = driver.findElement(By.xpath("//span[contains(text(), 'TOOLSQA.COM')]")).getText();
		softAssert.assertEquals(CurrentFooterText, "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.");
	}

	// Method to scroll to an element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Method to check elements (reusable method)
	public void ElementsCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementsText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Elements')]")));

//         Scroll to the element before checking its text
		scrollToElement(elementsText);
//    public void elementsTabCheck()
//    {
//    	
//    WebElement elementsText = driver.findElement(By.xpath("//h5[.='Elements']"));
		if (elementsText.getText().equals("Elements")) {
			elementsText.click();
		} else {
			System.out.println("Elements text is mismatching");
		}
	}

	public void FormsCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement formsText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Forms')]")));

//         Scroll to the element before checking its text
		scrollToElement(formsText);
	}

	public void Alerts_Frame_WindowsCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Alerts_Frame_WindowsText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")));

//         Scroll to the element before checking its text
		scrollToElement(Alerts_Frame_WindowsText);
	}

	public void WidgetsCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement WidgetsText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Widgets')]")));

//         Scroll to the element before checking its text
		scrollToElement(WidgetsText);
	}

	public void InteractionsCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement InteractionsText = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Interactions')]")));

//         Scroll to the element before checking its text
		scrollToElement(InteractionsText);
	}

	public void Book_Store_ApplicationCheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Book_Store_ApplicationText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Book Store Application')]")));

//         Scroll to the element before checking its text
		scrollToElement(Book_Store_ApplicationText);
	}

	public static void main(String[] args) throws InterruptedException {
		// Initialize the driver from DriverSetup
		WebDriver driver = DriverInvoke.initializeDriver();

		// Navigate to a website
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000); // Thread.sleep is in milliseconds, so use 5000 for 5 seconds.

		// Close the driver
		DriverInvoke.closeDriver();
	}
}
