package practice.basicselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example extends Task2Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		WebElement di=driver.findElement(By.xpath("(//span[@class='relative bg-gray-300 rounded-full w-9 h-4 transition duration-300 ease-in-out'])[1]"));
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("",di );
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(di));
		Thread.sleep(3000);
		//di.click();
		// TODO Auto-generated method stub
	}

}
