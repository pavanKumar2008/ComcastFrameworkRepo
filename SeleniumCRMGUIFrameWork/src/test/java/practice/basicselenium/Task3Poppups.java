package practice.basicselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Task3Poppups {
	@Test
public static void javascriptDefault() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
	driver.findElement(By.id("buttonAlert2")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	driver.quit();
	
}
	@Test
	public static void javascriptPrompt() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/alert/prompt?sublist=2");
		Thread.sleep(2000);
		driver.findElement(By.id("buttonAlert1")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("yes");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("====Done====");
		
	}
	@Test
	public static void newWindow() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		String pwid=driver.getWindowHandle();
		System.out.println(pwid);
		driver.findElement(By.id("browserLink1")).click();
		Thread.sleep(2000);
		Set<String> wid=driver.getWindowHandles();
		System.out.println(wid);
		for (String cwid : wid) {
			
			if(pwid.equals(cwid)) {
			}else {
				WebDriver nwid=driver.switchTo().window(cwid);
				Thread.sleep(2000);
				nwid.findElement(By.id("email")).sendKeys("Pavan@gmail.com",Keys.TAB,"Pavan@123",Keys.TAB
						,"Pavan@123",Keys.TAB);
				Thread.sleep(2000);
				nwid.close();
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	@Test
	public static void newTab() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browser/newTab?sublist=1");
		String ptab=driver.getWindowHandle();
		driver.findElement(By.id("browserButton4")).click();
		Thread.sleep(2000);
		Set<String> tab=driver.getWindowHandles();
		for (String ctab : tab) {
			if(ptab.equals(ctab)) {}
			else {
				WebDriver ntab=driver.switchTo().window(ctab);
				ntab.findElement(By.id("email")).sendKeys("Pavan@gmail.com",Keys.TAB
						,"Pavan@123",Keys.TAB,"Pavan@123",Keys.TAB,Keys.ENTER);
				Thread.sleep(2000);
			}
		}
		System.out.println("======Successful======");
		driver.quit();
		
	}
	@Test
	public static void multipleWindows() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		String pwid=driver.getWindowHandle();
		System.out.println(pwid);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[id='browserButton3']")).click();
		Set<String> wid=driver.getWindowHandles();
		System.out.println(wid);
		int wind=1;
		
		for (String cwid : wid) {
			WebDriver nwid=driver.switchTo().window(cwid);
			if(nwid.getCurrentUrl().contains("SignUpPage")){
				nwid=driver.switchTo().window(cwid);
						nwid.findElement(By.cssSelector("input[id='email']")).sendKeys("Pavan@123");Thread.sleep(3000);
						nwid.findElement(By.id("password")).sendKeys("Pavan@123");Thread.sleep(3000);
						nwid.findElement(By.id("confirm-password")).sendKeys("Pavan@123");Thread.sleep(2000);
						Thread.sleep(2000);
						nwid.findElement(By.xpath("//button[@type='submit']")).submit();
						Thread.sleep(3000);
						nwid.close();wind++;
						System.out.println("====Done1=====");
			}else {
				driver.switchTo().window(cwid).close();
			}
		}
		driver.quit();
		System.out.println("=====Done2=====");
		
	}
	
	@Test
	public static void Authentication() throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://admin:admin@basic-auth-git-main-shashis-projects-4fa03ca5.vercel.app/");
		
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public static void fileUpload() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/fileUpload?sublist=0");
		Thread.sleep(2000);
		driver.findElement(By.id("fileInput")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test
	public static void modal() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/modal?sublist=0");
		driver.findElement(By.xpath(""));
		driver.quit();
		
	}
	
	@Test
	public static void notification() throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browserNot?sublist=0");
		Thread.sleep(2000);
		driver.findElement(By.id("browNotButton")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
	@Test
	public static void download() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/download?sublist=0");
		driver.findElement(By.cssSelector("[placeholder='Enter text here']")).sendKeys("fsgssgd");
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	@Test
	public static void hiddenVision() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("");
		driver.findElement(By.xpath(""));
		driver.quit();
		
	}
}
