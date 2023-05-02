package com.qalegendbilling.basetest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.EditRolesPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class RolesBaseTest extends Base{
	HomePage home;
	LoginPage login;
	RolesPage roles;
	AddRolesPage addroles;
	EditRolesPage editroles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void addRolesPageTitle() {
		//extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		login.enterPassword(passwd);
		home=login.clickLoginButton();
		login.clickOnEndTourButton();
		home.clickOnUsermanageSubTab();
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=addroles.getAddRolesPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.ADD_ROLES_PAGE_TITLE);
	}
	
	public void addRoles() {
		//extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		login.enterPassword(passwd);
		home=login.clickLoginButton();
		login.clickOnEndTourButton();
		home.clickOnUsermanageSubTab();
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		addroles=roles.clickOnAddButton();
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String role = data1.get(1).get(1);
		addroles.enterRoleName(role);
		addroles.clickOnRolesCheckBox();
		roles=addroles.clickOnSaveButton();
	}
	
	public void editRolePageTitle() {
		//extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		login.enterPassword(passwd);
		home=login.clickLoginButton();
		login.clickOnEndTourButton();
		home.clickOnUsermanageSubTab();
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		editroles=roles.clickOnEditButton();
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("RolesPage");
		String expRolespageTitle = data1.get(1).get(1);
		String actRolespageTitle=editroles.getEditRolesPageTitle();
		Assert.assertEquals(expRolespageTitle,actRolespageTitle,ErrorMessages.EDIT_ROLES_PAGE_TITLE);
	}
}
