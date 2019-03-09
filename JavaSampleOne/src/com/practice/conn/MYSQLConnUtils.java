package com.practice.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnUtils {

	public static Connection getMYSQLConnection() throws ClassNotFoundException, SQLException
	{
		String hostName = "den1.mysql6.gear.host";
		String dbName = "practisemysqldb";
		String userName = "practisemysqldb";
		String password = "my$ql123";
		return getMYSQLConnection(hostName, dbName, userName, password);	
	}
	
	public static Connection getMYSQLConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver"); depricated so commented
		
		// URL Connection for MySQL:
	    // Example: 
	    // jdbc:mysql://localhost:3306/simplehr
		String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
		
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
		
	}
	
}
