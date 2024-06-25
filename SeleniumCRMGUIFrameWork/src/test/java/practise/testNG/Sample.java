package practise.testNG;

import java.awt.Window;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {

public int CreateContacTest() {
	System.out.println("execute test1");
	return 1;
	
}

@Test(invocationCount = 2,threadPoolSize = -1)
public void CreateOrganizationTest() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");Thread.sleep(3000);
	//driver.switchTo().newWindow(WindowType.WINDOW.TAB);
	driver.get("https://www.amazon.in/");Thread.sleep(2000);
	
	driver.navigate().back();Thread.sleep(3000);
	Thread.sleep(3000);
	driver.navigate().forward();
	driver.quit();
}
}
