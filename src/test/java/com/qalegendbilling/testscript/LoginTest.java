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
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	ResetPage reset;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title",groups= {"Smoke"})
	public void TC_001_verifyLoginPageTitle() {
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expectedTitle = data.get(1).get(0);
		login=new LoginPage(driver);
		String actualTitle=login.getLoginPageTitle();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_PAGE_TITLE);
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.LOGIN_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title",groups= {"Smoke"})
	public void TC_002_verifyUserLoginWithValidUserCredentials() {
		extentTest.get().assignCategory("Smoke");
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
		extentTest.get().assignCategory("Smoke");	
		login=new LoginPage(driver);
		login.isSelected();
		extentTest.get().log(Status.PASS,ExtentLogMessage.REMEMBER_ME_CHECKBOX);
	}
	
	@Test(priority = 1, enabled = true, description = "TC005 verify Reset Password",groups= {"Smoke"})
	public void TC_005_verifyResetPassword() {
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("ResetPassword");
		String expErrorMessage=data.get(1).get(0);
		login=new LoginPage(driver);
		reset=login.clickForgetPassword();
		extentTest.get().log(Status.PASS,ExtentLogMessage.FORGET_PASSWORD_LINK);
		String resetEmail=RandomUtility.getRandomEmail();
		reset.enterEmail(resetEmail);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ENTERING);
		reset.clickOnResetLink();
		extentTest.get().log(Status.PASS,ExtentLogMessage.CLICK_RESET_LINK);
		String actMessage=login.errorMessage();
		Assert.assertEquals(expErrorMessage,actMessage,ErrorMessages.RESET_PASSWORD_VALIDATE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.EMAIL_ASSERTION);
	}
}
