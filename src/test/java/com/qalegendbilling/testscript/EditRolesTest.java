package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;

public class EditRolesTest {
	HomePage home;
	LoginPage login;
	RolesPage roles;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
}
