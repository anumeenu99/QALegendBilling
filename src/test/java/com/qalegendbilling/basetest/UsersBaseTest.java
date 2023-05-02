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
import com.qalegendbilling.pages.ViewUserPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class UsersBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ViewUserPage viewuser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void userPageTitle() {
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
	
	public void userSearchWithValidData() throws InterruptedException {
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
		adduser=user.clickOnAddButton();
		List<ArrayList<String>> dataAddUser=ExcelUtility.excelDataReader("AddUser");
		String fname=dataAddUser.get(1).get(0);
		String emailField=dataAddUser.get(1).get(1);
		//String roleField=dataAddUser.get(1).get(2);
		String usernameField=dataAddUser.get(1).get(3);
		String passField=dataAddUser.get(1).get(4);
		String confirmFiled=dataAddUser.get(1).get(5);
		adduser.enterFirstName(fname);
		adduser.enterEmail(emailField);
		//adduser.enterRole(roleField);
		adduser.enterUsername(usernameField);
		adduser.enterPassword(passField);
		adduser.enterConfirmPassword(confirmFiled);
		user=adduser.clickOnSaveButton();
		Thread.sleep(4000);
		List<ArrayList<String>> dataUser=ExcelUtility.excelDataReader("Users");
		String expUsernameField=dataUser.get(1).get(3);
		user.enterUsername(expUsernameField);
	}
	
	public void messageDisplayedWithInvalidData() {
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
		List<ArrayList<String>> dataUser=ExcelUtility.excelDataReader("Users");
		String expUsernameField=dataUser.get(1).get(1);
		user.enterUsername(expUsernameField);
		String actMessage=user.getErrorMessage();
		Assert.assertEquals(expUsernameField,actMessage,ErrorMessages.USER_NOT_FOUND);
	}
	
	public void errorMessageDisplayed() {
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
		adduser=user.clickOnAddButton();
		adduser.clickOnSavebutton();
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("AddUserDetails");
		String validation=data1.get(1).get(6);
		adduser.validationMessage(validation);
	}
	
	public void userCanDeleteUser() throws InterruptedException {
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
		List<ArrayList<String>> dataEdit=ExcelUtility.excelDataReader("EditUserPage");
		String edit=dataEdit.get(1).get(3);
		user.enterUserNameToDelete(edit);
		Thread.sleep(3000);
		user.clickOnDeleteButton();
		user.clickOnPopupButton();
	}
	
	public void userCanViewDetails() throws InterruptedException {
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
		List<ArrayList<String>> dataEdit=ExcelUtility.excelDataReader("EditUserPage");
		String expviewMessage=dataEdit.get(1).get(4);
		user.enterUserNameToView(expviewMessage);
		Thread.sleep(2000);
		viewuser=user.clickOnViewButton();
		//viewuser.isDisplayed();
		String actviewMessage=viewuser.getErrorMessage();
		Assert.assertEquals(expviewMessage,actviewMessage,ErrorMessages.VIEW_EMAIL_VALIDATE);
	}
}
