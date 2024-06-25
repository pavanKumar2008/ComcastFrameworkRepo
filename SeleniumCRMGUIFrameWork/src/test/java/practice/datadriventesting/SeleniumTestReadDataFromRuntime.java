package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntime {

	@Test
	public void seleniumTest() throws Throwable {
	
		String url=System.getProperty("url");
		System.out.println("Env Data==>URL ====>"+url);
		//browser
		String browser=System.getProperty("browser");
		System.out.println("Browser Data==>Browser ====>"+browser);
		//username
		String username=System.getProperty("username");
		System.out.println("username Data==>username ====>"+username);
		//Password
		String password=System.getProperty("password");
		System.out.println("password Data==>password ====>"+password);
		
		System.out.println(browser);
		WebDriver driver=null;
		if(browser.equals("chrome")) {
		driver=new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		driver.quit();
		
	}
	
	@Test
	public void seleniumTest1() {
		System.out.println("Method 2");
		
		String url=System.getProperty("url");
		System.out.println("Env Data==>URL ====>"+url);
		//browser
		String browser=System.getProperty("browser");
		System.out.println("Browser Data==>Browser ====>"+browser);
		//username
		String username=System.getProperty("username");
		System.out.println("username Data==>username ====>"+username);
		//Password
		String password=System.getProperty("password");
		System.out.println("password Data==>password ====>"+password);
	}
	
}
