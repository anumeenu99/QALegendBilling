package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddUserPage extends TestHelperUtility{
	public WebDriver driver;
	public AddUserPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _firstNameField="first_name";  
	@FindBy(id=_firstNameField)
	private WebElement firstNameField;
	private final String _emailField="email";  
	@FindBy(id=_emailField)
	private WebElement emailField;
	private final String _rolelField="select2-role-container";  
	@FindBy(id=_rolelField)
	private WebElement rolelField;
	private final String _passwordField="password";  
	@FindBy(id=_passwordField)
	private WebElement passwordField;
	private final String _confirmpassField="confirm_password";  
	@FindBy(id=_confirmpassField)
	private WebElement confirmpassField;
	private final String _usernameField="username";  
	@FindBy(id=_usernameField)
	private WebElement usernameField;
	private final String _saveButton="submit_user_button";  
	@FindBy(id=_saveButton)
	private WebElement saveButton;
	private final String _firstNameValidate="first_name-error";  
	@FindBy(id=_firstNameValidate)
	private WebElement firstNameValidate;
	private final String _emailValidate="email-error";  
	@FindBy(id=_emailValidate)
	private WebElement emailValidate;
	private final String _passwordValidate="password-error";  
	@FindBy(id=_passwordValidate)
	private WebElement passwordValidate;
	private final String _confirmpassValidate="confirm_password-error";  
	@FindBy(id=_confirmpassValidate)
	private WebElement confirmpassValidate;
	
	public void enterFirstName(String firstName) {
		page.enterText(firstNameField,firstName);
	}
	public void enterEmail(String email) {
		page.enterText(emailField,email);
	}
	public void enterRole(String role) {
		page.enterText(rolelField,role);
	}
	public void enterPassword(String password) {
		page.enterText(passwordField,password);
	}
	public void enterConfirmPassword(String confirmPassword) {
		page.enterText(confirmpassField,confirmPassword);
	}
	public void enterUsername(String username) {
		page.enterText(usernameField,username);
	}
	public void enterAddUserDetails(String username,String firstName,String email,String role,String password,String confirmPassword) {
		page.enterText(firstNameField,firstName);
		page.enterText(emailField,email);
		page.enterText(rolelField,role);
		page.enterText(passwordField,password);
		page.enterText(confirmpassField,confirmPassword);
		page.enterText(usernameField,username);
	}
	public UsersPage clickOnSaveButton() {
		page.clickOnElement(saveButton);
		return new UsersPage(driver);
	}
	public void clickOnSavebutton() {
		page.clickOnElement(saveButton);
	}
	public String getAddUserPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public String validationMessage(String errorMessage) {
		page.getElementText(firstNameValidate);
		page.getElementText(emailValidate);
		page.getElementText(passwordValidate);
		page.getElementText(confirmpassValidate);
		return errorMessage;
	}
}
