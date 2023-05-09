package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.AddUserBaseTest;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class AddUserTest extends AddUserBaseTest{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC015 verify Add User Page Title",groups= {"Regression"})
	public void TC_015_verifyAddUserPageTitle() {
		adduserPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC016 verify User Can Add User Details",groups= {"Regression"})
	public void TC_016_verifyUserCanAddUserDetails() {
		userAddUserDetails();
	}
}
