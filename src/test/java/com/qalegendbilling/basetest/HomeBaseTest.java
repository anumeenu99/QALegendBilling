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
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class HomeBaseTest extends Base{
	HomePage home;
	LoginPage login;
	RolesPage roles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	public void validateHomePageTitle() {
		extentTest.get().assignCategory("Sanity");
		login=new LoginPage(driver);
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		//login.enterUserName(uname);
		//login.enterPassword(passwd);
		login.enterLoginCredentials(uname,passwd);
		home=login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("HomePage");
		String expectedTitle=data1.get(1).get(0);
		home=new HomePage(driver);
		String actualTitle=home.getHomePageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.HOME_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	
	public void userSignOut() {
		extentTest.get().assignCategory("Sanity");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(passwd);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		login.clickLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnEfgpqrButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.PROFILE_BUTTON_CLICKED);
		login=home.clickOnSignoutButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.SIGNOUT_BUTTON_CLICKED);
	}
	
	public void userManagementSubTabs() {
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
		login.clickOnEndTourButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ENDTOUR_BUTTON_CLICKED);
		home.clickOnUsermanageSubTab();
		extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SUBTAB);
	}
	
	public void rolesPageTitle() {
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
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("RolesPage");
		String expectedTitle = data1.get(1).get(0);
		String actualTitle=roles.getRolesPageTitle();
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.ROLES_PAGE_TITLE);
	}
}
