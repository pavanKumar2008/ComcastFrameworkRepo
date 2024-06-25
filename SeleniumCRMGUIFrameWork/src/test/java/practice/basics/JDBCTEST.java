package practice.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class JDBCTEST {
	public static void main(String[] args) throws SQLException {
		
		Driver dref=new Driver();//mysql driver
		DriverManager.registerDriver(dref);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
		Statement stat=conn.createStatement();
		ResultSet rSet=stat.executeQuery("select * from scorecard");
		while(rSet.next()) {
			System.out.println(rSet.getString(1));
		}
		conn.close();
	   }
}
