package practice.basicselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Task6Sysnchronization {
	@Test
	public static void Sysncronization() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demoapps.qspiders.com/ui/progress?sublist=0");
		WebElement prog=driver.findElement(By.xpath("//div[@class='w-full p-4']/../div/div/div/div/div/span"));
		driver.findElement(By.xpath("//button[text()='Start']")).click();//start
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset']")).click();
		System.out.println("Status: "+prog.getText());
		driver.quit();
	}
	@Test
	public static void SysncronizationWindow() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demoapps.qspiders.com/ui/pageLoad");
		driver.findElement(By.xpath(""));
		
		driver.quit();
	}
}
