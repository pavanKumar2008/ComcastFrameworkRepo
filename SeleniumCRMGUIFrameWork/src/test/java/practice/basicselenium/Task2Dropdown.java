package practice.basicselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task2Dropdown {
@Test
public static void main1() throws InterruptedException {
	System.out.println("Single select");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
	WebElement gender=driver.findElement(By.xpath("//select[@id='select2']"));
	Select slt=new Select(gender);
	slt.selectByIndex(1);
	Thread.sleep(4000);
	driver.quit();
}
@Test
public static void main2() throws InterruptedException {
	System.out.println("Multi select");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
	
	List<WebElement> multi=driver.findElements(By.xpath("//select[@id='select-multiple-native']"));
	int wid=1;
	for (WebElement webElement : multi) {
		Select slt=new Select(webElement);
		if(wid==1) {
		slt.selectByVisibleText("India");wid++;
		}else if(wid ==2) {
			slt.selectByVisibleText("Maharashtra");wid++;
		}else {
			slt.selectByVisibleText("Nagpur");
		}
	}
	Thread.sleep(4000);
	driver.quit();
	System.out.println("======Done======");
}
@Test
public static void main3() throws InterruptedException, AWTException {//not done
	System.out.println("Search with select");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("https://demoapps.qspiders.com/");
	driver.findElement(By.cssSelector("[class='w-[100%] h-[14.5rem] ps-7 flex flex-col justify-around p-[0.5rem] rounded  bg-[#feebfc]  hover:shadow-slate-400 shadow-lg group']")).click();
	driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
	driver.findElement(By.xpath("//a[text()='Search With Select']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("selectPhone")).sendKeys("7845124578");
	WebElement gender=driver.findElement(By.xpath("(//*[name()='svg' and @viewBox='0 0 20 20'])[2]"));
	gender.click();
	Robot r=new Robot();
	gender.sendKeys("Male",Keys.ENTER);
	List< WebElement> allselect=driver.findElements(By.xpath("//div[text()='Select']"));
	for (WebElement dd : allselect) {
		dd.click();Thread.sleep(2000);
	}
	
	System.out.println("======Pass+++++====");
}
@Test
public static void radioDefault() throws InterruptedException, AWTException {
	System.out.println("Default Radio");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/radio?sublist=0");
	driver.findElement(By.id("attended3")).click();
	driver.findElement(By.id("willin2")).click();
	driver.findElement(By.id("btn")).click();
	Thread.sleep(2000);
	driver.quit();
}
@Test
public static void radioSelected() throws InterruptedException, AWTException {
	System.out.println("Selected Radio");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/radio/selected?sublist=1");
	driver.findElement(By.id("attended55")).click();
	driver.findElement(By.id("willing5")).click();
	driver.findElement(By.xpath("//button[text()='Continue']")).submit();
	Thread.sleep(2000);
	driver.quit();
	System.out.println("+++++DONE+++++");	
}

@Test
public static void checkBox() throws InterruptedException, AWTException {
	System.out.println("Check box");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/checkbox?sublist=0");
	driver.findElement(By.id("domain2")).click();
	driver.findElement(By.id("mode2")).click();
	driver.findElement(By.id("mode5")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("mode6")).click();
	driver.quit();
	System.out.println("/*/*/*/*-Done-/*/*/*/*");
}
@Test
public static void toggle() throws InterruptedException, AWTException {
	System.out.println("toggle");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
	List <WebElement> alltog=driver.findElements(By.xpath("//span[@class='relative bg-gray-300 rounded-full w-9 h-4 transition duration-300 ease-in-out']"));
	Thread.sleep(2000);
	for (WebElement webElement : alltog) {
		webElement.click();
	}
	Thread.sleep(2000);
	driver.quit();
	
}
@Test

public static void slider() throws InterruptedException, AWTException {
	System.out.println("Slidder");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
}
}
