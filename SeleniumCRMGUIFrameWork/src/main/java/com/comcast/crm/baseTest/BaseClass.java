package com.comcast.crm.baseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.fileutility.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dlib=new DataBaseUtility();
	public PropertyFileUtility pflib=new PropertyFileUtility();
	public JsonUtility jsonlib=new JsonUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException 
	{
		System.out.println("=====Connect To DB, Report Config=====");
		
		dlib.getDbConnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(String Browser) throws IOException
	{
		System.out.println("==Launch the Browser==");
		String browser=Browser;
			//pflib.getDataFromProperties("browser");
		if(browser.contains("chrome")) {
			 driver=new ChromeDriver();
			}else if(browser.contains("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver=new EdgeDriver();
			}
				sdriver=driver;
	}
	
	/*
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws IOException
	{
		System.out.println("==Launch the Browser==");
		String browser=pflib.getDataFromProperties("browser");
		if(browser.contains("chrome")) {
			 driver=new ChromeDriver();
			}else if(browser.contains("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver=new EdgeDriver();
			}
		sdriver=driver;
	}
	*/
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void congifBM() throws IOException
	{
		System.out.println("==LogIn==");
		String url=pflib.getDataFromProperties("url");
		String username=pflib.getDataFromProperties("login");
		String password=pflib.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() throws InterruptedException 
	{
		System.out.println("==LogOut==");
		HomePage hp=new HomePage(driver);
		hp.perform_Signout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() throws InterruptedException 
	{
		System.out.println("==Close Browser==");
		Thread.sleep(1000);
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable
	{
		System.out.println("=====Close To DB, Report backUp");
		dlib.closeDbconnection();
		
	}
}
