package xpathTPH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
public static void main(String[] args) {
	int date=25;
	WebDriver driver=new ChromeDriver();
	
	driver.findElement(By.xpath("//div[@class=\"react-datepicker__week\"]/child::div[text()='"+date+"']"));

}
}