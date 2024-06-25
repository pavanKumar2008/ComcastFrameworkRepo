package practice.basicselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowElement {

	@Test
	public void getShadowElementDefault() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		WebElement delem=driver.findElement(By.xpath("//div[@class='my-3' ]")).getShadowRoot()
				.findElement(By.cssSelector("input[placeholder='Enter your username']"));
		delem.click();
		delem.sendKeys("pavan@gmail.com");
		delem=driver.findElement(By.xpath("//div[@class='my-3']/following-sibling::div")).getShadowRoot()
				.findElement(By.cssSelector("input[placeholder='Enter your password']"));
		delem.click();
		delem.sendKeys("pavanekr@123");
		delem.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@Test
	public void getShadowElementDefaultClosed() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		WebElement delem=driver.findElement(By.xpath("//div[@class='my-3' ]")).getShadowRoot()
				.findElement(By.cssSelector("input[placeholder='Enter your username']"));
		delem.click();
		delem.sendKeys("pavan@gmail.com");
		delem=driver.findElement(By.xpath("//div[@class='my-3']/following-sibling::div")).getShadowRoot()
				.findElement(By.cssSelector("input[placeholder='Enter your password']"));
		delem.click();
		delem.sendKeys("pavanekr@123");
		delem.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
}
