package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class CrickbuzzTask {
public static void main(String[] args) throws SQLException, InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.cricbuzz.com/live-cricket-scorecard/3687/ind-vs-pak-final-icc-world-t20-2007");
	//runs
	List<WebElement> runs=driver.findElements(By.xpath("//div[@id='innings_1']/div[contains(.,'India Innings')]/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-8 text-right text-bold']"));
	//Batter
	List<WebElement> batters=driver.findElements(By.xpath("//div[@id='innings_1']/div[contains(.,'India Innings')]/descendant::div[@class='cb-col cb-col-25 ']"));
	//SR
	List<WebElement> SRs=driver.findElements(By.xpath("//div[@id='innings_1']/div[contains(.,'India Innings')]/descendant::div[@class='cb-col cb-col-8 text-right' and contains(text(),'SR')]/../following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@style='padding-right:10px;']/following-sibling::div[@class='cb-col cb-col-8 text-right']"));
	
	Iterator<WebElement> itr1=runs.iterator();
	Iterator<WebElement>itr2=batters.iterator();
	Iterator<WebElement>itr3=SRs.iterator();
	//database
	Driver dmysql=new Driver();
	DriverManager.registerDriver(dmysql);
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
	Statement stat=conn.createStatement();
	while(itr1.hasNext()||itr2.hasNext()||itr3.hasNext()) {
		String r1=itr1.next().getText();
		int run=Integer.parseInt(r1);
		String batter=itr2.next().getText();
		String sr1=itr3.next().getText();
		double sr=Double.parseDouble(sr1);
		if(run<=30) {
			
			int i=stat.executeUpdate("insert into scorecard(batter,runs,sr) values ('"+batter+"','"+run+"','"+sr+"');");
			System.out.println(i);
		System.out.print(batter+"-"+run+"-"+sr);
		}
	}
	
	//write on console
	 stat=conn.createStatement();
	ResultSet result=stat.executeQuery("select * from scorecard");
	System.out.println();System.out.println();
	System.out.println("Read from database++++ABOVE 10runs ++++");
	System.out.println("Batter"+"-"+"Runs"+"-"+"SR");
	while(result.next()) {
	if(result.getInt(2)>=10) {
		System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getInt(3));
	}
	}
	Thread.sleep(1000);
	conn.close();
	Thread.sleep(1000);
	driver.quit();
	}
	
}

