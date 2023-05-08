package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.WaitUtility;

public class RolesPage extends TestHelperUtility{
	public WebDriver driver;
	public RolesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _addButton="//a[@class='btn btn-block btn-primary']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _editButton="//a[@class='btn btn-xs btn-primary']";  
	@FindBy(xpath=_editButton)
	private WebElement editButton;
	public final String _searchField="//input[@class='form-control input-sm']";
	@FindBy(xpath=_searchField)
	private WebElement searchField;
	public final String _deleteRoleButton="//tr[@class='even']//button[@class='btn btn-xs btn-danger delete_role_button']";
	@FindBy(xpath=_deleteRoleButton)
	private WebElement deleteRoleButton;
	public final String _popupButton="//button[text()='OK']";
	@FindBy(xpath=_popupButton)
	private WebElement popupButton;

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
	public void enterRole(String role) {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _searchField,WaitUtility.LocatorType.Xpath);
		page.enterText(searchField,role);
	}
	public void clickOnDeleteButton() {
		page.clickOnElement(deleteRoleButton);
	}
	public void clickOnPopupButton() {
		page.clickOnElement(popupButton);
	}
}
