package practice.basicselenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Task4DataAndTimePicker {
	@Test
	public static void Date1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	@Test
	public static void Date2() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/datePick/datedropdown?sublist=1");
		Thread.sleep(2000);
		driv.findElement(By.xpath("//*[name()='svg' and @viewBox='0 0 1024 1024']")).click();
		Thread.sleep(2000);
		driv.findElement(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']")).click();
		Thread.sleep(2000);
		driv.findElement(By.xpath("//div[text()='Aug']")).click();
		Thread.sleep(2000);
		driv.findElement(By.xpath("//div[text()='15']")).click();
		Thread.sleep(2000);
		driv.quit();
		
		
		
		
	}
	@Test
	public static void TimePickerDefault() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/timePick?sublist=0");
		Thread.sleep(2000);
		driv.findElement(By.xpath("//*[name()='svg' and @data-testid='ClockIcon']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driv);
		act.moveToElement(driv.findElement(By.cssSelector("[aria-label='Select hours']"))).perform();
		Thread.sleep(2000);
		driv.findElement(By.cssSelector("[aria-label='9 hours']")).click();
		Thread.sleep(2000);
		driv.findElement(By.cssSelector("[aria-label='15 minutes']")).click();
		Thread.sleep(2000);
		driv.findElement(By.cssSelector("[aria-label='AM']")).click();
		Thread.sleep(3000);
		driv.quit();
		
		
		
	}
	@Test
	public static void Time1() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
		Thread.sleep(2000);
		driv.findElement(By.cssSelector("[value='12:00 AM']")).click();
		Thread.sleep(3000);
		Actions act=new Actions(driv);
		act.click(driv.findElement(By.xpath("//span[text()='7']")));
		driv.findElement(By.xpath("//span[text()='PM']")).click();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		driv.findElement(By.xpath("//div[@class='MuiClock-squareMask css-1umqo6f']/../div[4]/span[2]")).click();
		Thread.sleep(2000);
		
		driv.findElement(By.xpath("[//button[@type='button'])[8]")).click();
		Thread.sleep(2000);
		driv.quit();
		
	}
	
}
