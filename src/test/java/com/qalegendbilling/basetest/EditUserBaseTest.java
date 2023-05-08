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
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class EditUserBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	EditUserPage edituser;
	
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void editUserPageTitle(){
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		List<ArrayList<String>> dataEdit=ExcelUtility.excelDataReader("EditUserPage");
		String edit=dataEdit.get(1).get(1);
		user.enterUserNameForEditing(edit);
		edituser=user.clickOnEditButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.EDIT_BUTTON_CLICK);
		edituser=new EditUserPage(driver);
		List<ArrayList<String>> editUserPage=ExcelUtility.excelDataReader("EditUserPage");
		String expectedTitle = editUserPage.get(1).get(0);
		String actualTitle=edituser.getEditUserPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.EDIT_USER_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userCanEdit() {
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_USERS_TAB);
		List<ArrayList<String>> dataEdit=ExcelUtility.excelDataReader("EditUserPage");
		String edit=dataEdit.get(1).get(1);
		user.enterUserNameForEditing(edit);
		edituser=user.clickOnEditButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.EDIT_BUTTON_CLICK);
		edituser=new EditUserPage(driver);
		List<ArrayList<String>> editUserPage=ExcelUtility.excelDataReader("EditUserPage");
		String lastName=editUserPage.get(1).get(2);
		edituser.enterLastName(lastName);
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENTER_LAST_NAME);
		user=edituser.clickOnUpdateButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.UPDATE_BUTTON_CLICK);
	}
}
