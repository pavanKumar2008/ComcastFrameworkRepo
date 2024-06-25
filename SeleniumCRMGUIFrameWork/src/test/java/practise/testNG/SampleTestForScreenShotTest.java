package practise.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners()
public class SampleTestForScreenShotTest {
@Test
public void amazonTest() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	//Step-1 create an Object to EventFiringWebDriver
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	
	//step-2 use getScreenshotAs method to get file type of screenShot
	File srcFile=edriver.getScreenshotAs(OutputType.FILE);
	
	//step-3: store screen on local drive
	FileUtils.copyFile(srcFile, new File("./screenShot/test.png"));
	
}



}
