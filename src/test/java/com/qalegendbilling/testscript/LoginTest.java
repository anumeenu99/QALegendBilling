package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.LoginBaseTest;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginTest extends LoginBaseTest{
	HomePage home;
	LoginPage login;
	UsersPage user;
	ResetPage reset;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title",groups= {"Smoke"})
	public void TC_001_verifyLoginPageTitle() {
		validateLoginPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title",groups= {"Smoke"})
	public void TC_002_verifyUserLoginWithValidUserCredentials() {
		userLoginWithValidCredentials();
	}
	
	@Test(priority = 1, enabled = true, description = "TC003 verify Invalid User Credentials",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class,groups= {"Smoke"})
	public void TC_003_verifyInvalidUserCredentials(String uname,String password) {
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expErrorMessage=data.get(1).get(3);
		login=new LoginPage(driver);
		login.enterUserName(uname);
		extentTest.get().log(Status.PASS,ExtentLogMessage.USERNAME_CLICKED);
		login.enterPassword(password);
		extentTest.get().log(Status.PASS,ExtentLogMessage.PASSWORD_CLICKED);
		login.clickOnLoginButton();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
		String actErrorMessage = login.getErrorMessage();
		extentTest.get().log(Status.PASS,ExtentLogMessage.ACTUAL_ERROR_MESSAGE);
		Assert.assertEquals(expErrorMessage, actErrorMessage, ErrorMessages.ERROR_MESSAGE_VALIDATE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.INVALID_USER_CREDENTIALS_VALIDATION);
	}
	
	@Test(priority = 1, enabled = true, description = "TC004 verify RememberMe CheckBox",groups= {"Smoke"})
	public void TC_004_verifyRememberMeCheckBox() {
		rememberMe();
	}
	
	@Test(priority = 1, enabled = true, description = "TC005 verify Reset Password",groups= {"Smoke"})
	public void TC_005_verifyResetPassword() {
		resetPassword();
	}
	
	@Test(priority = 1, enabled = true, description = "TC014 verify User Login With New User",groups= {"Smoke"})
	public void TC_014_verifyUserLoginWithNewUser() {
		newLoginUser();
	}
}
