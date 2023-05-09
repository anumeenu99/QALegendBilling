package com.qalegendbilling.testscript;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.basetest.RolesBaseTest;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;

public class RolesTest extends RolesBaseTest{
	HomePage home;
	LoginPage login;
	RolesPage roles;
	AddRolesPage addroles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	@Test(priority = 1, enabled = true, description = "TC022 verify Add Roles Page Title",groups= {"Regression"})
	public void TC_022_verifyAddRolesPageTitle(){
		addRolesPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC023 verify Use Can Add Roles",groups= {"Regression"})
	public void TC_023_verifyUserCanAddRoles() {
		addRoles();
	}
	
	@Test(priority = 1, enabled = true, description = "TC024 verify Edit Role Page Title",groups= {"Regression"})
	public void TC_024_verifyEditRolePageTitle() {
		editRolePageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC026 verify User Can Delete A Role",groups= {"Regression"})
	public void TC_026_verifyUserCanDeleteARole() {
		userCanDeleteRoleFromList();
	}
}
