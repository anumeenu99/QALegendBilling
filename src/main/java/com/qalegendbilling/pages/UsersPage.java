package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UsersPage extends TestHelperUtility{
	public WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _addButton="//a[@class='btn btn-block btn-primary']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _searchField="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_searchField)
	private WebElement searchField;
	private final String _usernameField="username";  
	@FindBy(id=_usernameField)
	private WebElement usernameField;
	
	public String getUserPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public AddUserPage clickOnAddButton() {
		page.clickOnElement(addButton);
		return new AddUserPage(driver);
	}
	public void enterSearchField(String username) {
		page.enterText(usernameField,username);
	}
}
