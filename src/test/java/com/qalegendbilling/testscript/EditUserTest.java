package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.EditUserBaseTest;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class EditUserTest extends EditUserBaseTest{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	EditUserPage edituser;
	
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC017 verify Add User Page Title",groups= {"Sanity"})
	public void TC_017_verifyEditUserPageTitle(){
		editUserPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC018 verify User Can Edit",groups= {"Sanity"})
	public void TC_018_verifyUserCanEdit() {
		userCanEdit();
	}
}
