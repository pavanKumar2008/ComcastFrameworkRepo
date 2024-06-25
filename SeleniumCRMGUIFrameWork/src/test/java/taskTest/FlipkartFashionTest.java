package taskTest;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartFashionTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		Actions act = new Actions(driver);
		WebElement fashion=driver.findElement(By.xpath("//div[@class='_1ch8e_' and contains(.,'Fashion')]"));
		act.moveToElement(fashion).perform();
		List<WebElement> mainprods=driver.findElements(By.xpath("//div[@class='_16rZTH']/object/a[contains(@class,'_1BJVlg')]"));
		List<WebElement> subprods=null;
		Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\Amazon Data.xlsx"));
		Sheet sh=wb.getSheet("flipkart");
		
		int i=0,j=0;
		for (WebElement mp : mainprods) {
			String prod1=mp.getText().toString();j=0;
			sh.createRow(i).createCell(j).setCellValue(prod1); i++;j++;
			act.moveToElement(mp).perform();
			subprods=driver.findElements(By.xpath("//div[@class='_31z7R_']/object/a[@class='_3490ry']"));
			for (WebElement sp : subprods) {
				String prod2=sp.getText().toString();
				sh.createRow(i).createCell(j).setCellValue(prod2);i++;
			}
		}
		wb.write(new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\Amazon Data.xlsx"));
		wb.close();
		Thread.sleep(2000);
		driver.quit();
	}

}