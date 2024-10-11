package Automation.DemoQA;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


//Inheriting all the properties from BasePage
public class ElementsPage extends BasePage {
	
	public ElementsPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void ValidateElementsPageURL()
	{
	// Call the reusable method
    ElementsCheck();
    CurrentElementsPageURL = driver.getCurrentUrl();
    softAssert.assertEquals(CurrentElementsPageURL, "https://demoqa.com/elements", "URL is changed. Have a look");
    softAssert.assertAll();
	}
	
	
}
