package practice.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;//mysql driver

public class SampleTest {
public static void main(String[] args) throws SQLException {
	//step 1 : load / register the database driver
	Driver driverRef=new Driver();//my sql package
	DriverManager.registerDriver(driverRef);//loading the JDBC driver
	
	//step 2 : connect to database
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid", "root", "root");
	
	 //step 3: create SQL statement
	Statement stat= conn.createStatement();
	
	//step 4:execute select query and get result
	 ResultSet rset=stat.executeQuery("select * from persons");
	while(rset.next()){//capture data from hashset
		System.out.println(rset.getString(1)+" \t"+rset.getString(2)+"\t"+rset.getString(3)+"\t"+rset.getString(4)+"\t"+rset.getString(5));
	}
	
	//step 5:close the connection
	 conn.close();
	 
}
}
