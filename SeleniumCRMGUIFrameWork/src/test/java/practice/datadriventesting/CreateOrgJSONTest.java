package practice.datadriventesting;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgJSONTest {

	public static void main(String [] args)throws Throwable {
		
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\Pavan\\Desktop\\data\\appCommonData.json"));
		JSONObject map = (JSONObject) obj;
		
		String url=(String) map.get("url");
		String browser=(String) map.get("browser");
		String username=(String) map.get("username");
		String password=map.get("password").toString();
				 
				 
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
			System.out.println("Done");
	}
}
