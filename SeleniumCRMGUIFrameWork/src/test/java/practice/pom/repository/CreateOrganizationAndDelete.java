package practice.pom.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateOrganizationAndDelete {
// go back to org page and search for organization
	//In dynamic webtable select & delete org
	@FindBy(name="user_name")
	WebElement username;
	@FindBy(name="user_password")
	WebElement password;
	@FindBy(id="submitButton")
	WebElement loginBtn;
	@FindAll({@FindBy(name="accountname") , @FindBy(className="detailedViewTextBox")})
	WebElement orgN;
	@Test
	public void main() throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./configAppData/LoginData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String username=pObj.getProperty("login");
		String password=pObj.getProperty("password");
		Random r=new Random();
		int rint=r.nextInt(5000);
		FileInputStream fis1=new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String orgName=wb.getSheet("org").getRow(10).getCell(2).getStringCellValue()+rint;
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8483/");
	CreateOrganizationAndDelete s=PageFactory.initElements(driver, CreateOrganizationAndDelete.class);
	s.username.sendKeys(username);
	s.password.sendKeys(password);
	s.loginBtn.click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	s.orgN.sendKeys(orgName);
	driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox' and @rows='8']/../../following-sibling::tr/descendant::input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Organizations")).click();Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[text()='"+orgName+"']/ancestor::tr[@bgcolor='white']/descendant::a[contains(.,'del')]")).click();
	Thread.sleep(3000);System.out.println(orgName);
	Alert alert=driver.switchTo().alert();
	alert.accept();
	Thread.sleep(6000);
	driver.quit();
	
	
}
}
