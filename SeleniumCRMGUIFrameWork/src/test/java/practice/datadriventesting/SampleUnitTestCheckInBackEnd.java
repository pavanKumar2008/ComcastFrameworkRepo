package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckInBackEnd/*Database*/ {
@Test
public void personsCheckTest() throws SQLException {
	
	String expectedPersonAdd="Maharashtra";
	boolean flag=false;
	Connection conn=null;
	try {
		
	//step 1 : load / register the database driver
		Driver driverRef=new Driver();//my sql package
		DriverManager.registerDriver(driverRef);//loading the JDBC driver
		
		//step 2 : connect to database
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid", "root", "root");
		
		 //step 3: create SQL statement
		Statement stat= conn.createStatement();
		
		//step 4:execute select query and get result
		 ResultSet rset=stat.executeQuery("select * from persons");
		while(rset.next()){//capture data from hashset
			String actPersonname=rset.getString(4);
			if(expectedPersonAdd.equals(actPersonname)) {
				flag=true;
				System.out.println(expectedPersonAdd+" is available==PASS");
			}
		}
		if(flag==false) {
			System.out.println(expectedPersonAdd+" is not available== FAIL");
		
		}
	}catch(Exception e) {
		System.out.println("Exception Handled");
	}finally  {
		//step 5:close the connection
		 conn.close();
	}
}
}
