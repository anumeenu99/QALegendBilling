package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ViewUserPage extends TestHelperUtility{
	public WebDriver driver;
	public ViewUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private final String _viewDetails="//section[@class='content']";  
	@FindBy(xpath=_viewDetails)
	private WebElement viewDetails;
	private final String _errorviewMessage="//p//following::p[1]";  
	@FindBy(xpath=_errorviewMessage)
	private WebElement errorviewMessage;
	
	public void isDisplayed() {
		page.clickOnElement(viewDetails);
	}
	public String getErrorMessage() {
		String errMessage=page.getElementText(errorviewMessage);
		return errMessage;
	}

}
