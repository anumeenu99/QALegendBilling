package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class EditUserPage extends TestHelperUtility{
	public WebDriver driver;
	public EditUserPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _editlName="last_name";  
	@FindBy(id=_editlName)
	private WebElement editlName;
	private final String _updateButton="submit_user_button";  
	@FindBy(id=_updateButton)
	private WebElement updateButton;
	
	public String getEditUserPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void enterLastName(String lastn) {
		page.enterText(editlName,lastn);
	}
	public UsersPage clickOnUpdateButton() {
		page.clickOnElement(updateButton);
		return new UsersPage(driver);
	}
}
