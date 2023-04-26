package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility{
	public WebDriver driver;
	public ResetPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private final String _resetEmail="email";  
	@FindBy(id=_resetEmail)
	private WebElement resetEmail;
	private final String _resetLink="//button[@class='btn btn-primary']";  
	@FindBy(xpath=_resetLink)
	private WebElement resetLink;
	
	public void enterEmail(String reEmail) {
		page.enterText(resetEmail,reEmail);
	}
	public void clickOnResetLink() {
		page.clickOnElement(resetLink);
	}
}
