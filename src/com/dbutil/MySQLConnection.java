package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static Connection connection;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/empdb?useSSL=false";
		String username = "root";
		String password = "root1234";
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}
}

//Single Ton Java class