package com.qalegendbilling.basetest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtentLogMessage;
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
	
	public void addRolesPageTitle(){
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_BUTTON_CLICK);
		addroles=roles.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=addroles.getAddRolesPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.ADD_ROLES_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void addRoles(){
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_BUTTON_CLICK);
		addroles=roles.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String role = data1.get(1).get(1);
		addroles.enterRoleName(role);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_NAME_ENTER);
		addroles.clickOnRolesCheckBox();
		addroles.clickOnViewRole();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_CHECKBOX_CLICK);
		roles=addroles.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
	}
	
	public void editRolePageTitle(){
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_BUTTON_CLICK);
		addroles=roles.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ADDROLES_BUTTON_CLICK);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String role = data1.get(1).get(3);
		addroles.enterRoleName(role);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_NAME_ENTER);
		addroles.clickOnRolesCheckBox();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_CHECKBOX_CLICK);
		roles=addroles.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
		roles.enterRole(role);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_ROLE);
		editroles=roles.clickOnEditButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.EDIT_BUTTON_CLICK);
		List<ArrayList<String>> data2=ExcelUtility.excelDataReader("RolesPage");
		String expRolespageTitle = data2.get(1).get(1);
		String actRolespageTitle=editroles.getEditRolesPageTitle();
		Assert.assertEquals(expRolespageTitle,actRolespageTitle,ErrorMessages.EDIT_ROLES_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userCanDeleteRoleFromList(){
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
		roles=new RolesPage(driver);
		roles=home.clickOnRolesButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_BUTTON_CLICK);
		addroles=roles.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ADDROLES_BUTTON_CLICK);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddRolesPage");
		String role = data1.get(1).get(4);
		addroles.enterRoleName(role);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ADDROLES_BUTTON_CLICK);
		addroles.clickOnRolesCheckBox();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ROLES_CHECKBOX_CLICK);
		roles=addroles.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
		roles.enterRole(role);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_ROLE);
		roles.clickOnDeleteButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.DELETE_BUTTON_CLICK);
		roles.clickOnPopupButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.POPUP_BUTTON_CLICK);
	}
}
