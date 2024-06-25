package practice.basicselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task5Scroll {
	@Test
	public static void Vertical1() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driv.get("https://demoapps.qspiders.com/ui/scroll");
		String pwid=driv.getWindowHandle();
		driv.findElement(By.xpath("//a[text()='Open In New Tab']")).click();
		Set<String> wids=driv.getWindowHandles();
		for (String cwid : wids) {
			if(cwid.equals(pwid)) {}
			else {
				driv.switchTo().window(cwid);
				Actions act=new Actions(driv);
				Thread.sleep(2000);
				act.scrollByAmount(0, 1000).perform();Thread.sleep(3000);
				act.scrollByAmount(0, 1000).perform();Thread.sleep(3000);
				act.scrollByAmount(0, 1000).perform();Thread.sleep(3000);
			}
		}
		driv.quit();
		System.out.println("======Done======");
	}
	@Test
	public static void Horizontal1() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driv.get("https://demoapps.qspiders.com/ui/scroll/newHorizontal?scenario=1");
		String pwid=driv.getWindowHandle();
		driv.findElement(By.xpath("//a[text()='Open In New Tab']")).click();
		Set<String> wids=driv.getWindowHandles();
		for (String cwid : wids) {
			if(cwid.equals(pwid)) {}
			else {
				driv.switchTo().window(cwid);
		JavascriptExecutor js=(JavascriptExecutor) driv;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(1000,0);");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(1000,0);");
			}
		}
		driv.quit();
		System.out.println("=====Done====");
		
	}
	@Test
	public static void Infinite1() throws InterruptedException, AWTException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/scroll/newInfinite?scenario=1");
		String pwid=driv.getWindowHandle();
		driv.findElement(By.xpath("//a[text()='Open In New Tab']")).click();
		Set<String> wids=driv.getWindowHandles();
		for (String cwid : wids) {
			if(cwid.equals(pwid)) {}
			else {
				driv.switchTo().window(cwid);
		JavascriptExecutor js=(JavascriptExecutor) driv;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000);");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
			}
		}
		driv.quit();
		System.out.println("=====Done====");
		
		
	}
	@Test
	public static void verticalTab1() throws InterruptedException, AWTException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/scroll/vertical?scenario=2");
		driv.switchTo().frame(driv.findElement(By.tagName("iframe")));
		JavascriptExecutor js=(JavascriptExecutor) driv;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(2000);
		driv.quit();
		
	}
	@Test
	public static void horizontalTab2() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/scroll/horizontal?scenario=1");
		driv.switchTo().frame(driv.findElement(By.tagName("iframe")));
		JavascriptExecutor js=(JavascriptExecutor) driv;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(1000,0);");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(1000,0);");
		Thread.sleep(2000);
		driv.quit();
		
		
		
	}
	@Test
	public static void infnite2() {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
	}
}
