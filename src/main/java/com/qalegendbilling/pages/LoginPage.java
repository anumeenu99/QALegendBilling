package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.pages.UserAccountPage;
import com.qalegendbilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility{
	public WebDriver driver;
	public LoginPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _usernameField="username";  
	@FindBy(id=_usernameField)
	private WebElement usernameField;
	private final String _passwordField="password";  
	@FindBy(id=_passwordField)
	private WebElement passwordField;
	private final String _loginButton="//button[@class='btn btn-primary']";  
	@FindBy(xpath=_loginButton)
	private WebElement loginButton;
	private final String _errorMessage="//strong[text()='These credentials do not match our records.']";  
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	private final String _forgetPassword="//a[@class='btn btn-link']";  
	@FindBy(xpath=_forgetPassword)
	private WebElement forgetPassword;
	private final String _endTour="//button[@class='btn btn-default btn-sm']";  
	@FindBy(xpath=_endTour)
	private WebElement endTour;
	private final String _rememberMe="//div[@class='checkbox']";  
	@FindBy(xpath=_rememberMe)
	private WebElement rememberMe;
	private final String _resetErrorMessage="//span[@class='help-block']//following-sibling::strong";  
	@FindBy(xpath=_resetErrorMessage)
	private WebElement resetErrorMessage;
	private final String _newUserAccount="username";  
	@FindBy(id=_newUserAccount)
	private WebElement newUserAccount;
	
	public String getLoginPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void enterUserName(String username) {
		page.enterText(usernameField,username);
	}
	public void enterPassword(String pass) {
		page.enterText(passwordField,pass);
	}
	public void clickOnLoginButton() {
		page.clickOnElement(loginButton);
	}
	public HomePage clickLoginButton() {
		page.clickOnElement(loginButton);
		return new HomePage(driver);
	}
	public String getErrorMessage() {
		String errMessage=page.getElementText(errorMessage);
		return errMessage;
	}
	public ResetPage clickForgetPassword() {
		page.clickOnElement(forgetPassword);
		return new ResetPage(driver);
	}
	public void clickOnEndTourButton() {
		page.clickOnElement(endTour);
	}
	public void isSelected() {
		page.clickOnElement(rememberMe);
	}
	public String errorMessage() {
		String errMessage=page.getElementText(resetErrorMessage);
		return errMessage;
	}
	public void enterLoginCredentials(String username,String pass) {
		page.enterText(usernameField,username);
		page.enterText(passwordField,pass);
	}
	public void enterNewUserName(String username) {
		page.enterText(newUserAccount,username);
	}
	
}
