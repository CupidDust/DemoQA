package Automation.DemoQA;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Automation.DemoQA.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private static WebDriver driver;

	private HomePage homePage;
	
	@BeforeTest
	public static WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		return driver;
	}

	@AfterTest
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void firstTC() {
		homePage = new HomePage(driver);
		homePage.LogoCheck();
		homePage.clickOnElements();
		homePage.softAssertResults();
	}
}
