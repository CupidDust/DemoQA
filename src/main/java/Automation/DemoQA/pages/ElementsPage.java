package Automation.DemoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Automation.DemoQA.BasePage;

public class ElementsPage extends BasePage {

	public ElementsPage(WebDriver driver, String elementsText) {
		super(driver);
		// TODO Auto-generated constructor stub
		driver.findElement(By.xpath("//*[@class='header-text' and text()='" +elementsText+ "']//parent::div/parent::span//following-sibling::div[@class='element-list collapse show']"));
//		elementsText
		System.out.println("Elements dropdown xpath found successfully");
	}

}
