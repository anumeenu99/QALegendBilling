package com.qalegendbilling.basetest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
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
	
	public void editUserPageTitle() throws InterruptedException {
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
		String edit=dataEdit.get(1).get(1);
		user.enterUserNameForEditing(edit);
		Thread.sleep(3000);
		edituser=user.clickOnEditButton();
		edituser=new EditUserPage(driver);
		List<ArrayList<String>> editUserPage=ExcelUtility.excelDataReader("EditUserPage");
		String expectedTitle = editUserPage.get(1).get(0);
		String actualTitle=edituser.getEditUserPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.EDIT_USER_PAGE_TITLE);
	}
	
	public void userCanEdit() throws InterruptedException {
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
		String edit=dataEdit.get(1).get(1);
		user.enterUserNameForEditing(edit);
		Thread.sleep(3000);
		edituser=user.clickOnEditButton();
		edituser=new EditUserPage(driver);
		List<ArrayList<String>> editUserPage=ExcelUtility.excelDataReader("EditUserPage");
		String lastName=editUserPage.get(1).get(2);
		edituser.enterLastName(lastName);
		user=edituser.clickOnUpdateButton();
	}
}
