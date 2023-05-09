package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.WaitUtility;

public class SalesCommissionPage extends TestHelperUtility{
	public WebDriver driver;
	public SalesCommissionPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _addButton="//button[@class='btn btn-primary btn-modal pull-right']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _firstNameField="first_name";  
	@FindBy(id=_firstNameField)
	private WebElement firstNameField;
	private final String _lastNameField="last_name";  
	@FindBy(id=_lastNameField)
	private WebElement lastNameField;
	private final String _emailField="email";  
	@FindBy(id=_emailField)
	private WebElement emailField;
	private final String _contactField="contact_no";  
	@FindBy(id=_contactField)
	private WebElement contactField;
	private final String _addressField="address";  
	@FindBy(id=_addressField)
	private WebElement addressField;
	private final String _salesField="cmmsn_percent";  
	@FindBy(id=_salesField)
	private WebElement salesField;
	private final String _saveButton="//button[@class='btn btn-primary']";  
	@FindBy(xpath=_saveButton)
	private WebElement saveButton;
	private final String _searchField="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_searchField)
	private WebElement searchField;
	private final String _editButton="//button[@class='btn btn-xs btn-modal btn-primary']";  
	@FindBy(xpath=_editButton)
	private WebElement editButton;
	private final String _deleteSales="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_deleteSales)
	private WebElement deleteSales;
	private final String _deleteButton="//button[@class='btn btn-xs btn-danger delete_commsn_agnt_button']";  
	@FindBy(xpath=_deleteButton)
	private WebElement deleteButton;
	private final String _popupButton="//button[@class='swal-button swal-button--confirm swal-button--danger']";  
	@FindBy(xpath=_popupButton)
	private WebElement popupButton;
	/*private final String _parentwindow="//div[@class=' content-wrapper ']";  
	@FindBy(xpath=_parentwindow)
	private WebElement parentwindow;*/
	
	public String getSalesCommissionPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void clickOnAddButton() {
		page.clickOnElement(addButton);
	}
	public void enterFirstName(String fname) {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _firstNameField,WaitUtility.LocatorType.Xpath);
		page.enterText(firstNameField,fname);
	}
	public void enterlastName(String lname) {
		page.enterText(lastNameField,lname);
	}
	public void enterEmail(String emailid) {
		page.enterText(emailField,emailid);
	}
	/*public void enterContact(String contactnumber) {
		page.enterText(contactField,contactnumber);
	}
	public void enterAddress(String addressdetails) {
		page.enterText(addressField,addressdetails);
	}
	public void enterSales(String salesPercentage) {
		page.enterText(salesField,salesPercentage);
	}*/
	public void clickOnSaveButton() {
		page.clickOnElement(saveButton);
	}
	public void enterSalesFname(String fname) {
		page.enterText(searchField,fname);
	}
	public EditSalesPage clickOnEditButton() {
		page.clickOnElement(editButton);
		return new EditSalesPage(driver);
	}
	public void enterDeleteSales(String delete) {
		page.enterText(deleteSales,delete);
	}
	public void clickOnDeleteButton() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _deleteButton,WaitUtility.LocatorType.Xpath);
		page.clickOnElement(deleteButton);
	}
	public void clickOnPopupButton() {
		page.clickOnElement(popupButton);
	}
	
}
