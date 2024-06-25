package practise.testNG;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	public ExtentReports report;

	@BeforeSuite
	public void configBs() {
		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suit Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-125");
	}

	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactWithPhoneNumber() {

	}

	@Test
	public void createcontactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8483");
		//Take scrrenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);//because in my extent report to add screen shot we have to use base64

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact");
		test.log(Status.INFO, "Create Contact");
		if ("ICICI".equals("IC0CI")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath,"Errorfile");
		}
		
	}
	@Test
	public void createcontactwithOrg() {

		ExtentTest test = report.createTest("contactwithOrg");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact");
		test.log(Status.INFO, "Create Contact");
		if ("ICICI".equals("ICICI")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "Contact is not created");
		}
		
	}
	@Test
	public void createcontactwithPhoneNumber() {

		ExtentTest test = report.createTest("createcontactwithPhoneNumber");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact");
		test.log(Status.INFO, "Create Contact");
		if ("ICICI".equals("ICICI")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "Contact is not created");
		}
		
	}
}
