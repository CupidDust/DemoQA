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

	@FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
	private WebElement byImgToolsQA;
	// only Xpath here
	@FindBy(xpath = "//h5[contains(text(), 'Elements')]")
	private WebElement byBtnElements;

	public void LogoCheck() {
		visibilityOf(byImgToolsQA);
		softAssert.assertTrue(byImgToolsQA.isDisplayed(), "Tools QA image is not visible");
	}

	public ElementsPage clickOnElements() {
		scrollToElement(byBtnElements);
		softAssert.assertEquals(byBtnElements.getText(), "Elements", "Element text is mismatching");
		byBtnElements.click();
		System.out.print("Click on elements button");
		return new ElementsPage(driver);

	}

	// Only methoids here
}
