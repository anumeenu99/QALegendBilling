package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
public class HomePage extends TestHelperUtility{
	public WebDriver driver;
	public HomePage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _signoutOption="//a[@class='dropdown-toggle']//following-sibling::span";  
	@FindBy(xpath=_signoutOption)
	private WebElement signoutOption;
	private final String _signoutButton="//a[text()='Sign Out']";  
	@FindBy(xpath=_signoutButton)
	private WebElement signoutButton;
	private final String _userManageSubTab="//span[@class='pull-right-container']";  
	@FindBy(xpath=_userManageSubTab)
	private WebElement userManageSubTab;
	private final String _usersTab="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a";  
	@FindBy(xpath=_usersTab)
	private WebElement usersTab;
	private final String _rolesTab="//i[@class='fa fa-briefcase']//following::span[1]";  
	@FindBy(xpath=_rolesTab)
	private WebElement rolesTab;
	
	public String getHomePageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void clickOnEfgpqrButton() {
		page.clickOnElement(signoutOption);
	}
	public LoginPage clickOnSignoutButton() {
		page.clickOnElement(signoutButton);
		return new LoginPage(driver);
	}
	public void clickOnUsermanageSubTab() {
		page.clickOnElement(userManageSubTab);
	}
	public UsersPage clickOnUsersTab() {
		page.clickOnElement(usersTab);
		return new UsersPage(driver);
	}
	public RolesPage clickOnRolesButton() {
		page.clickOnElement(rolesTab);
		return new RolesPage(driver);
	}
	
}
