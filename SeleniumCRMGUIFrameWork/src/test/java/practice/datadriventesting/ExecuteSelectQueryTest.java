package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {
public static void main(String[] args) throws SQLException {
	
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
		System.out.println(rset.getString(1)+" \t"+rset.getString(2)+"\t"+rset.getString(3)+"\t"+rset.getString(4)+"\t"+rset.getString(5));
	}
	}catch(Exception e) {
		System.out.println("Exception Handled");
	}finally {
	//step 5:close the connectionkju
	 conn.close();
	 System.out.println("=====close the connection=====");
	}
}
}
