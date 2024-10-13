package Automation.DemoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Automation.DemoQA.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	XPaths start below

	@FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
	private WebElement byImgToolsQA;

	@FindBy(xpath = "//h5[contains(text(), 'Elements')]")
	private WebElement byBtnElements;

	@FindBy(xpath = "//h5[contains(text(), 'Forms')]")
	private WebElement byBtnForms;

	@FindBy(xpath = "//h5[contains(text(), 'Alerts, Frame')]")
	private WebElement byBtnAlertFrames;

	@FindBy(xpath = "//h5[contains(text(), 'Widgets')]")
	private WebElement byBtnWidgets;

	@FindBy(xpath = "//h5[contains(text(), 'Interactions')]")
	private WebElement byBtnInteractions;

	@FindBy(xpath = "//h5[contains(text(), 'Book Store')]")
	private WebElement byBtnBookStoreApplication;

	@FindBy(xpath = "//span[contains(text(), 'ALL RIGHTS')]")
	private WebElement byBtnCopyRight;

//	Methods Start Below:

	public void logoDisplayCheck() {
		visibilityOf(byImgToolsQA);
		softAssert.assertTrue(byImgToolsQA.isDisplayed(), "Tools QA image is not visible");
		System.out.println("Logo is Checked");
	}

	public void logoClickCheck() {
		logoDisplayCheck();
		byImgToolsQA.click();
		softAssert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
		System.out.println("Logo clicked and navigated successfully");
	}

	// Method to verify Elements text
	public void verifyElementsText() {
		scrollToElement(byBtnElements);
		softAssert.assertEquals(byBtnElements.getText(), "Elements", "Element text is mismatching");
		System.out.println("Verified Elements button text.");
	}

	// Method to click Elements button
	public ElementsPage clickOnElements() {
		verifyElementsText();
		byBtnElements.click();
		System.out.print("Click on Elements button");
		return new ElementsPage(driver);

	}

	// Method to verify Forms button text
	public void verifyFormsText() {
		scrollToElement(byBtnForms);
		softAssert.assertEquals(byBtnForms.getText(), "Forms", "Forms text is mismatching");
		System.out.println("Verified Forms button text.");
	}

	// Method to click on Forms button
	public FormsPage clickOnForms() {
		verifyFormsText();
		byBtnForms.click();
		System.out.println("Clicked on Forms button");
		return new FormsPage(driver);
	}

	// Method to verify Alerts, Frame & Windows button text
	public void verifyAlertFrameWindowsText() {
		scrollToElement(byBtnAlertFrames);
		softAssert.assertEquals(byBtnAlertFrames.getText(), "Alerts, Frame & Windows",
				"Alerts, Frame & Windows text is mismatching");
		System.out.println("Verified Alerts, Frame & Windows button text.");
	}

	// Method to click on Alerts, Frame & Windows button
	public Alerts_Frame_WindowsPage clickOnAlertFrameWindows() {
		verifyAlertFrameWindowsText();
		byBtnAlertFrames.click();
		System.out.println("Clicked on Alerts, Frame & Windows button");
		return new Alerts_Frame_WindowsPage(driver);
	}

	// Method to verify Widgets button text
	public void verifyWidgetsText() {
		scrollToElement(byBtnWidgets);
		softAssert.assertEquals(byBtnWidgets.getText(), "Widgets", "Widgets text is mismatching");
		System.out.println("Verified Widgets button text.");
	}

	// Method to click on Widgets button
	public WidgetsPage clickOnWidgets() {
		verifyWidgetsText();
		byBtnWidgets.click();
		System.out.println("Clicked on Widgets button");
		return new WidgetsPage(driver);
	}

	// Method to verify Interactions button text
	public void verifyInteractionsText() {
		scrollToElement(byBtnInteractions);
		softAssert.assertEquals(byBtnInteractions.getText(), "Interactions", "Interactions text is mismatching");
		System.out.println("Verified Interactions button text.");
	}

	// Method to click on Interactions button
	public InteractionsPage clickOnInteractions() {
		verifyInteractionsText();
		byBtnInteractions.click();
		System.out.println("Clicked on Interactions button");
		return new InteractionsPage(driver);
	}

	// Method to verify Book Store Application button text
	public void verifyBookStoreApplicationsText() {
		scrollToElement(byBtnBookStoreApplication);
		softAssert.assertEquals(byBtnBookStoreApplication.getText(), "Book Store Application",
				"Book Store Application text is mismatching");
		System.out.println("Verified Book Store Application button text.");
	}

	// Method to click on Book Store Application button
	public BookStoreApplicationPage clickOnBookStoreApplications() {
		verifyBookStoreApplicationsText();
		byBtnBookStoreApplication.click();
		System.out.println("Clicked on Book Store Application button");
		return new BookStoreApplicationPage(driver);
	}

//	Method to verify CopyRight
	public void verifyCopyRightText() {
		softAssert.assertEquals(byBtnCopyRight.getText(), "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.",
				"CopyRight text is mismatching");
		System.out.println("CopyRight text is verified");
	}

}
