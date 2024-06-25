package practice.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.neilalexander.jnacl.crypto.poly1305;

public class CreateOrg {
@Test
public void createOrg() throws InterruptedException, FileNotFoundException, IOException {
	//Random Number
	Random r=new Random();
	int rint=r.nextInt(100);
	
	//load common data from properties file
	Properties pObj=new Properties();
	pObj.load(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\LoginData.properties"));
	String url=pObj.getProperty("url");
	String login=pObj.getProperty("login");
	String password=pObj.getProperty("password");
	
	//load Test Script data from excel file
	Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\TestScriptData.xlsx"));
	Sheet sh=wb.getSheet("org");
	String orgName=sh.getRow(1).getCell(2).getStringCellValue();
	wb.close();
	//Test Script-01
	Scanner sc=new Scanner(System.in);
	String browser=sc.nextLine();
	WebDriver driver=null;//select the browser
	if(browser.contains("chrome")) {
	 driver=new ChromeDriver();
	}else if(browser.contains("firefox")) {
		driver=new FirefoxDriver();
	}else {
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
	
		//perform login operation
		driver.findElement(By.name("user_name")).sendKeys(login);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		
		//Navigate to "create New organization" page by click on "+" image
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		
		//create organization with manadatory field
		driver.findElement(By.name("accountname")).sendKeys(orgName+rint);
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();
		
		//Verify Header msg
		String Headerinfo=driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		if(Headerinfo.contains(orgName)) {
			System.out.println(orgName+" is created==PASS");
		}else {
			System.err.println(orgName+" is NOT created==FAIL");
		}
		
		//Verify OrgName info Expected result
		String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+" is created==PASS");
		}else {
			System.err.println(orgName+" is NOT created==FAIL");
		}
		
	//Signout
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out"));
	driver.quit();
	System.out.println("===Script Run Successful====");


}

@Test
public void createOrgWithIndustry() throws InterruptedException, FileNotFoundException, IOException {
	//Random Number
	Random r=new Random();
	int rint=r.nextInt(100);
	//load data from properties file
	Properties pObj=new Properties();
	pObj.load(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\LoginData.properties"));
	String url=pObj.getProperty("url");
	String login=pObj.getProperty("login");
	String password=pObj.getProperty("password");
	//load Test Script data from excel file
		Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\TestScriptData.xlsx"));
		Sheet sh=wb.getSheet("org");
		String orgName=sh.getRow(4).getCell(2).getStringCellValue();
		String industry=sh.getRow(4).getCell(3).getStringCellValue();
		String type=sh.getRow(4).getCell(4).getStringCellValue();
		wb.close();
		//Test Script -02
		Scanner sc=new Scanner(System.in);
		String browser=sc.nextLine();
		WebDriver driver=null;
		if(browser.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
		//perform login operation
		driver.findElement(By.name("user_name")).sendKeys(login);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		//Navigate to "create New organization" page by click on "+" image
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		//create organization with Industry
		driver.findElement(By.name("accountname")).sendKeys(orgName+rint);
		Select ind=new Select(driver.findElement(By.name("industry")));
		ind.selectByVisibleText(industry);
		Select typ=new Select(driver.findElement(By.name("accounttype")));
		typ.selectByVisibleText(type);
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();
		//verify industry and type
		String actIndustry=driver.findElement(By.id("mouseArea_Industry")).getText();
		if(actIndustry.equals(industry)) {
			System.out.println(industry+" is verified===PASS");
		}else {
			System.err.println(industry+" is NOT verified===FAIL");
		}
		String actType=driver.findElement(By.id("mouseArea_Type")).getText();
		if(actType.contains(type)) {
			System.out.println(type+" is verified===PASS");
		}else {
			System.out.println(type+" is NOT verified===PASS");
		}
		
	//Signout
	Thread.sleep(1000);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out"));
	driver.quit();
	System.out.println("===Script Run Successful====");
}

@Test
public void createOrgWithPhoneNumber() throws InterruptedException, FileNotFoundException, IOException {
	//Random Number
	Random r=new Random();
	int rint=r.nextInt(100);
	//load data from properties file
	Properties pObj=new Properties();
	pObj.load(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\LoginData.properties"));
	String url=pObj.getProperty("url");
	String login=pObj.getProperty("login");
	String password=pObj.getProperty("password");
	//load Test Script data from excel file
		Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\TestScriptData.xlsx"));
		Sheet sh=wb.getSheet("org");
		String orgName=sh.getRow(7).getCell(2).getStringCellValue();
		String contact=sh.getRow(7).getCell(3).toString();
		wb.close();
		
		//Test Script -03
		Scanner sc=new Scanner(System.in);
		String browser=sc.nextLine();
		WebDriver driver=null;
		if(browser.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
		//perform login operation
		driver.findElement(By.name("user_name")).sendKeys(login);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		//Navigate to "create New organization" page by click on "+" image
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		//create organization with Industry
		driver.findElement(By.name("accountname")).sendKeys(orgName+rint);
		//Contact number
		driver.findElement(By.id("phone")).sendKeys(contact);
		
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();
		//verify industry and type
		String actContact=driver.findElement(By.id("mouseArea_Phone")).getText();
		if(actContact.contains(contact)) {
			System.out.println(contact+" is verified===PASS");
		}else {
			System.err.println(contact+" is NOT verified===FAIL");
		}
		
	//Signout
	Thread.sleep(1000);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out"));
	driver.quit();
	System.out.println("===Script Run Successful====");
}
}
