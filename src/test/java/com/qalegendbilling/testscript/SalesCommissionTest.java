package com.qalegendbilling.testscript;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.basetest.SalesCommissionBaseTest;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;

public class SalesCommissionTest extends SalesCommissionBaseTest{
	HomePage home;
	LoginPage login;
	RolesPage roles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC028 verify Sales Commission Agent Page Title",groups= {"Sanity"})
	public void TC_028_verifySalesCommissionAgentPageTitle() {
		salesCommissionPageTitle();
	}
	
	@Test(priority = 1, enabled = true, description = "TC029 verify User Can Add Sales Agent",groups= {"Sanity"})
	public void TC_029_verifyUserCanAddSalesAgent() {
		userCanAddSalesAgent();
	}
	
	@Test(priority = 1, enabled = true, description = "TC030 verify User Can Edit Sales",groups= {"Sanity"})
	public void TC_030_verifyUserCanEditSales() {
		userCanEditSales();
	}
	
	@Test(priority = 1, enabled = true, description = "TC031 verify User Can Delete Sales",groups= {"Sanity"})
	public void TC_031_verifyUserCanDeleteSales() {
		userCanDeleteSales();
	}
}
