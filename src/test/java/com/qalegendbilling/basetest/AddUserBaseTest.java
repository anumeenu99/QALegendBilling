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
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class AddUserBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void adduserPageTitle() {
		extentTest.get().assignCategory("Regression");
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
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		List<ArrayList<String>> addUserPage=ExcelUtility.excelDataReader("AddUserDetails");
		String expectedTitle = addUserPage.get(1).get(5);
		adduser=new AddUserPage(driver);
		String actualTitle=adduser.getAddUserPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.ADD_USER_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userAddUserDetails() {
		extentTest.get().assignCategory("Regression");
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
		adduser=user.clickOnAddButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_ADD_BUTTON);
		List<ArrayList<String>> dataAddUser=ExcelUtility.excelDataReader("AddUserDetails");
		String fname=dataAddUser.get(1).get(0);
		String emailField=dataAddUser.get(1).get(1);
		//String roleField=dataAddUser.get(1).get(2);
		String usernameField=dataAddUser.get(1).get(2);
		String passField=dataAddUser.get(1).get(3);
		String confirmFiled=dataAddUser.get(1).get(4);
		adduser.enterFirstName(fname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.FIRST_NAME_ENTER);
		adduser.enterEmail(emailField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ENTER);
		//adduser.enterRole(roleField);
		adduser.enterUsername(usernameField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_ENTER);
		adduser.enterPassword(passField);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_ENTER);
		adduser.enterConfirmPassword(confirmFiled);
		extentTest.get().log(Status.PASS,ExtentLogMessage.CONFIRM_PASSWORD_ENTER);
		user=adduser.clickOnSaveButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SAVE_BUTTON_CLICK);
	}
}
