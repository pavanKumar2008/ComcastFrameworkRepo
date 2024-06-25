package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTestJava {
public static void main(String[] args) throws IOException, InterruptedException {
	//create an object to locate the physical file using FileInputStrream Class
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\commondata.properties");
	//Create an object of Properties class to load all the keys
	Properties pobj=new Properties();
	pobj.load(fis);
	//read the data using get properties
	String browser=pobj.getProperty("browser");
	String url=pobj.getProperty("url");
	String username=pobj.getProperty("username");
	String password=pobj.getProperty("password");
	String organization=pobj.getProperty("Organization");
	String website=pobj.getProperty("Website");
	String billing=pobj.getProperty("Billing");
	//read current browser
	String Browser=pobj.getProperty("browser");
	
	System.out.println(browser);
	WebDriver driver=null;
	if(browser.equals("chrome")) {
	driver=new ChromeDriver();
	}else if (browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else {
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).submit();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(organization);
	
	driver.findElement(By.name("website")).sendKeys(website);
	
	driver.findElement(By.name("bill_street")).sendKeys(billing);
	//save
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	String header=driver.findElement(By.className("dvHeaderText")).getText();
	System.out.println(header);
	//validation
	if( header.contains(organization)) {
		System.out.println("Verification Successfull");
	}else {
		System.out.println("Verfication unsuccessfull");
	}
	
	Actions act=new Actions(driver);
	WebElement logout=driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
	act.moveToElement(logout).perform();
	driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
	Thread.sleep(2000);
	driver.quit();
	
	
}
}
