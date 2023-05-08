package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.UsersBaseTest;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.pages.ViewUserPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class UsersTest extends UsersBaseTest{
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddUserPage adduser;
	ViewUserPage viewuser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC010 verify Users Page Title",groups= {"Sanity"})
	public void TC_010_verifyUsersPageTitle() {
		userPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC011 verify User Search With Valid Data",groups= {"Sanity"})
	public void TC_011_verifyUserSearchWithValidData(){
		userSearchWithValidData();
	}
	
	@Test(priority = 1, enabled = true, description = "TC012 verify Message Displayed By User Search With InvalidData",groups= {"Sanity"})
	public void TC_012_verifyMessageDisplayedByUserSearchWithInvalidData() {
		messageDisplayedWithInvalidData();
	}
	
	@Test(priority = 1, enabled = true, description = "TC013 verify Error Message Displayed In Add User",groups= {"Sanity"})
	public void TC_013_verifyErrorMessageDisplayedInAddUser() {
		errorMessageDisplayed();
	}
	
	@Test(priority = 1, enabled = true, description = "TC019 verify User Can Delete A User",groups= {"Sanity"})
	public void TC_019_verifyUserCanDeleteAUser(){
		userCanDeleteUser();
	}
	
	@Test(priority = 1, enabled = true, description = "TC020 verify User Can View Use Details",groups= {"Sanity"})
	public void TC_020_verifyUserCanViewUserDetails() {
		userCanViewDetails();
	}
	
}
