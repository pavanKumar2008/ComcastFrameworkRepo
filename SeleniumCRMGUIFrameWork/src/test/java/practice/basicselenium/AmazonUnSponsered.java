package practice.basicselenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonUnSponsered {
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile",Keys.ENTER);
	
	List<WebElement> allprod=driver.findElements(By.xpath("//div[@data-cy='title-recipe' and not(contains(.,'Sponsored'))]"));
	Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Amazon Data.xlsx"));
	Sheet sh=wb.getSheet("Mobiles");
	int i=0;
	System.out.println(allprod.size());
	for (WebElement prod : allprod) {
		
		System.out.println(prod.getText());
		Row row=sh.createRow(i++);
		Cell cel=row.createCell(0);
		cel.setCellValue(prod.getText());
	
	}
	Thread.sleep(8000);
	wb.write(new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\Amazon Data.xlsx"));
	wb.close();
	Thread.sleep(8000);
	driver.quit();
}
}
