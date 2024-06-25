package taskTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AvedaTest {
@Test
public static void AvedaHair() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.aveda.de/");

	Actions act=new Actions(driver);
	WebElement hair=driver.findElement(By.xpath("//div[@id=\"node-6656\"]//font[text()='HAIR & SCALP']"));
	act.moveToElement(hair).perform();
	driver.findElement(By.xpath("//li[@class='menu__item menu__item--lvl-2 menu__item--category js-menu-item-category active' and contains(.,'HAIR NEEDS')]"));
	
	
}
}
