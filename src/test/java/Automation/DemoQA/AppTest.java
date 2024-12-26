package Automation.DemoQA;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.DemoQA.pages.ElementsPage;
import Automation.DemoQA.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static WebDriver driver;

	private HomePage homePage;
	private ElementsPage elementsPage;

	@Parameters({ "driverURL" })

	@BeforeTest
	public static WebDriver initializeDriver(String driverurl) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(driverurl);
		driver.manage().window().maximize();
		return driver;
	}

//	@AfterTest
//	public static void closeDriver() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

//	@Test
//	public void shouldAnswerWithTrue() {
//		assertTrue(true);
//	}

	@Test
	public void firstTC() throws IOException {
		homePage = new HomePage(driver);
		homePage.logoDisplayCheck();
		homePage.logoClickCheck();
		homePage.verifyElementsText();

		elementsPage = homePage.clickOnElements(); // Call this method to navigate to ElementsPage
		ElementsPage.TextBoxClickAndValidate();
		ElementsPage.OutputValidate();
//		homePage.verifyFormsText();
////		homePage.clickOnForms();
//		homePage.verifyAlertFrameWindowsText();
////		homePage.clickOnAlertFrameWindows();
//		homePage.verifyWidgetsText();
////		homePage.clickOnWidgets();
//		homePage.verifyInteractionsText();
////		homePage.clickOnInteractions();
//		homePage.verifyBookStoreApplicationsText();
////		homePage.clickOnBookStoreApplications();
//		homePage.verifyCopyRightText();
		homePage.softAssertResults();

	}

}
