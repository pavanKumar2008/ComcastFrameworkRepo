package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {
public static void main(String[] args) throws SQLException {
	
	Connection conn=null;
	try {
	//step 1 : load / register the database driver
	Driver driverRef=new Driver();//my sql package
	DriverManager.registerDriver(driverRef);//loading the JDBC driver
	
	//step 2 : connect to database
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid", "root", "root");
	System.out.println("====DOne=====");
	 //step 3: create SQL statement
	Statement stat= conn.createStatement();
	
	//step 4:execute Non select query and get result
	int result=stat.executeUpdate("insert into persons values('115','Rahul','TS','TS');");
	System.out.println(result);
	}catch(Exception e) {
		System.out.println("Exception Handled");
	}finally {
		
	//step 5:close the connection
	 conn.close();
	 System.out.println("==close connection==");
	}
}
}
