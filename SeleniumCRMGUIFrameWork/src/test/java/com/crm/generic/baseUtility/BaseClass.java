package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	@BeforeSuite
	public void configBS() {
		System.out.println("=====Connect To DB, Report Config=====");
	}

	@BeforeClass
	public void configBC() {
		System.out.println("==Launch the Browser==");
	}

	@BeforeMethod
	public void congifBM() {
		System.out.println("==LogIn==");
	}

	@AfterMethod
	public void configAM() {
		System.out.println("==LogOut==");
	}

	@AfterClass
	public void configAC() {
		System.out.println("==Close Browser==");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("=====Close To DB, Report backUp");
	}

}
