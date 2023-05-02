package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddRolesPage extends TestHelperUtility{
	public WebDriver driver;
	public AddRolesPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _roleNameField="name";  
	@FindBy(id=_roleNameField)
	private WebElement roleNameField;
	private final String _rolesCheckBox="//ins[@class='iCheck-helper'][1]";  
	@FindBy(xpath=_rolesCheckBox)
	private WebElement rolesCheckBox;
	private final String _saveButton="//button[@class='btn btn-primary pull-right']";  
	@FindBy(xpath=_saveButton)
	private WebElement saveButton;
	
	public String getAddRolesPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void enterRoleName(String rolename) {
		page.enterText(roleNameField,rolename);
	}
	public void clickOnRolesCheckBox() {
		page.clickOnElement(rolesCheckBox);
	}
	public RolesPage clickOnSaveButton() {
		page.clickOnElement(saveButton);
		return new RolesPage(driver);
	}
}
