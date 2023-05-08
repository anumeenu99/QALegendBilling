package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.HomeBaseTest;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class HomeTest extends HomeBaseTest{
	HomePage home;
	LoginPage login;
	RolesPage roles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC006 verify Home Page Title",groups= {"Sanity"})
	public void TC_006_verifyHomePageTitle() {
		validateHomePageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC008 verify Whether User Is Able To Signout",groups= {"Sanity"})
	public void TC_008_verifyWhetherUserIsAbleToSignout() {
		userSignOut();
	}
	
	@Test(priority = 1, enabled = true, description = "TC009 verif yUser Management Sub Tabs",groups= {"Sanity"})
	public void TC_009_verifyUserManagementSubTabs() {
		userManagementSubTabs();
	}
	
	@Test(priority = 1, enabled = true, description = "TC009 verif yUser Management Sub Tabs",groups= {"Sanity"})
	public void TC_021_verifyRolesPageTitle(){
		rolesPageTitle();
	}
}
