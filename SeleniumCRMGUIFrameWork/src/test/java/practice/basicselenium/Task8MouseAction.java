package practice.basicselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task8MouseAction {
	@Test
public static void DragAndDrop1() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("https://demoapps.qspiders.com/ui/dragDrop?sublist=0");
	WebElement drag=driver.findElement(By.xpath("//div[@class='cursor-move bg-orange-600 w-36 h-11 p-3 text-white absolute react-draggable']"));
	Actions act=new Actions(driver);
	act.dragAndDropBy(drag,1000,2000).perform();
	Thread.sleep(2000);
	driver.quit();
	
}
	@Test
	public static void DragAndDrop2() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop?sublist=0");
		WebElement d=driver.findElement(By.xpath("//div[text()='Drag Me']"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.clickAndHold(d).perform();
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	@Test
	public static void DragAndDrop3() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=1");
		Thread.sleep(2000);
		WebElement dd=driv.findElement(By.xpath("//div[text()='Mobile Charger']"));
		Actions act=new Actions(driv);
	}
	
	
	@Test
	public static void DragPosition1() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=1");
		Thread.sleep(2000);
		WebElement ma=driv.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement la=driv.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		Actions act=new Actions(driv);
		WebElement mc=driv.findElement(By.xpath("//div[text()='Mobile Cover']"));
		act.dragAndDrop(mc,ma ).perform();
		mc=driv.findElement(By.xpath("//div[text()='Mobile Charger']"));
		act.dragAndDrop(mc,ma ).perform();
		WebElement lc=driv.findElement(By.xpath("//div[text()='Laptop Charger']"));
		act.dragAndDrop(lc,la ).perform();
		lc=driv.findElement(By.xpath("//div[text()='Laptop Cover']"));
		act.dragAndDrop(lc,la ).perform();
		driv.quit();
		
	}
	
	@Test
	public static void DragMultiple() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=2");
		Thread.sleep(2000);
		Actions act=new Actions(driv);
		WebElement ma=driv.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement mc=driv.findElement(By.xpath("//div[text()='Mobile Cover']"));
		mc.click();
		act.dragAndDrop(mc, ma).perform();
		 mc=driv.findElement(By.xpath("//div[text()='Mobile Charger']"));
		 mc.click();
		 act.dragAndDrop(mc, ma).perform();
		 WebElement la=driv.findElement(By.xpath("//div[text()='Laptop Accessories']"));
			WebElement lc=driv.findElement(By.xpath("//div[text()='Laptop Charger']"));
			lc.click();
			act.dragAndDrop(lc, la).perform();
			 lc=driv.findElement(By.xpath("//div[text()='Laptop Cover']"));
			 lc.click();
			 act.dragAndDrop(lc, la).perform();
		
	}
	
	@Test
	public static void MouseHover1() {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/mouseHover?sublist=0");
		WebElement info=driv.findElement(By.xpath("//img[@class='w-5 h-5 mt-5 ml-3 cursor-pointer ']"));
		Actions act=new Actions(driv);
		act.moveToElement(info).perform();
		
	}
	@Test
	public static void MouseHover2() {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
	}
	@Test
	public static void MouseHover3() {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
	}
	@Test
	public static void MouseHover4() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/mouseHover/mouseHoverimage?sublist=1");
		Thread.sleep(2000);
		WebElement msg=driv.findElement(By.xpath("//img[@title='Order Placed Image']"));
		Actions act=new Actions(driv);
		act.moveToElement(msg).build().perform();
		Thread.sleep(3000);
		WebElement toolTipEle = driv.findElement(By.cssSelector("[alt='order placed']"));
		String tooltipText=toolTipEle.getText();
		System.out.println("Msg: "+tooltipText);
		Thread.sleep(1000);
		driv.quit();
		
		
	}
	@Test
	public static void ClickAndHold() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");
		WebElement click=driv.findElement(By.id("circle"));
		Actions act=new Actions(driv);
		act.clickAndHold().perform();
		Thread.sleep(2000);
		driv.quit();
		
		
	}
	
	@Test
	public static void others() throws AWTException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/print?sublist=0");
		driv.findElement(By.xpath("//button[text()='Print this out!']")).click();
		Robot r=new Robot();
		Set<String> wids=driv.getWindowHandles();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

	@Test
	public void clickAndHold() {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");
		WebElement clic=driver.findElement(By.xpath("//div[@id='circle']"));
		Actions act=new Actions(driver);
		act.clickAndHold(clic).perform();
		
		
	}
}
