package practice.basicselenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task1Table{
	
	@Test
	public static void placeholder() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Pavan kumar");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Pavan@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pavan@47");
		driver.findElement(By.xpath("//button[.='Register']")).submit();
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	@Test
	public static void button() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/button/buttonRight?sublist=1");
		Actions act=new Actions(driver); 
		WebElement btn=driver.findElement(By.xpath("//button[@id='btn30']"));
		act.contextClick(btn).perform();
		driver.findElement(By.xpath("//div[text()='Yes']")).click();
		Thread.sleep(2000);
		WebElement btn2=driver.findElement(By.xpath("//button[@id='btn32']"));
		act.contextClick(btn2).perform();
		driver.findElement(By.xpath("//div[text()='3']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
@Test
	public static void main1() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		
		WebElement price=driver.findElement(By.xpath("//th[text()='APPLEIPhone']/../td[4]"));
		System.out.println(price.getText());
		driver.quit();
	}

@Test
public static void main2() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/table/dynamicTable");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//a[@aria-current='page'])[1]")).click();
	
	WebElement price=driver.findElement(By.xpath("//th[text()='Apple iPhone']/../td[4]"));
	System.out.println(price.getText());
	driver.quit();
}

@Test
public static void main3DynamicWebTable() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/table/dynamicTable");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//a[@aria-current='page'])[1]")).click();
	
	List<WebElement> price=driver.findElements(By.xpath("//th[@scope='row']/../td[4]"));
	System.out.println(price.size());
	for (WebElement webElement : price) {
		System.out.println(webElement.getText());
	}
	driver.quit();
}

@Test
public static void main4Pagination() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/table/tablePagination");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//a[@aria-current='page'])[1]")).click();
	
	List<WebElement> price=null;
	int page=3;
	while(page>0) {
		price=driver.findElements(By.xpath("//th[@class='px-6 py-4 font-medium text-gray-900 whitespace-nowrap']"));
			for (WebElement webElement : price) {
				System.out.println(webElement.getText());
			}
			if(page==3) {
				driver.findElement(By.xpath("//li[text()='2']")).click();
			}else {
				driver.findElement(By.xpath("//li[text()='3']")).click();
			}
			page--;
	}

	driver.quit();
}

@Test
public static void main5checkbox() throws InterruptedException{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://demoapps.qspiders.com/ui/table/tableWithCheck");
Thread.sleep(2000);

driver.findElement(By.xpath("(//a[@aria-current='page'])[1]")).click();

//perform click operation
List <WebElement> click=driver.findElements(By.xpath("(//input[@type='checkbox'])"));
for (WebElement webElement : click) {
	webElement.click();
}
 System.out.println("=======Done======");
driver.quit();
}

@Test

public static void slider() throws InterruptedException{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
WebElement slider=driver.findElement(By.cssSelector("[class=' rangeInputSlidebar']"));
Actions act=new Actions(driver);
act.dragAndDropBy(slider, 100, 0).perform();

 System.out.println("=======Done======");
driver.quit();
}
}
