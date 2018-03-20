package org.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection {

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		ResourceBundle rb = ResourceBundle.getBundle("resources/dbConfig");
		Class.forName(rb.getString("jdbc.driverClassName"));
		Connection con = DriverManager.getConnection(rb.getString("jdbc.url"),
				rb.getString("jdbc.username"), rb.getString("jdbc.password"));

		System.out.println("Created DB Connection....");

		return con;

	}
}
