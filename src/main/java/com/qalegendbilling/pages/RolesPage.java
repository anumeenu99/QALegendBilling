package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class RolesPage extends TestHelperUtility{
	public WebDriver driver;
	public RolesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _addButton="//a[@class='btn btn-block btn-primary']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _editButton="//a[@class='btn btn-xs btn-primary'][1]";  
	@FindBy(xpath=_editButton)
	private WebElement editButton;

	public String getRolesPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public AddRolesPage clickOnAddButton() {
		page.clickOnElement(addButton);
		return new AddRolesPage(driver);
	}
	public EditRolesPage clickOnEditButton() {
		page.clickOnElement(editButton);
		return new EditRolesPage(driver);
	}
}
