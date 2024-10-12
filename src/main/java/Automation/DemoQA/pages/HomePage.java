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

	public void LogoCheck() {
		visibilityOf(byImgToolsQA);
		softAssert.assertTrue(byImgToolsQA.isDisplayed(), "Tools QA image is not visible");
	}

}
