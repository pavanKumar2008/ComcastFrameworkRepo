package taskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IrctcTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("IRCTC",Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='IRCTC Next Generation eTicketing System']")).click();
		//IRCTC WEBSITE
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input")).sendKeys("SBC");		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='p-highlighted-option']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/input")).sendKeys("HYB");		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='p-highlighted-option']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
		driver.findElement(By.xpath("//a[@draggable='false' and contains(.,'22')]")).click();
		driver.findElement(By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable ng-tns-c65-11 pi pi-chevron-down']")).click();
		driver.findElement(By.xpath("//span[text()='Sleeper (SL)']")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		//Search Last train Details
		Workbook wb=WorkbookFactory.create(new FileInputStream("./testData/TestScriptData.xlsx"));
		Sheet sh=wb.getSheet("IRCTC");
		List<WebElement> alltrain=driver.findElements(By.xpath("//div[@class='form-group no-pad col-xs-12 bull-back border-all']"));
		int i=1,j=0;
		for (WebElement lasttrain : alltrain) {
			if(i==alltrain.size()) {
				String Data=lasttrain.getText();
				System.out.println(Data);Thread.sleep(2000);
				sh.createRow(j).createCell(0).setCellValue(Data);
				j++;
			}
			i++;
			}
		List<WebElement> trains=driver.findElements(By.xpath("//div[@class=\"col-sm-5 col-xs-11 train-heading\"]"));
		List<WebElement> details=driver.findElements(By.xpath("//div[@class=\"white-back no-pad col-xs-12\"]"));
		i=1;j=0;
		for (WebElement lasttrain : trains) {
			if(i==trains.size()) {
				String Data=lasttrain.getText();
				System.out.println(Data);Thread.sleep(2000);
				sh.createRow(j).createCell(0).setCellValue(Data);
				j++;
			}
			i++;
			}
		i=1;
		for (WebElement lasttrain : details) {
			if(i==details.size()) {
				String Data=lasttrain.getText();
				System.out.println(Data);Thread.sleep(2000);
				sh.createRow(j).createCell(0).setCellValue(Data);
			}
			i++;
			}
		wb.write(new FileOutputStream("./testData/TestScriptData.xlsx"));
		wb.close();
		Thread.sleep(2000);
		driver.quit();
		m1();
		}
	
	
		@BeforeSuite(dependsOnMethods = "m2")
		public static void m1() {
			System.out.println("m1");
		
		}
		@BeforeSuite
		public static void m2() {
			System.out.println("m2");
		
		}
		@Test
		public  static void test() {
			System.out.println("from test");
		}
	}

