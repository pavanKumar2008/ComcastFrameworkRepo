package task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoonAppleTask {
public static void main(String[] args) throws Throwable  {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.noon.com/uae-en/");
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.ignoring(NoSuchElementException.class);
	//scroll down
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
	Thread.sleep(2000);
	wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	WebElement we =driver.findElement(By.xpath("//div[contains(@class,'swiper-button-next custom-navigation swiper-nav-componentArea-4-componentRow-0---recommendedProducts')]"));
	Thread.sleep(2000);
	List<WebElement> allprod=driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
	
	Thread.sleep(2000);
	Workbook ws=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.xlsx"));
	Sheet sh=ws.getSheet("Noon");
	int i=0;
	while(true) {
		for ( WebElement e : allprod) {
			if (e.getText().contains("Apple")) {
				System.out.println(e.getText());	
				sh.createRow(i).createCell(0).setCellValue(e.getText());
				i++;
			}
		}
	we.click();
	Thread.sleep(1000);
	allprod=driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
	if (we.isDisplayed()==false) {
		break;
	}
	}
	ws.write(new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.xlsx"));
	ws.close();
	driver.quit();
	System.out.println("=====Done=====");
}
}
