package Automation.DemoQA.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import Automation.DemoQA.BasePage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ElementsPage extends BasePage {

	static String fullName;
	static String email;

	public ElementsPage(WebDriver driver, String elementsText) {
		super(driver);

		driver.findElement(By.xpath("//*[@class='header-text' and text()='" + elementsText
				+ "']//parent::div/parent::span//following-sibling::div[@class='element-list collapse show']"));
//		elementsText
		System.out.println("Elements dropdown xpath found successfully");
	}
//		XPaths starts here

	@FindBy(xpath = "//span[@class='text'][text()='Text Box']")
	private static WebElement byTextBoxText;

	@FindBy(css = ".text-center")
	private static WebElement byTextBoxHeading;

	@FindBy(id = "userName-label")
	private static WebElement byFullNameText;

	@FindBy(id = "userName")
	private static WebElement byFullNameField;

	@FindBy(id = "userEmail-label")
	private static WebElement byEmailText;

	@FindBy(id = "userEmail")
	private static WebElement byEmailField;

	@FindBy(id = "currentAddress-label")
	private static WebElement byCurrentAddressText;

	@FindBy(id = "currentAddress")
	private static WebElement byCurrentAddressField;

	@FindBy(id = "permanentAddress-label")
	private static WebElement byPermanentAddressText;

	@FindBy(id = "permanentAddress")
	private static WebElement byPermanentAddressField;

	@FindBy(id = "submit")
	private static WebElement bySubmitCTA;

	@FindBy(css = ".border.col-md-12.col-sm-12")
	private static WebElement byOutputBox;

	@FindBy(id = "name")
	private static WebElement byNameOutput;

	@FindBy(id = "email")
	private static WebElement byEmailOutput;

	@FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[@id='currentAddress']")
	private static WebElement byCurrentAddressOutput;

	@FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[@id='permanentAddress']")
	private static WebElement byPermanentAddressOutput;

	public static void TextBoxClickAndValidate() throws IOException {
		byTextBoxText.click();
		String textBox = byTextBoxHeading.getText();
		softAssert.assertEquals(textBox, "Text Box", "Middle of page Text Box text mismatch");
		String fullNameText = byFullNameText.getText();
		softAssert.assertEquals(fullNameText, "Full Name", "Full Name text is not present");
		byFullNameField.sendKeys(loadFromProperties("fullName"));
		byEmailField.sendKeys(loadFromProperties("email"));
		String currentAddressText = byCurrentAddressText.getText();
		softAssert.assertEquals(currentAddressText, "Current Address", "Current Address text is not present");
		byCurrentAddressField.sendKeys(loadFromProperties("currentAddress"));
		String PermanentAddressText = byPermanentAddressText.getText();
		softAssert.assertEquals(PermanentAddressText, "Permanent Address", "Permanent Address text is not present");
		byPermanentAddressField.sendKeys(loadFromProperties("permanentAddress"));
//		Reporter.log("This message will appear in the TestNG report", true);
		scrollToElement(bySubmitCTA);
		bySubmitCTA.click();
	}

	public static void OutputValidate() throws IOException {

		softAssert.assertEquals(byNameOutput.getText().split(":")[1], loadFromProperties("fullName"),
				"Full name is not displayed as expected input");

		softAssert.assertEquals(byEmailOutput.getText().split(":")[1], loadFromProperties("email"),
				"Email is not displayed as expected input");
		
		softAssert.assertEquals(byCurrentAddressOutput.getText().split(":")[1], loadFromProperties("currentAddress"),
				"CurrentAddress is not displayed as expected input");

		softAssert.assertEquals(byPermanentAddressOutput.getText().split(":")[1],
				loadFromProperties("permanentAddress"), "PermanentAddress is not displayed as expected input");
		
		softAssertResults();
	}

}