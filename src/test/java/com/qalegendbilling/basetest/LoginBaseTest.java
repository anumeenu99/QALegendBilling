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
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginBaseTest extends Base{
	HomePage home;
	LoginPage login;
	UsersPage user;
	ResetPage reset;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	public void validateLoginPageTitle() {
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expectedTitle = data.get(1).get(0);
		login=new LoginPage(driver);
		String actualTitle=login.getLoginPageTitle();
		extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_PAGE_TITLE);
		Assert.assertEquals(expectedTitle,actualTitle,ErrorMessages.LOGIN_PAGE_TITLE);
		extentTest.get().log(Status.PASS,ExtentLogMessage.TITLE_VALIDATION);
	}
	public void userLoginWithValidCredentials() {
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
	
	public void rememberMe() {
		extentTest.get().assignCategory("Smoke");	
		login=new LoginPage(driver);
		login.isSelected();
		extentTest.get().log(Status.PASS,ExtentLogMessage.REMEMBER_ME_CHECKBOX);
	}
	
	public void resetPassword() {
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
	
	public void newLoginUser() {
		//extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(1);
		String passwd=data.get(1).get(2);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		login.enterUserName(uname);
		login.enterPassword(passwd);
		login.clickLoginButton();
		login.clickOnEndTourButton();
		home.clickOnEfgpqrButton();
		login=home.clickOnSignoutButton();
		login=new LoginPage(driver);
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		String uname1=data1.get(1).get(4);
		String passwd1=data1.get(1).get(5);
		login.enterNewUserName(uname1);
		login.enterPassword(passwd1);
		home=login.clickLoginButton();
	}
}
