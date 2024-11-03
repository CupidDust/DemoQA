package Automation.DemoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Automation.DemoQA.BasePage;

public class ElementsPage extends BasePage {

	public ElementsPage(WebDriver driver, String elementsText) {
		super(driver);
		// TODO Auto-generated constructor stub
		driver.findElement(By.xpath("//*[@class='header-text' and text()='" +elementsText+ "']//parent::div/parent::span//following-sibling::div[@class='element-list collapse show']"));
//		elementsText
		System.out.println("Elements dropdown xpath found successfully");
		
		
	}
	
	public static void TextBoxClickAndValidate()
	{
		driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Text Box']"));
		String textBox = driver.findElement(By.cssSelector(".text-center")).getText();
		
		softAssert.assertEquals(textBox, "Text Box", "Text Box text is mismatching");
		driver.findElement(By.cssSelector(".text-center")).click();
		String pageTextBox = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
		softAssert.assertEquals(pageTextBox, "Text Box", "Middle of page Text Box text mismatch");
//		Assert.assertEquals(textBox, "Text Box", "Assertion UnSuccessful: Text Box text is not present");
	}
}