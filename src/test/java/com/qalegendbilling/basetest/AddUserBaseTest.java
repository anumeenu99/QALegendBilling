package com.qalegendbilling.basetest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
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
		List<ArrayList<String>> addUserPage=ExcelUtility.excelDataReader("AddUserDetails");
		String expectedTitle = addUserPage.get(1).get(5);
		adduser=new AddUserPage(driver);
		String actualTitle=adduser.getAddUserPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.ADD_USER_PAGE_TITLE);
	}
	
	public void userAddUserDetails() {
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
		List<ArrayList<String>> dataAddUser=ExcelUtility.excelDataReader("AddUserDetails");
		String fname=dataAddUser.get(1).get(0);
		String emailField=dataAddUser.get(1).get(1);
		//String roleField=dataAddUser.get(1).get(2);
		String usernameField=dataAddUser.get(1).get(2);
		String passField=dataAddUser.get(1).get(3);
		String confirmFiled=dataAddUser.get(1).get(4);
		adduser.enterFirstName(fname);
		adduser.enterEmail(emailField);
		//adduser.enterRole(roleField);
		adduser.enterUsername(usernameField);
		adduser.enterPassword(passField);
		adduser.enterConfirmPassword(confirmFiled);
		user=adduser.clickOnSaveButton();
	}
}
