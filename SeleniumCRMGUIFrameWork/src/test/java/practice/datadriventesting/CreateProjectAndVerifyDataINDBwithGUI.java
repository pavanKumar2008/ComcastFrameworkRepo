package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataINDBwithGUI {
public static void main(String[] args) throws SQLException, InterruptedException {
	
	String projectName ="Instagram_02";
	boolean flag=false;
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.cssSelector("[type='submit']")).submit();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
	driver.findElement(By.name("projectName")).sendKeys(projectName);
	driver.findElement(By.name("createdBy")).sendKeys("PavanKr");
	Select slt=new Select(driver.findElement(By.name("status")));
	//slt.selectByVisibleText("On Going");
	slt.selectByIndex(0);
	driver.findElement(By.xpath("//input[@value='Add Project']")).submit();
	
	//verify the Project in Database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
			Statement stat= conn.createStatement();
			
			 ResultSet rset=stat.executeQuery("select * from project");
			while(rset.next()){
				String actProjectname=rset.getString(4);
				if(projectName.equals(actProjectname)) {
					flag=true;
					System.out.println(projectName+" is available==PASS");
				}
			}
			if(flag==false) {
				System.out.println(projectName+" is not available== FAIL");
				Assert.fail();
			}
			driver.quit();
			 conn.close();
		}
	
}


