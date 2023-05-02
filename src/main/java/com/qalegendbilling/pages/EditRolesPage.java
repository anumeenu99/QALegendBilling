package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class EditRolesPage extends TestHelperUtility{
	public WebDriver driver;
	public EditRolesPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public String getEditRolesPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
}
