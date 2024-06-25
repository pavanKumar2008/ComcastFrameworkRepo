package practice.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactTest {
@Test
public void createContact() throws InterruptedException, FileNotFoundException, IOException {
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
	Sheet sh=wb.getSheet("contact");
	String lastname=sh.getRow(1).getCell(2).getStringCellValue();
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
		
		//Navigate to "create Contact" and create by click on "+" image
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
		
		//create organization with manadatory field
		driver.findElement(By.name("lastname")).sendKeys(lastname+rint);
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();
		
		//Verify Header msg
		String Headerinfo=driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		if(Headerinfo.contains(lastname)) {
			System.out.println(lastname+" is Verified==PASS");
		}else {
			System.err.println(lastname+" is NOT created==FAIL");
		}
		
		//Verify OrgName info Expected result
		String actlastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actlastName.contains(lastname)) {
			System.out.println(lastname+" is Verified==PASS");
		}else {
			System.err.println(lastname+" is NOT created==FAIL");
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

public void createContactWithSupportDate() throws InterruptedException, FileNotFoundException, IOException {
	//Random Number
	Random r=new Random();
	int rint=r.nextInt(1000);
	
	//load common data from properties file
	Properties pObj=new Properties();
	pObj.load(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\LoginData.properties"));
	String url=pObj.getProperty("url");
	String login=pObj.getProperty("login");
	String password=pObj.getProperty("password");
	
	//load Test Script data from excel file
	Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\TestScriptData.xlsx"));
	Sheet sh=wb.getSheet("contact");
	String lastname=sh.getRow(4).getCell(2).getStringCellValue();
	wb.close();
	
	//Test Script-02
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
		
		//Navigate to "create Contact" and create by click on "+" image
		driver.findElement(By.linkText("Contacts")).click();
		//Date format
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sd.format(new Date());
		SimpleDateFormat sd1=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sd.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,+30);
		String endDate=sd1.format(cal.getTime());
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
		
		//create contact with manadatory field
		driver.findElement(By.name("lastname")).sendKeys(lastname+rint);
		//start date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		//end date
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();
		
		//Verify Start date
		String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.equals(startDate)) {
			System.out.println(startDate+ " information is verified===PASS");
		}else {
			System.out.println(startDate+ " information is NOT verified===FAIL");
		}
		
		//verfify End date
		String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.equals(endDate)) {
			System.out.println(endDate+ " information is verified===PASS");
		}else {
			System.out.println(endDate+ " information is NOT verified===FAIL");
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
public void createContactWithOrgTest() throws InterruptedException, FileNotFoundException, IOException {
	//Note:-Automate Precondition also
	
	//Random Number
	Random r=new Random();
	int rint=r.nextInt(1000);
	
	//load common data from properties file
	Properties pObj=new Properties();
	pObj.load(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\LoginData.properties"));
	String url=pObj.getProperty("url");
	String login=pObj.getProperty("login");
	String password=pObj.getProperty("password");
	
	//load Test Script data from excel file
	Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Test Scripts Data\\TestScriptData.xlsx"));
	Sheet sh=wb.getSheet("contact");
	String lastname=sh.getRow(7).getCell(2).getStringCellValue()+rint;
	String orgName=sh.getRow(7).getCell(3).getStringCellValue()+rint;
	wb.close();
	//Test Script-03 integration
	Scanner sc=new Scanner(System.in);
	String browser=sc.nextLine();
	WebDriver driver=null;                   //select the browser
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
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.cssSelector("[value='  Save  ']")).click();
				Thread.sleep(2000);
				
				//Verify contact header msg
				String Headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(Headerinfo.contains(orgName)) {
					System.out.println(orgName+" is created==PASS");
				}else {
					System.err.println(orgName+" is NOT created==FAIL");
				}
				Thread.sleep(2000);
		//Navigate to "Contact" and create by click on "+" image
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
		
		//create contact with manadatory field
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name'] /following-sibling::img")).click();
		
		//switch TO child Window
		Set<String> wids=driver.getWindowHandles();
		Iterator<String> itr=wids.iterator();
		while(itr.hasNext()) {
			String windowID=itr.next();
			driver.switchTo().window(windowID); 
			String acturl=driver.getCurrentUrl();
			if (acturl.contains("Accounts&action")) {
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.name("search_text")).sendKeys(orgName);Thread.sleep(1000);
		driver.findElement(By.name("search")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Organization Name')]/../../..//tr[2]/td/a")).click();
		
		//switch to parent
		Set<String> pwids=driver.getWindowHandles();
		Iterator<String> pitr=wids.iterator();
		while(pitr.hasNext()) {
			String windowID=pitr.next();
			driver.switchTo().window(windowID); 
			String acturl=driver.getCurrentUrl();
			if (acturl.contains("Contacts&action")) {
				break;
			}
		}
		
		driver.findElement(By.cssSelector("[value='  Save  ']")).click();Thread.sleep(2000);
		
		//Verify contact header msg
		Headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Headerinfo.contains(lastname)) {
			System.out.println(lastname+" is Created==PASS");
		}else {
			System.err.println(lastname+" is NOT created==FAIL");
		}
		
		//Verify Organization
				String actOrg=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(actOrg.contains(orgName)) {
					System.out.println(orgName+" is verified==PASS");
				}else {
					System.err.println(orgName+" is NOT verified==FAIL");
				}
				
			
	//Signout
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out"));
	driver.quit();
	System.out.println("===Script Run Successful====");


}
}
