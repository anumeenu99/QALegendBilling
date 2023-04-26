package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

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

public class UsersTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC010 verify Users Page Title",groups= {"Sanity"})
	public void TC_010_verifyUsersPageTitle() {
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
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("Users");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=user.getUserPageTitle();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ACTUAL_TITLE_RECEIVED);
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.USERS_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	@Test(priority = 1, enabled = true, description = "TC011 verify User Search With Valid Data",groups= {"Sanity"})
	public void TC_011_verifyUserSearchWithValidData() {
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
		user=new UsersPage(driver);
		user=home.clickOnUsersTab();
		user.clickOnAddButton();
		List<ArrayList<String>> dataAddUser=ExcelUtility.excelDataReader("AddUser");
		String fname=dataAddUser.get(1).get(0);
		String emailField=dataAddUser.get(1).get(1);
		String roleField=dataAddUser.get(1).get(2);
		String passField=dataAddUser.get(1).get(3);
		String confirmFiled=dataAddUser.get(1).get(4);
		String usernameField=dataAddUser.get(1).get(5);
		adduser.enterFirstName(fname);
		adduser.enterEmail(emailField);
		adduser.enterRole(roleField);
		adduser.enterPassword(passField);
		adduser.enterConfirmPassword(confirmFiled);
		adduser.enterUsername(usernameField);
		user=adduser.clickOnSaveButton();
		user.enterSearchField(usernameField);
	}
}
