package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTestApachiPoi {
public static void main(String[] args) throws Throwable {
	String expData="TC_04";//expected test case
	String url="",browser="",un="",pw="",org="";
	//get data from external source file
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet2");
	Cell cel=null;
	Row row=null;
	//based on condition
	int rCount=sh.getLastRowNum();
	boolean flag=false;
	for(int i=0;i<=rCount;i++) {
		String data="";
		try {
		data=sh.getRow(i).getCell(0).toString();
	if(expData.equals(data)) {
		flag=true;
		//url
		url=sh.getRow(i).getCell(6).getStringCellValue();
		System.out.println(url);
		//browser
		browser=sh.getRow(i).getCell(5).getStringCellValue();
		System.out.println(browser);
		//login data
		un=sh.getRow(i).getCell(7).getStringCellValue();
		System.out.println(un);
		pw=sh.getRow(i).getCell(8).getStringCellValue();
		System.out.println(pw);
		//generate random number
		Random random=new Random();
		int intRandom=random.nextInt(1000);
		//organization name
		org=sh.getRow(i).getCell(2).getStringCellValue()+intRandom;
		System.out.println(org);
		// to write 
		row=sh.getRow(i);
		cel=row.createCell(9);
	}
	}catch(Exception e){}
	}
	if(flag) {
	//Precondition
	WebDriver driver=null;
	if(browser.equals("Chrome")) {
		driver=new ChromeDriver();
	}else if (browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else {
			driver=new EdgeDriver();
		}
	//maximize
	driver.manage().window().maximize();
	//fetch url
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//login
	driver.findElement(By.name("user_name")).sendKeys(un);
	driver.findElement(By.name("user_password")).sendKeys(pw);
	driver.findElement(By.id("submitButton")).submit();
	//create organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(org);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	//verification
	String header=driver.findElement(By.className("dvHeaderText")).getText();
	System.out.println(header);
	if(header.contains(org)) {
		System.out.println("Verification Successful");
	}else {
		System.err.println("Verification unsuccesfull");
	}
//to write orgID in excel
	cel.removeCellComment();
	cel.setCellType(CellType.STRING);//to decide datatype
	cel.setCellValue(header);//write the data
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	wb.write(fos);
	
	//logout
	Actions act=new Actions(driver);
	WebElement logout=driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
	act.moveToElement(logout).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	Thread.sleep(2000);	
	//post condition
	wb.close();
	driver.quit();
	}else {
		System.err.println(expData+" data is not available");
	}
	System.err.println("====== Program End =======");
	}	
}


