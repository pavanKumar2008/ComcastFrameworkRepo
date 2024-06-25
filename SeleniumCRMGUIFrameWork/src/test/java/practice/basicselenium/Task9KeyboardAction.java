package practice.basicselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.Main;
import org.testng.annotations.Test;

public class Task9KeyboardAction {
	
@Test
public static void KeyBoard() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/keyboard?sublist=0");
	driver.findElement(By.id("email")).sendKeys("Pavan kumar rajbhar");
	driver.findElement(By.id("password")).sendKeys("Qspider@123",Keys.TAB,"Qspider@123");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Press Enter to Submit']")).submit();
	driver.quit();
}

@Test
public static void VirtualKey() throws InterruptedException, AWTException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/virtual?sublist=0");
	driver.findElement(By.id("email")).sendKeys(Keys.ENTER,"Pavan@gmail.com",Keys.TAB);
	driver.findElement(By.xpath("//*[name()='path' and@d='M0 0h24v24H0V0z']")).click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_PAGE_DOWN);
	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	driver.findElement(By.xpath("//div[@data-skbtn='d']")).click();
	driver.findElement(By.xpath("//div[@data-skbtn='d']")).click();
	driver.findElement(By.xpath("//div[@data-skbtn='t']")).click();
	driver.findElement(By.xpath("//div[@data-skbtn='c']")).click();
	driver.findElement(By.xpath("//div[@data-skbtn='@']")).click();
	driver.findElement(By.xpath("//div[@data-skbtn='4']")).click();
	Thread.sleep(2000);
	r.keyPress(KeyEvent.VK_PAGE_UP);
	r.keyRelease(KeyEvent.VK_PAGE_UP);
	driver.quit();
	System.out.println("====Done+++===");
	
	
	}
}
