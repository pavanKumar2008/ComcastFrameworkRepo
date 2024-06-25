package taskTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTask1 {
@Test
public void main1() throws InterruptedException {
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Pavan");
	List<WebElement> all=driver.findElements(By.xpath("//div[@class=\"wM6W7d\" ]/span[contains(.,'pa') or contains(.,'Pa')]"));
	ArrayList<String> al=new ArrayList<String>();
	System.out.println(all.size());
	for (WebElement sg: all) {
		Thread.sleep(2000);
		System.out.println(sg.getText());
		al.add(sg.getText());
	}
	Collections.sort(al);
	System.out.println(al);
	System.out.println("=====>3rd index: "+al.get(3));
	driver.quit();
	
	
}
}
